package com.api.usercollege.model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @Column(name = "freshman", nullable = false, unique = true, length = 16)// ST + 14 caratteri (numeri e lettere) = 16 caratteri
    private String freshman;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    private Long cell;


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
