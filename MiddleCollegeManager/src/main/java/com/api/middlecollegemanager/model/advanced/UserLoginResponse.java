package com.api.middlecollegemanager.model.advanced;

import com.api.middlecollegemanager.model.base.user.User;

public class UserLoginResponse {
    private String response;

    private String user;

    public UserLoginResponse(String response, String user) {
        this.response = response;
       this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        user = user;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
