package com.assignment.controller;

import com.assignment.App;
import com.assignment.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

class Utils {
    final static String loginTitle = "Travel App";
    final static String registerTitle = "Register";
    final static String userTitle = "User Screen";
    final static String travelAgencyTitle = "Travel Agency";
    final static String userBookingsTitle = "User Bookings";
    static User currentUser = new User();

    static void switchScene(ActionEvent event, String screenPath, String title) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader screenLoader = new FXMLLoader(App.class.getResource(screenPath));
        Scene scene = new Scene(screenLoader.load());
        if (Objects.equals(title, userTitle)) {
            title = currentUser.getFirstName() + "'s " + userTitle;
        }
        window.setTitle(title);
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
}
