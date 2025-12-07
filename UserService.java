package com.learning.bookMovieApplication.Service;

import com.learning.bookMovieApplication.Entity.User;
import com.learning.bookMovieApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }
}
