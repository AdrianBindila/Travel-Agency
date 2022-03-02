package com.assignment.controller;

import com.assignment.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {

    static void switchScene(ActionEvent event, String screenPath, String title) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader screenLoader = new FXMLLoader(Main.class.getResource(screenPath));
        Scene scene = new Scene(screenLoader.load());
        window.setTitle(title);
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
}
