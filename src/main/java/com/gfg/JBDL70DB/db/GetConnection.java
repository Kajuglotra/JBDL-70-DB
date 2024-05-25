package com.gfg.JBDL70DB.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
// this @configuration making my class eligible to produce beans
public class GetConnection {

    // make bean of connection class
    // if i want to make a bean of pre defined class, in that case i use an annotation @Bean

    @Bean
    public Connection connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBDL_70_DB", "root", "rootroot");
            return connection;
          } catch (
                SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    @Bean
//    public DataSource dataSource (){
//        DataSource source = DataSourceBuilder.create().
//                url("jdbc:mysql://localhost:3306/JBDL_70_DB").
//                username("root").
//                password("rootroot").
//                build();
//        return source;
//    }


}
