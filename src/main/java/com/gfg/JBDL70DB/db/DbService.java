package com.gfg.JBDL70DB.db;

import jakarta.transaction.Transactional;
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
        // log should be printed
        // i want to do something
        return dbRepo.getPersonsData();
    }

    @LoggerStats
    @Transactional(rollbackOn = {Exception.class})
    public int addPerson(Person person) throws CustomException {

        // person --> myperson
        //service class

        Author author = Author.builder().
                name(person.getName()).build();
        authorRepository.save(author);
        if(author.getName().equalsIgnoreCase("name3")){
            throw new CustomException("custom exception");
        }
        try{
            MyPerson myPerson = MyPerson.
                    builder().
                    name(person.getName()).
                    email(person.getName()+"@gmail.com").
                    age(10).
                    password("abc").
                    lastName("lname").
                    build();
            MyPerson person1 = myPersonJpaRepo.save(myPerson);
            if(person1 != null){
                return 1;
            }
            System.out.println(person1.getPassword());
            return 0;
        }catch(Exception e){

        }
        return 0;

//        Person p =  jpaRepo.save(person);

//        return dbRepo.addPerson(person);
//        return dbRepo.addPersonWithPreparedStatement(person);
    }
}
