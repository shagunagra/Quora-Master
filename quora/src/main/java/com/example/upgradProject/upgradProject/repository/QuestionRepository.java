package com.example.upgradProject.upgradProject.repository;

import com.example.upgradProject.upgradProject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
