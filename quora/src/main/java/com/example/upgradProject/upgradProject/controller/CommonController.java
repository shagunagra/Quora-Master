package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.User;
import com.example.upgradProject.upgradProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/*This controller is for getting the user profile.*/


@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private UserRepository userRepository;
    public CommonController(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }


    @GetMapping("/userprofile/{user_id}")
    ResponseEntity<?> getusers(@PathVariable Long user_id){
        Optional<User> users = userRepository.findById(user_id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
