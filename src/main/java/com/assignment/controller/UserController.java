package com.assignment.controller;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.service.UserService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button applyDestinationBtn;

    @FXML
    private ListView<Destination> destinationListView;

    @FXML
    private Button applyPriceBtn;

    @FXML
    private TextField priceFieldMin;

    @FXML
    private TextField priceFieldMax;

    @FXML
    private Button applyPeriodBtn;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

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
        loadDestinations();
    }

    private void loadPackages() {//load only bookings that are not status fully booked or booked by the user
        List<VacationPackage> packageList = userService.getUserPackages();
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
        userService.addPackage(currentUser, packageTableView.getSelectionModel().getSelectedItem());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "A new booking has been added!");
        alert.showAndWait();
        loadPackages();
    }

    private void loadDestinations() {
        List<Destination> destinationList = userService.viewDestinations();
        destinationListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Destination destination, boolean empty) {
                super.updateItem(destination, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = destination.getName();
                    setText(text);
                }
            }
        });
        ObservableList<Destination> observableList = FXCollections.observableList(destinationList);
        destinationListView.setItems(observableList);
    }

    @FXML
    void applyDestinationFilter(ActionEvent event) {
        Destination destination = destinationListView.getSelectionModel().getSelectedItem();
        List<VacationPackage> resultList = userService.filterByDestination(packageTableView.getItems(), destination);
        ObservableList<VacationPackage> observableList = FXCollections.observableList(resultList);
        packageTableView.setItems(observableList);
    }

    @FXML
    void applyPriceFilter(ActionEvent event) {
        int priceLow = Integer.parseInt(priceFieldMin.getText());
        int priceHigh = Integer.parseInt(priceFieldMax.getText());
        List<VacationPackage> resultList = userService.filterByPrice(packageTableView.getItems(), priceLow, priceHigh);
        ObservableList<VacationPackage> observableList = FXCollections.observableList(resultList);
        packageTableView.setItems(observableList);
    }

    @FXML
    void applyPeriodFilter(ActionEvent event) {
        String dateFrom = fromDate.getValue().toString();
        String dateTo = toDate.getValue().toString();
        String period = dateFrom + " / " + dateTo;
        List<VacationPackage> resultList = userService.filterByPeriod(packageTableView.getItems(), period);
        ObservableList<VacationPackage> observableList = FXCollections.observableList(resultList);
        packageTableView.setItems(observableList);
    }

    @FXML
    void reset(){
        loadPackages();
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
