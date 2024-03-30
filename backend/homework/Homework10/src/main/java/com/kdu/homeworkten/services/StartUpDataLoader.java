package com.kdu.homeworkten.services;

import com.kdu.homeworkten.dao.PersonDAO;
import com.kdu.homeworkten.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StartUpDataLoader implements CommandLineRunner {

    PersonDAO personDAO;

    PasswordEncoder passwordEncoder;

    @Autowired
    public StartUpDataLoader(PersonDAO personDAO, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.personDAO = personDAO;
    }
    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("Rishav Chakraborty", "rishav", passwordEncoder.encode("rishav123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Kirtan Shah", "kirtan", passwordEncoder.encode("kirtan123"), "ROLE_USER"));
    }
}

