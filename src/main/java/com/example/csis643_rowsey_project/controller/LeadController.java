package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.model.Lead;
import com.example.csis643_rowsey_project.service.LeadService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class LeadController {

    @FXML
    private TableView<Lead> leadTableView;

    private LeadService leadService = new LeadService();

    private Lead selectedLead;

    private ObservableList<Lead> leadList = FXCollections.observableArrayList();

    @FXML
    private Button updateLeadButton;

    @FXML
    private void initialize() {
        // Initialize the leadTableView with existing leads (if any)
        if (leadTableView != null) {
            leadTableView.setItems(leadService.getLeadList());
        }
        // Add a listener to the selection model of the table
        assert leadTableView != null;
        leadTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Enable/disable the "Update Lead" button based on whether an item is selected
            updateLeadButton.setDisable(newValue == null);
        });
    }

    @FXML
    private void createLead() {
        openAddLeadForm();
    }

    @FXML
    private void leadSelected() {
        // Get the selected lead from the table view
        selectedLead = leadTableView.getSelectionModel().getSelectedItem();
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
}