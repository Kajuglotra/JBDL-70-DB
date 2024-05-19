package com.gfg.JBDL70DB.db;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
// my_person
public class MyPerson {
    private static String temp = "temp";

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.TABLE, generator= "table-generator")
//    @TableGenerator(
//            name = "table-generator",
//            initialValue = 1,
//            allocationSize = 1
//    )
//    @GenericGenerator( name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    private Integer  id;

    private String name;

    private int age;

    @Transient
    private String password; // simple instance level variable

    @Column(unique = true)
    private String email;

    private transient String temp2 ="temp2";

    // column not to be saved in db
    @Column(name = "lName")
    // lName, l_name // snake casing
    // last_name
    private String lastName; // lName
}

// if u dont want to push one column to table, u want to keep that in classs

// 1) static variable

// 2) @Transient annotation

// 3) transient
// 4) insertable false, create a column in table, it will not insert the data into it


//create table my_person (age integer not null, email varchar(255) not null, id varchar(255) not null, l_name varchar(255), name varchar(255), primary key (id)) engine=InnoDB


//create table my_person (age integer not null, id integer not null auto_increment, email varchar(255) not null, l_name varchar(255), name varchar(255), primary key (id)) engine=InnoDB
//Hibernate:

//create table my_person (age integer not null, id integer not null, email varchar(255) not null, l_name varchar(255), name varchar(255), primary key (id)) engine=InnoDB

// identity : my underlying DB will be taking care of created the id?



// homework:

// try adding one more column by keeping ddl-auto:update

// try adding one more constraint on email, not null