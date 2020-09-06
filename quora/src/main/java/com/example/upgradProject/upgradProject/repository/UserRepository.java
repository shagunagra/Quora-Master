package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
