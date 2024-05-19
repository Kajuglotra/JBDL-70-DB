package com.gfg.JBDL70DB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    @Qualifier("springJdbcRepo")
    private DBRepo dbRepo;

    @Autowired
    private MyPersonJpaRepo myPersonJpaRepo;

    @Autowired

    private AuthorRepository authorRepository;



    public List<Person> getPersonsData() {
        // business logic
        // repository
        return dbRepo.getPersonsData();
    }

    public int addPerson(Person person) {

        // person --> myperson
        //service class

        Author author = Author.builder().
                name(person.getName()).build();
        authorRepository.save(author);


        MyPerson myPerson = MyPerson.
                builder().
                name(person.getName()).
                email(person.getName()+"@gmail.com").
                age(10).
                password("abc").
                lastName("lname").
                build();

        MyPerson person1 = myPersonJpaRepo.save(myPerson);
//        Person p =  jpaRepo.save(person);
        if(person1 != null){
            return 1;
        }
        System.out.println(person1.getPassword());
        return 0;
//        return dbRepo.addPerson(person);
//        return dbRepo.addPersonWithPreparedStatement(person);
    }
}
