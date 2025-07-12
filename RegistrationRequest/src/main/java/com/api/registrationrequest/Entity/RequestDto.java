package com.api.registrationrequest.Entity;

import jakarta.persistence.*;

@Entity
public class RequestDto extends Request{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Boolean response;

    public RequestDto(Long course, String student, Long id, Boolean response) {
        super(course, student);
        this.id = id;
        this.response = response;
    }

    public RequestDto(Long course, String student) {
        super(course, student);
    }

    public RequestDto() {

    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
