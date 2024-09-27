package org.kdu.homework.controllers;

import org.kdu.homework.dto.request.RequestTenantDTO;
import org.kdu.homework.entities.User;
import org.kdu.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(@RequestBody RequestTenantDTO requestDTO) {
        List<User> users = userService.getAllUsers(requestDTO.getTenantId());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody User user) {
        userService.updateUser(userId,user);
        return ResponseEntity.ok("User updated successfully");
    }

}
