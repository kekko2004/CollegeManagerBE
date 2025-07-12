package com.api.middlecollegemanager.model.base.user;

public class Professor extends User{
    protected String Role = "PROFESSOR";

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
