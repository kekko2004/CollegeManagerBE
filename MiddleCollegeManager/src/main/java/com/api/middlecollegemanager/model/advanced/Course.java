package com.api.middlecollegemanager.model.advanced;

import java.util.Date;

public class Course {
    private Long id;
    private String prof_name;
    private String prof_surname;
    private String prof;
    private Date start;
    private Date end;
    private String description;
    private String department_name;
    private Long department;
    private String subject_name;
    private String subject;
    private Date subscriptionStartDay;
    private Date subscriptionEndDay;
    private boolean subscriptionOpen = true;

    public Course(Long id, String prof_name, String prof_surname, String prof, Date start, Date end, String description, String department_name, Long department, String subject_name, String subject, Date subscriptionStartDay, Date subscriptionEndDay, boolean subscriptionOpen) {
        this.id = id;
        this.prof_name = prof_name;
        this.prof_surname = prof_surname;
        this.prof = prof;
        this.start = start;
        this.end = end;
        this.description = description;
        this.department_name = department_name;
        this.department = department;
        this.subject_name = subject_name;
        this.subject = subject;
        this.subscriptionStartDay = subscriptionStartDay;
        this.subscriptionEndDay = subscriptionEndDay;
        this.subscriptionOpen = subscriptionOpen;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public boolean isSubscriptionOpen() {
        return subscriptionOpen;
    }

    public void setSubscriptionOpen(boolean subscriptionOpen) {
        this.subscriptionOpen = subscriptionOpen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String prof_name) {
        this.prof_name = prof_name;
    }

    public String getProf_surname() {
        return prof_surname;
    }

    public void setProf_surname(String prof_surname) {
        this.prof_surname = prof_surname;
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

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

}
