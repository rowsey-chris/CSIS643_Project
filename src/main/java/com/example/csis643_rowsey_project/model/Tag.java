package com.example.csis643_rowsey_project.model;

public class Tag {
    private String name;

    // Constructors, getters, setters

    public Tag(String name) {
        this.name = name;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}