package com.api.middlecollegemanager.model.advanced;

import java.util.Date;

public class Booklet {
    private Long id;
    private String freshman;
    private String student;
    private String appeal_type;
    private Long course;
    private String course_name;
    private Date appeal_date;
    private Long appeal;
    private int vote;

    public Booklet(Long id, String freshman, String student, String appeal_type, Long course, String course_name, Date appeal_date, Long appeal, int vote) {
        this.id = id;
        this.freshman = freshman;
        this.student = student;
        this.appeal_type = appeal_type;
        this.course = course;
        this.course_name = course_name;
        this.appeal_date = appeal_date;
        this.appeal = appeal;
        this.vote = vote;
    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
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

    public Long getAppeal() {
        return appeal;
    }

    public void setAppeal(Long appeal) {
        this.appeal = appeal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAppeal_type() {
        return appeal_type;
    }

    public void setAppeal_type(String appeal_type) {
        this.appeal_type = appeal_type;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getAppeal_date() {
        return appeal_date;
    }

    public void setAppeal_date(Date appeal_date) {
        this.appeal_date = appeal_date;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
