package com.example.slot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 280);
        scene.setFill(Color.web("#071028"));
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Слот-машина");
        stage.setScene(scene);
        stage.show();
    }
}
