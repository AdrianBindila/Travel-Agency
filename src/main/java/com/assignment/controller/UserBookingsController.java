package com.assignment.controller;

import com.assignment.model.VacationPackage;
import com.assignment.service.UserService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import static com.assignment.controller.Utils.currentUser;

public class UserBookingsController implements Initializable {
    @FXML
    private TableView<VacationPackage> bookingsTableView;
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
    @FXML
    private Button cancelBtn;
    UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService(currentUser);
        configurePackageTableView();
        loadBookings();
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Utils.switchScene(event, "user.fxml", Utils.userTitle);
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

    private void loadBookings() {
        Set<VacationPackage> bookings = userService.getUserBookings();
        bookingsTableView.getItems().removeAll();
        bookingsTableView.setItems(FXCollections.observableArrayList(bookings));
    }
}
