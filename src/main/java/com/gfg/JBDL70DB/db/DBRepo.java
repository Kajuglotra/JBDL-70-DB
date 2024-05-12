package com.gfg.JBDL70DB.db;

import java.util.List;

public interface DBRepo {
    List<Person> getPersonsData();

    int addPerson(Person person);
}
