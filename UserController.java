package com.learning.bookMovieApplication.Controller;


import com.learning.bookMovieApplication.Entity.User;
import com.learning.bookMovieApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }




}
