package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Answer;
import com.example.upgradProject.upgradProject.model.User_auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_authRepository extends JpaRepository<User_auth, Long> {
    /*Answer findByName(Long user_id);*/
}
