package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.model.Lead;
import com.example.csis643_rowsey_project.service.LeadService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateLeadFormController {

    @FXML
    private TextField leadFirstNameField;
    @FXML
    private TextField leadLastNameField;
    @FXML
    private TextField leadSourceField;
    @FXML
    private TextField leadStatusField;
    @FXML
    private TextField leadNotesField;
    @FXML
    private TextField leadContactInfoField;
    private LeadService leadService;

    private Lead selectedLead;

    public void setLeadService(LeadService leadService) {
        this.leadService = leadService;
    }

    public void populateLeadForm(Lead lead) {
        // Set values from the selected lead to the form fields
        selectedLead = lead;
        if (leadFirstNameField != null) {
            leadFirstNameField.setText(selectedLead.getFirstName());
            leadLastNameField.setText(selectedLead.getLastName());
            leadContactInfoField.setText(selectedLead.getContactNumber());
            leadSourceField.setText(selectedLead.getSource());
            leadStatusField.setText(selectedLead.getStatus());
            leadNotesField.setText(selectedLead.getNotes());
        }
    }

    @FXML
    private void updateLead() {
        // Retrieve updated lead information from the form
        String firstName = leadFirstNameField.getText().trim();
        String lastName = leadLastNameField.getText().trim();
        String contactInfo = leadContactInfoField.getText().trim();
        String source = leadSourceField.getText().trim();
        String status = leadStatusField.getText().trim();
        String notes = leadNotesField.getText().trim();

        // Perform the lead update in the LeadService
        leadService.updateLead(selectedLead, firstName, lastName, contactInfo, source, status, notes);

        Stage stage = (Stage) leadFirstNameField.getScene().getWindow();

        // Close the form
        stage.close();
    }
}
