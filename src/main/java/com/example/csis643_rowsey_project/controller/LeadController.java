package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.model.Lead;
import com.example.csis643_rowsey_project.service.LeadService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LeadController {

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
    @FXML
    private TableView<Lead> leadTableView;

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

    private LeadService leadService = new LeadService();

    private Lead selectedLead;

    private ObservableList<Lead> leadList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize the leadTableView with existing leads (if any)
        if (leadTableView != null) {
            leadTableView.setItems(leadService.getLeadList());
        }
    }

    @FXML
    private void createLead() {
        openAddLeadForm();
    }

    @FXML
    private void leadSelected() {
        // Get the selected lead from the table view
        selectedLead = leadTableView.getSelectionModel().getSelectedItem();

        // Check if a lead is selected
        if (selectedLead == null) {
            // Clear the form fields if no lead is selected
            clearLeadForm();
        }
    }

    public void populateLeadForm() {
        // Set values from the selected lead to the form fields
        System.out.println(selectedLead.getFirstName());
        if (leadFirstNameField != null) {
            leadFirstNameField.setText(selectedLead.getFirstName());
            leadLastNameField.setText(selectedLead.getLastName());
            leadContactInfoField.setText(selectedLead.getContactNumber());
            leadSourceField.setText(selectedLead.getSource());
            leadStatusField.setText(selectedLead.getStatus());
            leadNotesField.setText(selectedLead.getNotes());
        }
    }

    private void clearLeadForm() {
        leadFirstNameField.clear();
        leadLastNameField.clear();
        leadContactInfoField.clear();
        leadSourceField.clear();
        leadStatusField.clear();
        leadNotesField.clear();
    }

    private void openAddLeadForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/csis643_rowsey_project/AddLeadForm.fxml"));
            Parent root = loader.load();

            AddLeadFormController controller = loader.getController();
            controller.setLeadService(leadService);
            controller.setStage(new Stage());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openUpdateLeadForm() throws IOException {
        // Load the FXML file for the update lead form
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/csis643_rowsey_project/UpdateLeadForm.fxml"));
        Parent root = loader.load();

        UpdateLeadFormController updateleadController = loader.getController();
        updateleadController.setLeadService(leadService);

        // Create a new stage for the update form
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Lead");
        updateStage.setScene(new Scene(root));

        updateStage.setOnShown(event -> {
            updateleadController.populateLeadForm(selectedLead);
        });

        // Show the update form
        updateStage.show();


    }

    @FXML
    private void updateLead() {
        // Retrieve updated lead information from the form
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String contactInfo = contactInfoField.getText().trim();
        String source = sourceField.getText().trim();
        String status = statusField.getText().trim();
        String notes = notesField.getText().trim();

        // Perform the lead update in the LeadService
        leadService.addLead(firstName, lastName, contactInfo, source, status, notes);

        Stage stage = (Stage) firstNameField.getScene().getWindow();

        // Close the form
        stage.close();
    }
}