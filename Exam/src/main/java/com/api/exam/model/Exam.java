package com.api.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Exam {
    @Id
    private Long id;
    private String freshman;
    private Long appeal;

    public Exam(Long id, String freshman, Long appeal) {
        this.id = id;
        this.freshman = freshman;
        this.appeal = appeal;
    }

    public Exam() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
    }

    public Long getAppeal() {
        return appeal;
    }

    public void setAppeal(Long appeal) {
        this.appeal = appeal;
    }
}
