package com.assignment.controller;

import com.assignment.model.VacationPackage;
import com.assignment.service.UserService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.assignment.controller.Utils.currentUser;

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
    private TableView<VacationPackage> packageTableView;//User table doesn't contain status, only the travel agency can see that.
    @FXML
    private TableColumn<VacationPackage, String> destinationCol;
    @FXML
    private TableColumn<VacationPackage, String> nameCol;
    @FXML
    private TableColumn<VacationPackage, String> priceCol;
    @FXML
    private TableColumn<VacationPackage, String> periodCol;
    @FXML
    private TableColumn<VacationPackage, String> detailCol;
    @FXML
    private TableColumn<VacationPackage, Integer> seatCol;
    private UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService(currentUser);
        configurePackageTableView();
        loadPackages();

//        loadDestinations();
    }

    private void loadPackages() {//load only bookings that are not status fully booked
        List<VacationPackage> packageList= userService.getPackages();
        packageTableView.getItems().removeAll();
        packageTableView.setItems(FXCollections.observableArrayList(packageList));
    }

    private void configurePackageTableView() {
        destinationCol.setCellValueFactory(param -> { // put the destination's name, not the object reference
            if (param.getValue() != null) {
                return new SimpleStringProperty(param.getValue().getDestination().getName());
            } else {
                return new SimpleStringProperty("<No destination>");
            }
        });
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        periodCol.setCellValueFactory(new PropertyValueFactory<>("period"));
        detailCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        seatCol.setCellValueFactory(new PropertyValueFactory<>("seats"));
    }

    @FXML
    void bookVacation(ActionEvent event) {
        userService.addPackage(currentUser,packageTableView.getSelectionModel().getSelectedItem());
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"A new booking has been added!");
        alert.showAndWait();
        loadPackages();
    }

    private void loadDestinations() {

    }

    @FXML
    void applyFilter(ActionEvent event) {

    }

    @FXML
    void removeFilter(ActionEvent event) {
        //on select deselect other filters

    }

    @FXML
    void setFromDate(ActionEvent event) {

    }

    @FXML
    void setToDate(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Utils.switchScene(event, "login.fxml", Utils.loginTitle);
    }

    @FXML
    void showUserBookings(ActionEvent event) throws IOException {
        Utils.switchScene(event, "user-bookings.fxml", Utils.userBookingsTitle);
    }
}
