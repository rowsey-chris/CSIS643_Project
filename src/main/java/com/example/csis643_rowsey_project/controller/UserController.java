package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.model.User;
import com.example.csis643_rowsey_project.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController {

    @FXML
    private TableView<User> userTableView;

    private UserService userService = new UserService();

    @FXML
    private void initialize() {
        // Set the items to the TableView
        userTableView.setItems(userService.getUserList());
    }

    @FXML
    private void openAddUserForm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/csis643_rowsey_project/AddUserForm.fxml"));
        Parent root = loader.load();

        AddUserController controller = loader.getController();
        controller.setUserService(userService); // Set the UserService
        controller.setStage(new Stage());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        initialize();
    }

}
