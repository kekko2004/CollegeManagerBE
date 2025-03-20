package com.api.course.model;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.RequiredTypes;

import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date start;
    private Date end;
    private String description;
    private boolean subscriptionOpen;
    private Date subscriptionStartDay;
    private Date subscriptionEndDay;

    // foreign keys

    private String subject_code;
    private String prof_code;
    private Long department_code;

    public Course() {

    }

    public Course(Long id,
                  Date start,
                  Date end,
                  String description,
                  boolean subscriptionOpen,
                  Date subscriptionStartDay,
                  Date subscriptionEndDay,
                  String subject_code,
                  String prof_code,
                  Long department_code) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
        this.subscriptionOpen = subscriptionOpen;
        this.subscriptionStartDay = subscriptionStartDay;
        this.subscriptionEndDay = subscriptionEndDay;
        this.subject_code = subject_code;
        this.prof_code = prof_code;
        this.department_code = department_code;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSubscriptionOpen() {
        return subscriptionOpen;
    }

    public void setSubscriptionOpen(boolean subscriptionOpen) {
        this.subscriptionOpen = subscriptionOpen;
    }

    public Date getSubscriptionStartDay() {
        return subscriptionStartDay;
    }

    public void setSubscriptionStartDay(Date subscriptionStartDay) {
        this.subscriptionStartDay = subscriptionStartDay;
    }

    public Date getSubscriptionEndDay() {
        return subscriptionEndDay;
    }

    public void setSubscriptionEndDay(Date subscriptionEndDay) {
        this.subscriptionEndDay = subscriptionEndDay;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getProf_code() {
        return prof_code;
    }

    public void setProf_code(String prof_code) {
        this.prof_code = prof_code;
    }

    public Long getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(Long department_code) {
        this.department_code = department_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
