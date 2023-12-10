package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private UserService userService;

    // Inject the UserService through a constructor or a setter method
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void addUser() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Add the user using the UserService
        userService.addUser(username, password);

        // Close the form after adding the user
        closeForm();
    }

    private void closeForm() {
        // Retrieve the Stage associated with the current scene
        Stage stage = (Stage) usernameField.getScene().getWindow();

        // Close the Stage
        stage.close();
    }
}
