package com.kdu.assessment.service;


import com.kdu.assessment.entities.User;
import com.kdu.assessment.exception.custom.CustomException;
import com.kdu.assessment.exception.custom.InvalidArgumentsException;
import com.kdu.assessment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Slf4j
@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user)  {
        try {
            userRepository.save(user);
            log.info("Added address successfully");
        }catch (Exception ex){
            throw new InvalidArgumentsException("User details are invalid");
        }
    }

    public List<User> getAllUsers(){
        try{
            return userRepository.findAll();
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Error while fetching users");
        }
    }


    public User getPersonWithName(String name){
        for(User p : userRepository.findAll()){
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }

        throw new CustomException("Invalid Username");
    }
}
