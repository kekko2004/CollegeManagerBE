package com.api.usercollege.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Student extends User{
    private Date registrationYear;



    public Student() {

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

    public Date getRegistrationYear() {
        return registrationYear;
    }
    public void setRegistrationYear(Date registrationYear) {
        this.registrationYear = registrationYear;
    }
}
