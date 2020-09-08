package com.example.upgradProject.upgradProject.model;

import javax.persistence.*;
import java.sql.Timestamp;


/*This is answer table.*/


@Entity
@Table(name = "answer")
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")

    private Long id;
    private String uuid;
    private String ans;
    private Timestamp date;
    private Long user_id;
    private Long question_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }
}
