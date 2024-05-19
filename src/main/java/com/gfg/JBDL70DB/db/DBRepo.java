package com.gfg.JBDL70DB.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DBRepo {
    List<Person> getPersonsData();
    int addPerson(Person person);

    int addPersonWithPreparedStatement(Person person);
}
