package com.api.appeal.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long course;
    private Type type;
    private Date date;


    public Appeal() {
    }

    public Appeal(Long id, Long course, Type type, Date date) {
        this.id = id;
        this.course = course;
        this.type = type;
        this.date = date;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
