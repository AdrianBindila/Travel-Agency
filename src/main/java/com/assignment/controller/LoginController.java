package com.assignment.controller;

import com.assignment.service.LoginDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.assignment.controller.Utils.switchScene;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        tooltip.autoHideProperty().set(true);
        loginBtn.setTooltip(tooltip);
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        LoginDetails loginDetails = new LoginDetails(usernameTextField.getText(),passwordTextField.getText());
        Window window=((Node) event.getSource()).getScene().getWindow();
        switch (loginDetails.validate()){
            case INVALID_USERNAME -> {
                loginBtn.getTooltip().setText("Username field is invalid!");
                loginBtn.getTooltip().show(window);
            }
            case INVALID_PASSWORD -> {
                loginBtn.getTooltip().setText("Password field is invalid!");
                loginBtn.getTooltip().show(window);
            }
            case NOT_FOUND -> {
                loginBtn.getTooltip().setText("Username/password not found!");
                loginBtn.getTooltip().show(window);
            }
            case CORRECT -> {
                switchScene(event, "user.fxml", "User Screen");
            }
        }
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        switchScene(event, "register.fxml", "Signup");
    }

    @FXML
    void openTravelAgentScreen(ActionEvent event) throws IOException {
        switchScene(event, "travel-agency.fxml", "Travel Agency");
    }


}
