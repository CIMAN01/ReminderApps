/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 9th, 2020
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
        // if OK confirmation has been selected and app is closed
        if (Controller.hasCreatedAFile) {
            // print to console that a new text file has been created
            System.out.println("\na new schedule has been created as show below: ");
            // print reminder schedule to console (from reminder.txt) once app is closed
            FileService.readFromTextFile();
        }
        // if cancel button is clicked
        else {
            // print to console that no new file has been created
            System.out.println("\nno new file has been been created\n");
        }
    }

    // launch app
    public static void main(String[] args) {
        launch(args);
    }

}
