package com.assignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private MenuButton FilterMenuBtn;

    @FXML
    private Button applyBtn;

    @FXML
    private Button bookBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private ListView<?> destinationList;

    @FXML
    private DatePicker fromDate;

    @FXML
    private Slider priceSlider;

    @FXML
    private DatePicker toDate;

    @FXML
    private Button userBookingsBtn;

    @FXML
    private TableView<?> vacationsTableView;//User table doesn't contain status, only the travel agency can see that.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void applyFilter(ActionEvent event) {

    }

    @FXML
    void bookVacation(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Utils.switchScene(event,"login.fxml",Utils.loginTitle);
    }

    @FXML
    void removeFilter(ActionEvent event) {

    }

    @FXML
    void setFromDate(ActionEvent event) {

    }

    @FXML
    void setToDate(ActionEvent event) {

    }

    @FXML
    void showUserBookings(ActionEvent event) throws IOException {
        Utils.switchScene(event,"user-bookings.fxml",Utils.userBookingsTitle);
    }
}
