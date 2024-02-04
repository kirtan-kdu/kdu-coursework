package com.kdu.smarthome.dataloader;

import com.kdu.smarthome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StartUpDataLoader implements CommandLineRunner {

    PasswordEncoder passwordEncoder;

    UserService userService;

    @Autowired
    public StartUpDataLoader(UserService userService, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    /**
     * Add the desired super users here
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {// default method to add users beforehand
    }
}
