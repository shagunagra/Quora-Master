package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;


/*This is question repository.*/


public interface QuestionRepository extends JpaRepository<Question, Long> {
    /*Question findByLong(Long user_id);*/
}
