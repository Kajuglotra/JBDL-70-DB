package com.gfg.JBDL70DB.db;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcRepo implements DBRepo{

    private Connection connection;

    public JdbcRepo(Connection connection){
        this.connection = connection;
        createTable();
    }

    public List<Person> getPersonsData() {
        List<Person> list = new ArrayList<>();
        // connection to db
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from person;");
            // mapping the row to the class desired the class
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

    public int addPersonWithPreparedStatement(Person person) {
        try {
            boolean currentAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =  connection.prepareStatement("insert into person (name, id) VALUES(? ,?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getId());
            int output =  preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(currentAutoCommit);
            return output;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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

