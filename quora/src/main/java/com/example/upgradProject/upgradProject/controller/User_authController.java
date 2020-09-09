package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.User_auth;
import com.example.upgradProject.upgradProject.repository.User_authRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class User_authController {

    @Autowired
    private User_authRepository userAuthRepository;
    public User_authController(User_authRepository userAuthRepository){
        super();
        this.userAuthRepository=userAuthRepository;
    }

    @GetMapping("/userauth/users")
    Collection<User_auth> users(){
        return userAuthRepository.findAll();
    }

    @GetMapping("/Userauth/{id}")
    ResponseEntity<?> getusers(@PathVariable Long id){
        Optional<User_auth> users = userAuthRepository.findById(id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/userauth/users")
    ResponseEntity<User_auth> createusers(@Valid @RequestBody User_auth users) throws URISyntaxException {
        User_auth result= userAuthRepository.save(users);
        return ResponseEntity.created(new URI("/api/userauth/users" + result.getUuid())).body(result);
    }

    @PutMapping("/userauth/users/{id}")
    ResponseEntity<User_auth> updateusers(@Valid @RequestBody User_auth users){
        User_auth result= userAuthRepository.save(users);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/userauth/users/{id}")
    ResponseEntity<?> deleteusers(@PathVariable Long id){
        userAuthRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}