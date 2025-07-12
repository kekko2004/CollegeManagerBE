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
    private String prof;
    private String subject;
    private Long department;

    public Course() {

    }

    public Course(Long id, Date start, Date end, String description, boolean subscriptionOpen, Date subscriptionStartDay, Date subscriptionEndDay, String prof, String subject, Long department) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
        this.subscriptionOpen = subscriptionOpen;
        this.subscriptionStartDay = subscriptionStartDay;
        this.subscriptionEndDay = subscriptionEndDay;
        this.prof = prof;
        this.subject = subject;
        this.department = department;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
