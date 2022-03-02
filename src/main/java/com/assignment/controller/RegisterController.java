package com.assignment.controller;

import com.assignment.Main;
import com.assignment.service.RegisterDetails;
import com.assignment.service.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField fNameTextField;

    @FXML
    private TextField lNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private PasswordField confPassTextField;

    @FXML
    private Button signupBtn;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        tooltip.autoHideProperty().set(true);
        signupBtn.setTooltip(tooltip);
    }


    @FXML
    void signup(ActionEvent event) {
        //TODO: get all user inputs, validate, add new user in db, go to user screen
        RegisterDetails registerDetails = new RegisterDetails(fNameTextField.getText(), lNameTextField.getText(), emailTextField.getText(), usernameTextField.getText(), passTextField.getText(), confPassTextField.getText());
        Window window=((Node) event.getSource()).getScene().getWindow();
        switch (registerDetails.validate()){
            case INVALID_FNAME -> {

            }
            case INVALID_LNAME -> {

            }
            case INVALID_EMAIL -> {

            }
            case INVALID_USERNAME -> {

            }
            case INVALID_PASSWORD -> {

            }
            case INVALID_CONFIRMPASS -> {

            }
            case CORRECT -> {
                RegisterService.addUser(registerDetails);
            }
        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loginLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene loginScene = new Scene(loginLoader.load());
        window.setScene(loginScene);
        window.show();
    }

}
