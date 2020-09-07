package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.User_auth;
import com.example.upgradProject.upgradProject.repository.User_authRepository;
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

    private User_authRepository user_authRepository;
    public User_authController(User_authRepository user_authRepository){
        super();
        this.user_authRepository=user_authRepository;
    }

    @GetMapping("/user_auth")
    Collection<User_auth> user_auth(){
        return user_authRepository.findAll();
    }

    @GetMapping("/user_auth/{id}")
    ResponseEntity<?> getuser_auth(@PathVariable Long id){
        Optional<User_auth> user_auth = user_authRepository.findById(id);
        return user_auth.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user_auth")
    ResponseEntity<User_auth> createuser_auth(@Valid @RequestBody User_auth user_auth) throws URISyntaxException {
        User_auth result= user_authRepository.save(user_auth);
        return ResponseEntity.created(new URI("/api/user_auth" + result.getUuid())).body(result);

    }

    @PutMapping("/user_auth/{id}")
    ResponseEntity<User_auth> updateuser_auth(@Valid @RequestBody User_auth user_auth){
        User_auth result= user_authRepository.save(user_auth);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/user_auth/{id}")
    ResponseEntity<?> deleteuser_auth(@PathVariable Long id){
        user_authRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
