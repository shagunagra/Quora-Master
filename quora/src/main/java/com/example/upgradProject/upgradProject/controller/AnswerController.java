package com.example.upgradProject.upgradProject.controller;


import com.example.upgradProject.upgradProject.model.Answer;
import com.example.upgradProject.upgradProject.repository.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;


/*The controller is for getting the answer details using question_id of a particular question.*/


@RestController
@RequestMapping("/api")
public class AnswerController {

    private AnswerRepository answerRepository;
    public AnswerController(AnswerRepository answerRepository){
        super();
        this.answerRepository=answerRepository;
    }

    @GetMapping("/answer/all")
    Collection<Answer> answer(){
        return answerRepository.findAll();
    }

    @GetMapping("answer/all/{question_id}")
    ResponseEntity<?> getanswer(@PathVariable Long question_id){
        Optional<Answer> answer = answerRepository.findById(question_id);
        return answer.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/question/{question_id}/answer/create")
    ResponseEntity<Answer> createanswer(@Valid @RequestBody Answer answer) throws URISyntaxException {
        Answer result= answerRepository.save(answer);
        return ResponseEntity.created(new URI("/api/answer" + result.getUuid())).body(result);
    }

    @PutMapping("/answer/edit/{answer_id}")
    ResponseEntity<Answer> updateanswer(@Valid @RequestBody Answer answer){
        Answer result= answerRepository.save(answer);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/answer/delete/{answer_id}")
    ResponseEntity<?> deleteanswer(@PathVariable Long answer_id){
        answerRepository.deleteById(answer_id);
        return ResponseEntity.ok().build();
    }


}
