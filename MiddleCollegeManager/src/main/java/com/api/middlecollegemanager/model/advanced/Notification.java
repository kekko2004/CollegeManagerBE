package com.api.middlecollegemanager.model.advanced;

import java.util.Date;

public class Notification {
    private Long id;
    private Boolean response;
    private String stud_name;
    private String stud_surname;
    private String student;
    private Long course;
    private String course_name;
    private Date date;

    public Notification(Long id, Boolean response, String stud_name, String stud_surname, String student, Long course, String course_name, Date date) {
        this.id = id;
        this.response = response;
        this.stud_name = stud_name;
        this.stud_surname = stud_surname;
        this.student = student;
        this.course = course;
        this.course_name = course_name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getStud_surname() {
        return stud_surname;
    }

    public void setStud_surname(String stud_surname) {
        this.stud_surname = stud_surname;
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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
