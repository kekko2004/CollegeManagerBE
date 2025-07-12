package com.api.middlecollegemanager.model.base.school;

import java.util.Date;

public class Appeal {
    private Long id;
    private Date date;
    private Long course;
    private String course_name;
    private String type;

    public Appeal(Long code, Date date, Long course, String course_name, String type) {
        this.id = code;
        this.date = date;
        this.course = course;
        this.course_name = course_name;
        this.type = type;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
