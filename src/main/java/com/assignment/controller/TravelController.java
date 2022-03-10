package com.assignment.controller;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.service.TravelAgencyService;
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
    private ListView<String> destinationListView;

    @FXML
    private Button editPackageBtn;

    @FXML
    private TableView<?> packageTableView;

    private TravelAgencyService travelAgencyService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loadDestinationList(travelAgencyService.viewDestinations());
//        loadPackages(travelAgencyService.viewVacationPackages());
    }

    @FXML
    void addDestination(ActionEvent event) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Add New Destination");
        inputDialog.setContentText("Destination: ");
        inputDialog.showAndWait();
        String destinationName = inputDialog.getEditor().getText();
        travelAgencyService.addDestination(destinationName);
//        loadDestinationList(travelAgencyService.viewDestinations());
    }

    @FXML
    void addPackage(ActionEvent event) {
        //Create alert
        Dialog<VacationPackage> dialog = createAddPackageDialog();

        Optional<VacationPackage> result = dialog.showAndWait();
        result.ifPresent((VacationPackage p) -> {
            System.out.println(p.getName());
        });
    }

    @FXML
    void deleteDestination(ActionEvent event) {

    }

    @FXML
    void deletePackage(ActionEvent event) {

    }

    @FXML
    void editPackage(ActionEvent event) {

    }


    private Dialog<VacationPackage> createAddPackageDialog() {
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
//        ArrayList<String> list= new ArrayList<String>(destinationList.stream().map(Destination::getName).toList());
//        ObservableList<String> destinations = FXCollections.observableArrayList();
//        destinationListView.setItems();
    }

    private void loadPackages(List<VacationPackage> packageList) {

    }

}
