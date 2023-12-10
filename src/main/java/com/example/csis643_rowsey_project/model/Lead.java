package com.example.csis643_rowsey_project.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lead {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty contactNumber;

    private final StringProperty status;

    private final StringProperty source;

    private final StringProperty notes;

    public Lead(String firstName, String lastName, String contactNumber, String source, String status, String notes) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.contactNumber = new SimpleStringProperty(contactNumber);
        this.source = new SimpleStringProperty(source);
        this.status = new SimpleStringProperty(status);
        this.notes = new SimpleStringProperty(notes);
    }

    // Getter methods for properties
    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public String getSource() {
        return source.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getNotes() {
        return notes.get();
    }


    // Setter methods for properties
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    // Property getter methods
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty contactNumberProperty() {
        return contactNumber;
    }

    public StringProperty sourceProperty() {
        return source;
    }

    public StringProperty statusProperty() { return status; }

    public StringProperty notesProperty() { return notes; }}

