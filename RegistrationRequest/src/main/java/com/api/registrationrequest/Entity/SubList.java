package com.api.registrationrequest.Entity;

import jakarta.persistence.*;

@Entity
public class SubList extends Request{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public SubList(Long course, String student) {
        super(course, student);
    }

    public SubList(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public SubList() {
    }
}
