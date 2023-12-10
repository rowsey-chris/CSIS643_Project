package com.example.csis643_rowsey_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Lead Management Module");
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/com/example/csis643_rowsey_project/HomePage.fxml"));
        Parent homeRoot = homeLoader.load();
        primaryStage.setScene(new Scene(homeRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}