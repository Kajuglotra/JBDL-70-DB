package com.gfg.JBDL70DB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private DBRepo dbRepo;

    public List<Person> getPersonsData() {
        // business logic
        // repository
        return dbRepo.getPersonsData();
    }

    public int addPerson(Person person) {
        return dbRepo.addPerson(person);
    }
}
