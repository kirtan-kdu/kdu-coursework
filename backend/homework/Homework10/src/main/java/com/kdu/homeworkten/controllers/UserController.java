package com.kdu.homeworkten.controllers;


import com.kdu.homeworkten.entities.Person;
import com.kdu.homeworkten.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final PersonService personService;

    public UserController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllUsers(){
        return new ResponseEntity<>(personService.getAll().toString(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getUser(@RequestBody String name){
        return new ResponseEntity<>(personService.getPersonUsername(name).toString(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Person person){
        personService.addPerson(person);
        return new ResponseEntity<>("Added user successfully", HttpStatus.OK);
    }

}
