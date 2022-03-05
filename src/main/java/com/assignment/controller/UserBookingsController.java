package com.assignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserBookingsController implements Initializable {

    @FXML
    private TableView<?> bookingsTableView;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Utils.switchScene(event,"user.fxml",Utils.userTitle);
    }
}
