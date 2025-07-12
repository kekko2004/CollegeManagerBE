package com.api.registrationrequest.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;


@MappedSuperclass // Non è un'entity! Solo struttura base
public abstract class Request {
    private Long course; // Campo ereditato
    @Column(nullable = false)
    private String student;
    private Date date;


    public Request( Long course, String student) {
        this.course = course;
        this.student = student;
        this.date = new Date();
    }

    public Request() {

    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
