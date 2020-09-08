package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.User;
import com.example.upgradProject.upgradProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;


/*This controller is for user signin and signup.*/


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    public UserController(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    Collection<User> users(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getusers(@PathVariable Long id){
        Optional<User> users = userRepository.findById(id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    ResponseEntity<User> createusers(@Valid @RequestBody User users) throws URISyntaxException {
        User result= userRepository.save(users);
        return ResponseEntity.created(new URI("/api/users" + result.getUuid())).body(result);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<User> updateusers(@Valid @RequestBody User users){
        User result= userRepository.save(users);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteusers(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}