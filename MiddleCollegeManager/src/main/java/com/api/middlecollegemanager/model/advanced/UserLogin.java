package com.api.middlecollegemanager.model.advanced;

public class UserLogin {
    private String freshman;
    private String email;
    private String password;

    public UserLogin(String freshman, String email, String password) {
        this.freshman = freshman;
        this.email = email;
        this.password = password;
    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
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
}
