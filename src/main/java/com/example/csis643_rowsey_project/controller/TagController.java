package com.example.csis643_rowsey_project.controller;

import com.example.csis643_rowsey_project.model.Tag;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TagController {

    @FXML
    private ListView<String> tagListView;
    @FXML
    private TextField tagNameField;

    private List<Tag> tagList = new ArrayList<>();

    @FXML
    private void initialize() {
        // Initialize the tagListView with existing tags (if any)
        updateListView();
    }

    @FXML
    private void createTag() {
        // Get data from text field
        String tagName = tagNameField.getText().trim();

        // Validate input
        if (tagName.isEmpty()) {
            // Show an error message or handle invalid input
            return;
        }

        // Create a new tag
        Tag newTag = new Tag(tagName);

        // Add the tag to the list
        tagList.add(newTag);

        // Update the tagListView
        updateListView();

        // Clear input field
        tagNameField.clear();
    }

    private void updateListView() {
        // Clear the existing items in the tagListView
        tagListView.getItems().clear();

        // Add each tag's information to the tagListView
        for (Tag tag : tagList) {
            tagListView.getItems().add(tag.toString());
        }
    }
}
