package com.kdu.homeworkten.services;

import com.kdu.homeworkten.dao.PersonDAO;
import com.kdu.homeworkten.entities.Person;
import com.kdu.homeworkten.exceptions.custom.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonDAO personDAO;


    @Autowired
    public PersonService(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public List<Person> getAll(){
        return personDAO.getAllPersons();
    }
    public Person getPersonUsername(String name){
        for(Person p : personDAO.getAllPersons()){
            if(p.getUserName().equalsIgnoreCase(name)){
                return p;
            }
        }

        throw new CustomException("Invalid Username");
    }

}