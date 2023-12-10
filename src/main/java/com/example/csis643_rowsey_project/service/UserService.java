package com.example.csis643_rowsey_project.service;

import com.example.csis643_rowsey_project.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService {

    private ObservableList<User> userList;

    public UserService() {
        this.userList = FXCollections.observableArrayList();
    }

    public ObservableList<User> getUserList() {
        return userList;
    }

    public void addUser(String username, String password) {
        User newUser = new User(username, password);
        userList.add(newUser);
    }
}
