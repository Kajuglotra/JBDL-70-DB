package com.gfg.JBDL70DB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbController {

    @Autowired
    private DbService dbService;

    @GetMapping("/getPersons")
    public List<Person> getPersonsData(){


        return dbService.getPersonsData();
    }

    @PostMapping("/addPerson")
    public int addPerson(@RequestBody Person person) throws CustomException {
        return dbService.addPerson(person);
    }
}
