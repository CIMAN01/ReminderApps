/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 8th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */


package com.cameron.reminder;

import com.cameron.reminder.model.FileService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    // start the main window
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Reminders Application");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    // init method is invoked when the app is started
    @Override
    public void init() {
        System.out.println("\npreviously created schedule is shown below: ");
        // print reminder schedule to console (if previous schedule from reminder.txt already exists) during app startup
        FileService.readFromTextFile();
    }

    // stop() method is run when the app is closed
    @Override
    public void stop() {
        System.out.println("\na new schedule has been created as show below: ");
        // print reminder schedule to console (from reminder.txt) once app is closed
        FileService.readFromTextFile();
    }

    // launch app
    public static void main(String[] args) {
        launch(args);
    }

}