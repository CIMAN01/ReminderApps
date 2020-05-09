package com.cameron.reminder.model;

import javafx.scene.control.Alert;

/*
	In object oriented languages there's a concept of "helper classes".
	A Helper Class is a Java class which includes basic error handling.
	Helper classes contain methods that help in assisting the program.
	This Class intends to give quick implementation of basic functions
	such that programmers do not have to implement again and again. A
	Helper Class' methods are easy to access because they're all static
	(they don't require an object to be created - this allows them to
	be accessed from anywhere).
*/

// a helper class that helps with alerts in the controller
public class AlertHelper {

    // method showerAlert() with 3 parameters
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        // HeaderText will not be shown
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    // method showerAlert() with 2 parameters
    public static void showAlert2(String infoMessage, String titleBar) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(null);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}