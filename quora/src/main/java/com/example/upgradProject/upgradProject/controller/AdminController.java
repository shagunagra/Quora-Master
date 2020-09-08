package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*This controller part is for deleting the user by its user_id.*/


@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    public AdminController(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }

    @DeleteMapping("/admin/user/{userId}")
    ResponseEntity<?> deleteusers(@PathVariable Long user_id){
        userRepository.deleteById(user_id);
        return ResponseEntity.ok().build();
    }
}
