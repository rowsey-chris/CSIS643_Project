package com.example.csis643_rowsey_project.service;

import com.example.csis643_rowsey_project.model.Lead;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeadService {

    private ObservableList<Lead> leadList;

    public LeadService() {
        this.leadList = FXCollections.observableArrayList();
    }

    public ObservableList<Lead> getLeadList() {
        return leadList;
    }

    public void addLead(String firstName, String lastName, String contactInfo, String source, String status, String notes) {
        Lead newLead = new Lead(firstName, lastName, contactInfo, source, status, notes);
        leadList.add(newLead);
    }

    public void updateLead(Lead lead, String updatedFirstName, String updatedLastName, String updatedContactInfo, String updatedStatus, String updatedSource, String updatedNotes) {
        // Update lead information
        lead.setFirstName(updatedFirstName);
        lead.setLastName(updatedLastName);
        lead.setContactNumber(updatedContactInfo);
        lead.setStatus(updatedStatus);
        lead.setSource(updatedSource);
        lead.setNotes(updatedNotes);
    }
}
