package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.Question;
import com.example.upgradProject.upgradProject.repository.QuestionRepository;
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
public class QuestionController {

    private QuestionRepository questionRepository;
    public QuestionController(QuestionRepository questionRepository){
        super();
        this.questionRepository=questionRepository;
    }

    @GetMapping("/question/all")
    Collection<Question> question(){
        return questionRepository.findAll();
    }

    @GetMapping("question/all/{user_id}")
    ResponseEntity<?> getquestion(@PathVariable Long user_id){
        Optional<Question> question = questionRepository.findById(user_id);
        return question.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/question/create")
    ResponseEntity<Question> createquestion(@Valid @RequestBody Question question) throws URISyntaxException {
        Question result= questionRepository.save(question);
        return ResponseEntity.created(new URI("/api/question" + result.getUuid())).body(result);

    }

    @PutMapping("/question/edit/{question_id}")
    ResponseEntity<Question> updatequestion(@Valid @RequestBody Question question){
        Question result= questionRepository.save(question);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/question/delete/{question_id}")
    ResponseEntity<?> deletequestion(@PathVariable Long question_id){
        questionRepository.deleteById(question_id);
        return ResponseEntity.ok().build();
    }
}
