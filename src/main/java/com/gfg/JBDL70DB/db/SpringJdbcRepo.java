package com.gfg.JBDL70DB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcRepo implements DBRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Person> getPersonsData() {
        return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Person.builder().name(rs.getString(1)).id(rs.getInt(2)).build();
//                return new Person(rs.getString(1), rs.getInt(2));
            }
        });
    }

    @Override
    public int addPerson(Person person) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name" , person.getName());
        parameterSource.addValue("id" , person.getId());
        return namedParameterJdbcTemplate.update("insert into person (name, id) VALUES(:name, :id)", parameterSource );
    }

    @Override
    public int addPersonWithPreparedStatement(Person person) {
        return 0;
    }
}
