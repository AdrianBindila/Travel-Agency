package com.assignment.controller;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.service.TravelAgencyService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TravelController implements Initializable {
    @FXML
    private ListView<Destination> destinationListView;
    @FXML
    private TableView<VacationPackage> packageTableView;
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

    private TravelAgencyService travelAgencyService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        travelAgencyService = new TravelAgencyService();
        configurePackageTableView();
        loadDestinationList();
        loadPackages();
    }

    @FXML
    void addDestination() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Add New Destination");
        inputDialog.setContentText("Destination: ");
        inputDialog.showAndWait();
        String destinationName = inputDialog.getEditor().getText();
        travelAgencyService.addDestination(destinationName);
        loadDestinationList();
    }

    @FXML
    void addPackage(ActionEvent event) {
        Destination selectedDestination = destinationListView.getSelectionModel().getSelectedItem();
        if (selectedDestination != null) {
            Dialog<VacationPackage> dialog = createAddPackageDialog(selectedDestination);
            Optional<VacationPackage> result = dialog.showAndWait();
            result.ifPresent((VacationPackage p) -> {
                travelAgencyService.addPackage(p);
                loadPackages();
            });
        } else {
            Alert destinationError = new Alert(Alert.AlertType.ERROR, "Select a destination first", ButtonType.OK);
            destinationError.showAndWait();
        }

    }

    @FXML
    void deleteDestination(ActionEvent event) {
        Destination selectedDestination = destinationListView.getSelectionModel().getSelectedItem();
        if (selectedDestination != null) {
            travelAgencyService.deleteDestination(selectedDestination);
            loadDestinationList();
        }
    }

    @FXML
    void deletePackage(ActionEvent event) {
        VacationPackage selectedPackage = packageTableView.getSelectionModel().getSelectedItem();
        if(selectedPackage!=null){
            travelAgencyService.deletePackage(selectedPackage);
            loadPackages();
        }
    }

    @FXML
    void editPackage(ActionEvent event) {

    }

    private Dialog<VacationPackage> createAddPackageDialog(Destination selectedDestination) {
        Dialog<VacationPackage> dialog = new Dialog<>();
        dialog.setHeaderText("Add New Package");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Text destination = new Text(selectedDestination.getName());

        TextField name = new TextField();
        name.setPromptText("name");
        name.setText("name");

        TextField price = new TextField();
        price.setPromptText("price");
        price.setText("price");
        DatePicker dateFrom = new DatePicker(LocalDate.now());
        DatePicker dateTo = new DatePicker(LocalDate.now());

        TextField details = new TextField();
        details.setPromptText("details");
        details.setText("haha");


        TextField seats = new TextField();
        seats.setPromptText("seats");
        seats.setText("10");

        dialogPane.setContent(new VBox(8, destination, name, price, dateFrom, dateTo, details, seats));
        dialog.setResultConverter((ButtonType b) -> {
            if (b == ButtonType.OK) {
                return travelAgencyService.makePackageFromFields(selectedDestination, name.getText(), price.getText(), dateFrom.toString(), dateTo.toString(), details.getText(), seats.getText());
            } else {
                return new VacationPackage();
            }
        });


        return dialog;
    }

    private void loadDestinationList() {
        List<Destination> destinationList=travelAgencyService.viewDestinations();
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

    private void loadPackages() {//load packages for selected destination? or all packages
        List<VacationPackage> packageList = travelAgencyService.viewVacationPackages();
        packageTableView.getItems().removeAll();
        packageTableView.setItems(FXCollections.observableArrayList(packageList));
    }

    private void configurePackageTableView() {
        destinationCol.setCellValueFactory(param -> { // put the destination's name, not the object reference
            if (param.getValue()!=null){
                return new SimpleStringProperty(param.getValue().getDestination().getName());
            }else {
                return new SimpleStringProperty("<No destination>");
            }
        });
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        periodCol.setCellValueFactory(new PropertyValueFactory<>("period"));
        detailCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        seatCol.setCellValueFactory(new PropertyValueFactory<>("seats"));
    }
}
