package org.kdu.homework.controllers.saveentities;

import org.kdu.homework.dto.request.RequestTenantDTO;
import org.kdu.homework.entities.User;
import org.kdu.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
