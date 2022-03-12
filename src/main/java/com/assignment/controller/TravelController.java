package com.assignment.controller;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.service.TravelAgencyService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TravelController implements Initializable {

    @FXML
    private Button addDestinationBtn;

    @FXML
    private Button addPackageBtn;

    @FXML
    private Button deleteDestinationBtn;

    @FXML
    private Button deletePackageBtn;

    @FXML
    private ListView<Destination> destinationListView;

    @FXML
    private Button editPackageBtn;

    @FXML
    private TableView<VacationPackage> packageTableView;

    private TravelAgencyService travelAgencyService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        travelAgencyService = new TravelAgencyService();
        loadDestinationList(travelAgencyService.viewDestinations());
        loadPackages(travelAgencyService.viewVacationPackages());
    }

    @FXML
    void addDestination() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Add New Destination");
        inputDialog.setContentText("Destination: ");
        inputDialog.showAndWait();
        String destinationName = inputDialog.getEditor().getText();
        travelAgencyService.addDestination(destinationName);
        loadDestinationList(travelAgencyService.viewDestinations());
    }

    @FXML
    void addPackage(ActionEvent event) {
        //Create alert

        Dialog<VacationPackage> dialog = createAddPackageDialog(travelAgencyService.viewVacationPackages());
        Optional<VacationPackage> result = dialog.showAndWait();
        result.ifPresent((VacationPackage p) -> {
            travelAgencyService.addPackage(p);
        });
    }

    @FXML
    void deleteDestination(ActionEvent event) {
        Destination selectedDestination = destinationListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedDestination.getDestination_id());
        travelAgencyService.deleteDestination(selectedDestination);
        loadDestinationList(travelAgencyService.viewDestinations());
    }

    @FXML
    void deletePackage(ActionEvent event) {

    }

    @FXML
    void editPackage(ActionEvent event) {

    }


    private Dialog<VacationPackage> createAddPackageDialog(List<VacationPackage> vacationPackages) {
        Dialog<VacationPackage> dialog = new Dialog<>();
        dialog.setHeaderText("Add New Package");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);


        TextField destination = new TextField();
        destination.setPromptText("destination");
        TextField name = new TextField();
        name.setPromptText("name");
        TextField price = new TextField();
        price.setPromptText("price");
        TextField period = new TextField();
        period.setPromptText("period");
        TextField details = new TextField();
        details.setPromptText("details");
        TextField status = new TextField();
        status.setPromptText("status");
        TextField seats = new TextField();
        seats.setPromptText("seats");

        dialogPane.setContent(new VBox(8, destination, name, price, period, details, status, seats));
        dialog.setResultConverter((ButtonType b) -> {
            if (b == ButtonType.OK) {
                return new VacationPackage(new Destination(destination.getText()), name.getText(), price.getText(), period.getText(), details.getText(), status.getText(), Integer.parseInt(seats.getText()));
            } else {
                return new VacationPackage();
            }
        });
        return dialog;
    }


    private void loadDestinationList(List<Destination> destinationList) {
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

    private void loadPackages(List<VacationPackage> packageList) {
        packageTableView.getItems().removeAll();
        packageTableView.setItems(FXCollections.observableArrayList(packageList));
    }

}
