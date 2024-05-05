package com.example.coderock.controller;


import com.example.coderock.model.User;
import com.example.coderock.service.serviceInfs.UserServiceInterface;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/coderock/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping(value = "/getallusers")
    public List<User> getAllUsers(){
        logger.info("finding all user list.");
        return userServiceInterface.getAllUsers();
    }

    @GetMapping(value = "/getuser/{username}")
    public User getAllUsers(@PathVariable(value = "username")String username){
        logger.info("finding the user.");
        return userServiceInterface.getUserByUserName(username);
    }

    @PostMapping(value = "/sign-up")
    public User createUser(@RequestBody User user) {
        return userServiceInterface.createUser(user);
    }

    @PutMapping(value = "/update-user")
    public Boolean updateUser(@RequestBody User user){
        return userServiceInterface.updateUser(user);
    }

    @DeleteMapping(value = "/delete-user")
    public Boolean deleteUser(@PathVariable ObjectId id){
        return userServiceInterface.deleteUser(id);
    }

}
