package com.api.course.model;

public class Subject {
    private String id;
    private String name;
    private String categories;

    public Subject(String id, String name, String categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
