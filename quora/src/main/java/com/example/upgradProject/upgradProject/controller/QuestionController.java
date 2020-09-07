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

    @GetMapping("/question")
    Collection<Question> question(){
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    ResponseEntity<?> getquestion(@PathVariable Long id){
        Optional<Question> question = questionRepository.findById(id);
        return question.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/question")
    ResponseEntity<Question> createquestion(@Valid @RequestBody Question question) throws URISyntaxException {
        Question result= questionRepository.save(question);
        return ResponseEntity.created(new URI("/api/question" + result.getUuid())).body(result);

    }

    @PutMapping("/question/{id}")
    ResponseEntity<Question> updatequestion(@Valid @RequestBody Question question){
        Question result= questionRepository.save(question);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/question/{id}")
    ResponseEntity<?> deletequestion(@PathVariable Long id){
        questionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
