package com.assignment.controller;

import com.assignment.service.RegisterDetails;
import com.assignment.service.RegisterStatus;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip tooltip = new Tooltip();
        tooltip.autoHideProperty().set(true);
        signupBtn.setTooltip(tooltip);
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        Window window = ((Node) event.getSource()).getScene().getWindow();

        RegisterDetails registerDetails = new RegisterDetails(fNameTextField.getText(), lNameTextField.getText(), emailTextField.getText(), usernameTextField.getText(), passTextField.getText(), confPassTextField.getText());
        RegisterStatus status = registerDetails.validate();

        if (status == RegisterStatus.CORRECT) {
            currentUser = registerDetails.registerUser();
            Utils.switchScene(event, "user.fxml", Utils.userTitle);
        } else {
            Tooltip signupToolTip = signupBtn.getTooltip();
            signupToolTip.setText(status.label);
            signupToolTip.show(window);
        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Utils.switchScene(event, "login.fxml", Utils.loginTitle);
    }
}
