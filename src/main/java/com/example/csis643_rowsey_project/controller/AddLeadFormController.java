package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.service.LeadService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLeadFormController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField contactInfoField;

    @FXML
    private TextField sourceField;

    @FXML
    private TextField statusField;

    @FXML
    private TextField notesField;

    private LeadService leadService;


    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLeadService(LeadService leadService) {
        this.leadService = leadService;
    }


    @FXML
    private void addLead() {
        // Get data from text fields
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String contactInfo = contactInfoField.getText().trim();
        String source = sourceField.getText().trim();
        String status = statusField.getText().trim();
        String notes = notesField.getText().trim();

        // Validate input
        if (firstName.isEmpty() || lastName.isEmpty()) {
            // Show an error message or handle invalid input
            return;
        }

        // Call the createLead method in the LeadController
        leadService.addLead(firstName, lastName, contactInfo, source, status, notes);

        Stage stage = (Stage) firstNameField.getScene().getWindow();

        // Close the form
        stage.close();
    }
}