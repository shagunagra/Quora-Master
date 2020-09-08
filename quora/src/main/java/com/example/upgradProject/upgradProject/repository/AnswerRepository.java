package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;


/*This is answer repository.*/


public interface AnswerRepository extends JpaRepository<Answer, Long> {
    /*Answer findByLong(Long user_id);*/
}
