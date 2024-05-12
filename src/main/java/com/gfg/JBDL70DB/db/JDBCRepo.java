package com.gfg.JBDL70DB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCRepo implements DBRepo{

    private Connection connection;

    public JDBCRepo(Connection connection){
        this.connection = connection;
        createTable();
    }

    public List<Person> getPersonsData() {
        List<Person> list = new ArrayList<>();
        // connection to db
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from person;");
            while (resultSet.next()){
                Person p = new Person(resultSet.getString(1), resultSet.getInt(2) );
                list.add(p);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public int addPerson(Person person) {
        try {
            return connection.createStatement().executeUpdate("insert into person (name, id) VALUES('" + person.getName() + "'," + person.getId() + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void createTable() {
        try {
            connection.createStatement().execute("create table if not exists person ( name varchar(25) , id int ) ");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
// db repo -> interface
// interface  -> implementations

