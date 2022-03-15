package com.assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image("https://cdn.onlinewebfonts.com/svg/img_85878.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("travel-agency.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Travel App");
        stage.setScene(scene);
        stage.show();
    }
}