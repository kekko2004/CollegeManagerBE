package com.api.registrationrequest.Entity;

import java.util.Date;

public class SubListDto {
    private Long id;
    private String student;
    private Long course;
    private Date date;

    public SubListDto(Long id, String student, Long course, Date date) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
