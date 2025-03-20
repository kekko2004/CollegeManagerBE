package com.api.usercollege.model;

import com.api.usercollege.service.FreshmanService;
import com.api.usercollege.service.UserService;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student extends User{
    private LocalDate registrationYear;
    @Transient // Indica che questo campo non è persistito nel database
    private final FreshmanService freshmanService = new FreshmanService();
    public Student() {
        super.setFreshman(this.freshmanService.generateFreshmanCode("ST"));
    }

    public String getFreshman() {
        return super.getFreshman(); // Restituisce il codice generico come freshman
    }
    public void setFreshman(String freshman) {
        if (freshman == null || !freshman.matches("^ST[A-Z0-9]{14}$")) {
            throw new IllegalArgumentException("Il codice freshman deve iniziare con 'ST' e avere 14 caratteri alfanumerici.");
        }
        super.setFreshman(freshman); // Imposta il codice generico come freshman
    }

    public LocalDate getRegistrationYear() {
        return registrationYear;
    }
    public void setRegistrationYear(LocalDate registrationYear) {
        this.registrationYear = registrationYear;
    }
}
