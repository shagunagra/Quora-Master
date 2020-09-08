package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    /*Answer findByName(Long user_id);*/
}
