package com.api.booklet.entity;

import jakarta.persistence.*;

@Entity
public class Booklet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String freshman;
    private Long appeal;
    private int vote;

    public Booklet() {
    }

    public Booklet(Long id, String freshman, Long appeal, int vote) {
        this.id = id;
        this.freshman = freshman;
        this.appeal = appeal;
        this.vote = vote;
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

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
