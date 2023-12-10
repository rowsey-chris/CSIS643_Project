package com.example.csis643_rowsey_project.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class HomePageController {

    public StackPane tagsStackPane;
    public StackPane leadsStackPane;
    @FXML
    private StackPane contentContainer; // The container to hold the content for each tab
    @FXML
    private TabPane tabPane; // The TabPane
    @FXML
    private void initialize() {
        // Set the initial selected tab to "Users"
        tabPane.getSelectionModel().select(0);
        // Call the method to show the content for the selected tab
        showUsers();
    }

    @FXML
    private void showUsers() {
        loadContent("UserView.fxml", contentContainer);
    }

    @FXML
    private void showLeads() {
        loadContent("LeadView.fxml", leadsStackPane);
    }

    private void loadContent(String fxmlFileName, StackPane stackPane) {
        try {
            String resourcePath = "/com/example/csis643_rowsey_project/" + fxmlFileName;
            // Load the content from the specified FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/csis643_rowsey_project/" + fxmlFileName));
            Parent content = loader.load();

            // Set the content in the container
            stackPane.getChildren().clear();
            stackPane.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}