package com.api.middlecollegemanager.model.base.school;

public class Subject {
    private String code;
    private String subject;

    public Subject(String code, String subject) {
        this.code = code;
        this.subject = subject;
    }

    public Subject() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
