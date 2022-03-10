package com.assignment.controller;

import com.assignment.service.LoginDetails;
import com.assignment.service.LoginStatus;
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

import static com.assignment.controller.Utils.currentUser;
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
        Window window = ((Node) event.getSource()).getScene().getWindow();

        LoginDetails loginDetails = new LoginDetails(usernameTextField.getText(), passwordTextField.getText());
        LoginStatus status = loginDetails.validate();

        if (status == LoginStatus.CORRECT) {
            currentUser = loginDetails.getUser();
            switchScene(event, "user.fxml", Utils.userTitle);
        } else {
            Tooltip tooltip = loginBtn.getTooltip();
            tooltip.setText(status.label);
            tooltip.show(window);
        }
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        switchScene(event, "register.fxml", Utils.registerTitle);
    }

    @FXML
    void openTravelAgentScreen(ActionEvent event) throws IOException {
        switchScene(event, "travel-agency.fxml", Utils.travelAgencyTitle);
    }
}
