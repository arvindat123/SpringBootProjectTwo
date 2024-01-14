package com.learning.technology.controller;

import com.learning.technology.model.User;
import com.learning.technology.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/topup-process-service")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path="/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user){
        logger.info("Inside saveUser method");
        return userService.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String address){
        return userService.getUserByAddress(address);
    }

    @DeleteMapping(value="/remove")
    public User removeUser(@RequestBody User user){
        userService.deleteUser(user);
        return user;
    }

}
