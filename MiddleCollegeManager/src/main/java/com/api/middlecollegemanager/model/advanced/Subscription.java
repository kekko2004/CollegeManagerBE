package com.api.middlecollegemanager.model.advanced;

import java.util.Date;

public class Subscription {
    private Long id;
    private Long course;
    private String student;
    private String student_name;
    private String student_surname;
    private Date date;

    public Subscription(Long id, Long course, String student, String student_name, String student_surname, Date date) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.date = date;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
