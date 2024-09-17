package com.kdu.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StartUpDataLoader implements CommandLineRunner {

    UserService userService;

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public StartUpDataLoader(UserService userService){
        this.userService = userService;
    }
    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User();
//        user1.setName("rishav");
//        user1.setEmail("rishav@gmail.com");
//        user1.setPassword(passwordEncoder().encode("rishav@123"));
//        user1.setRole("ROLE_ADMIN");
//        userService.addUser(user1);
//
//        User user2 = new User();
//        user2.setName("kirtan");
//        user2.setEmail("kirtan@gmail.com");
//        user2.setPassword(passwordEncoder().encode("kirtan@123"));
//        user2.setRole("ROLE_USER");
//        userService.addUser(user2);
    }
}
