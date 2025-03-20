package com.api.usercollege.model;

import com.api.usercollege.service.FreshmanService;
import com.api.usercollege.service.UserService;
import jakarta.persistence.*;

@Entity
public class Professor extends User {

    private Role role;

    @Transient // Indica che questo campo non è persistito nel database
    private final FreshmanService freshmanService = new FreshmanService();
    // Costruttore
    public Professor() {

        super.setFreshman(freshmanService.generateFreshmanCode("PR"));
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getFreshman() {
        return super.getFreshman();
    }
//la F grande serve per non confedere le due variabili tra User e Professor
    public void setFreshman(String Freshman) {
        if (Freshman == null || !Freshman.matches("^PR[A-Z0-9]{14}$")) {
            throw new IllegalArgumentException("Il Freshman deve iniziare con 'PR' e avere 14 caratteri alfanumerici.");
        }
        super.setFreshman(Freshman);
    }
}