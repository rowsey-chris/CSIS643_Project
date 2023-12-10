module com.example.csis643_rowsey_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.csis643_rowsey_project to javafx.fxml;
    opens com.example.csis643_rowsey_project.model to javafx.base; // Open the controller package
    opens com.example.csis643_rowsey_project.controller to javafx.fxml; // Open the controller package
    exports com.example.csis643_rowsey_project.controller;
    exports com.example.csis643_rowsey_project.service;
    exports com.example.csis643_rowsey_project;
}