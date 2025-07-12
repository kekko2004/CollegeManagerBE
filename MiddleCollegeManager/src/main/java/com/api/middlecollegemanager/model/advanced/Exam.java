package com.api.middlecollegemanager.model.advanced;

import java.util.Date;

public class Exam {
    private Long id;
    private Long appeal;
    private String appeal_type;
    private Date date;
    private String freshman;
    private Long course;
    private String course_name;

    public Exam() {
    }

    public Exam(Long id, Long appeal, String appeal_type, Date date, String freshman, Long course, String course_name) {
        this.id = id;
        this.appeal = appeal;
        this.appeal_type = appeal_type;
        this.date = date;
        this.freshman = freshman;
        this.course = course;
        this.course_name = course_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppeal() {
        return appeal;
    }

    public void setAppeal(Long appeal) {
        this.appeal = appeal;
    }

    public String getAppeal_type() {
        return appeal_type;
    }

    public void setAppeal_type(String appeal_type) {
        this.appeal_type = appeal_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
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
}
