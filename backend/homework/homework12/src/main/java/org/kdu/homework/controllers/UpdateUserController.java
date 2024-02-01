package org.kdu.homework.controllers;


import org.kdu.homework.entities.User;
import org.kdu.homework.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UpdateUserController {

    private final UserService userService;

    public UpdateUserController(UserService userService){
        this.userService = userService;
    }
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody User user) {
        userService.updateUser(userId,user);
        return ResponseEntity.ok("User updated successfully");
    }
}
