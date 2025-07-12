package com.api.middlecollegemanager.model.base.user;


import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    protected String freshman;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected Long cell;


    public User() {
    }

    public User(String name, String surname, String email, String password, Long cell) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cell = cell;
    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCell() {
        return cell;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

}