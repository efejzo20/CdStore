package com.example.cddd;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;
import view.LoginView;

import java.io.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene((new LoginView()).execute(primaryStage));
        primaryStage.setTitle("Tech Shop");
        Image logo = new Image("logo.png");
        primaryStage.getIcons().add(logo);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}