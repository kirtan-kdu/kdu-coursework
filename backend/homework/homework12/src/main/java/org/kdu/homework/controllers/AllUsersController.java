package org.kdu.homework.controllers;


import org.kdu.homework.entities.User;
import org.kdu.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all-users")
public class AllUsersController {

    private final UserService userService;

    @Autowired
    public AllUsersController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("")
    public Page<User> findAllUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "50") int size){
        pageNo = Math.max(0, pageNo);
        size = Math.min(50, Math.max(1, size));
        PageRequest pageable = PageRequest.of(pageNo, size);
        return userService.getAllUsersPagination(pageable);
    }
}
