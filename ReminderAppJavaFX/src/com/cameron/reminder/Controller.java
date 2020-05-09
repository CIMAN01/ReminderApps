/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 9th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */

package com.cameron.reminder;

import com.cameron.reminder.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.Optional;

// main controller
public class Controller {
    /*
       The @FXML annotation tells the compiler that these fields
       refer to elements that need to be retrieved. It identifies
       which elements to grab by their fx:id attributes.

       If the fields are public, you don't need to use this annotation
       but it's best practice to keep fields private.
    */
    @FXML
    private GridPane mainGridPane;
    @FXML
    private TextFieldLimited taskReminder;
    @FXML
    private DatePicker taskDate;
    @FXML
    private Spinner<Integer> taskTimeHour;
    @FXML
    private Spinner<Integer> taskTimeMin;
    @FXML
    private ComboBox<String> amPMTime;
    @FXML
    private Spinner<Integer> taskRepetition;
    @FXML
    private TextAreaLimited notes;
    @FXML
    private Button saveButton;

    // a boolean variable to keep track of whether a file has been created or not
    public static boolean hasCreatedAFile = false;


    // initialize is always the first method that gets invoked in the controller
    @FXML
    private void initialize() {
        // begin by disabling the submit button until a task is entered
        saveButton.setDisable(true);
    }

    // this method is invoked whenever the user types in the TextField for the task text
    // if nothing is entered the submit button while be greyed and not operational
    @FXML
    private void enableSubmit() {
        // get the input field from variable and store in another String variable
        String taskText = taskReminder.getText();
        // if the input field is either blank or empty set boolean to true
        boolean disableSubmit = taskText.isEmpty() || taskText.trim().isEmpty();
        // if true disable the submit button
        saveButton.setDisable(disableSubmit);
    }

    // The submit method is invoked when the button is clicked this is specified on the button element
    @FXML
    // ActionEvent extends the Event class. This is helpful if we want to use the
    // same event handler for more than one control
    private void save(ActionEvent event) {
        // if the task text is blank or empty
        if (taskReminder.getText().isEmpty() || taskReminder.getText().trim().isEmpty()) {
            // display an error to user that they must type in some task
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error!",
                    "Please enter a task.");
        // if a date is not chosen
        } else if (taskDate.getValue() == null) {
            // display an error to user that they must specify a date
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error!",
                    "Please enter a date.");
        }
        // otherwise
        else {
            // create a confirmation alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to set a Reminder?");
            // showAndWait is a blocking call so, the code execution path pauses in the executing JavaFX thread until the user interacts
            // with the dialog in a way that causes it to close
            Optional<ButtonType> result = alert.showAndWait();
            // if okay button is clicked
            if (result.isPresent() && result.get() == ButtonType.OK) {
//                // display a confirmation that a reminder schedule has been set
//                AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, "Reminder schedule created", "Reminder set!");

                // use FileService class to save reminder details to a text file (saves schedule to reminder.txt)
                FileService.writeToFile("\n______________________________________________________________"
                        + "________________________________\n"
                        + "\nScheduled Reminder Details:\n" + "\nTask: " + taskReminder.getText() + "\nDate: "
                        + taskDate.getValue() + "\nTime: " + taskTimeHour.getValue() + ":" + taskTimeMin.getValue() + " "
                        + amPMTime.getValue() + "\nTask repetition: " + "task will be repeated "                          // max Chars - preferred value 59
                        + taskRepetition.getValue() + " time(s)" + "\n\nNotes (optional): \n" + WrapStrings.splitIntoLines(notes.getText(), 59)
                        + "\n______________________________________________________________________________________________\n");

                // set boolean variable to true after creating a file
                hasCreatedAFile = true;

                // invoke this method to invoke another method in second controller to show schedule (from text file) in a Label window
                showNewLabel();
            }
        }
    }

    @FXML
    // this method will clear any text/date/time entered by user when clear button is clicked
    private void clear(ActionEvent actionEvent) {
        // clears the TextField
        taskReminder.clear();
        // clears the DatePicker
        taskDate.setValue(null); // using getEditor().clear() is not ideal as it will fail the null check
        // clears the time Spinners
        taskTimeHour.getValueFactory().setValue(6);
        taskTimeMin.getValueFactory().setValue(0);
        // resets ComboBox value
        amPMTime.getSelectionModel().selectFirst();
        // resets the repeat Spinner
        taskRepetition.getValueFactory().setValue(0);
        // clears the optional notes in the TextArea
        notes.clear();
    }


    // The purpose of this method is to display the labelWindow.fxml file
    // when the user clicks the save button in the main reminder app window
    @FXML
    public void showNewLabel() {
        // create a new dialog
        Dialog<ButtonType> dialog = new Dialog<>();
        // initOwner() sets an owner for the dialog we want to create,
        // which must be done before making a dialog visible
        dialog.initOwner(mainGridPane.getScene().getWindow());
        // FXMLLoader is used to load fxml files.
        FXMLLoader fxmlLoader = new FXMLLoader();
        // define which fxml file the FXMLLoader should load.
        fxmlLoader.setLocation(getClass().getResource("labelWindow.fxml"));

        // an IOException may occur whenever we try to access another file
        // use a try-catch here to catch the error if it occurs
        try {
            // set labelWindow.fxml as the content
            dialog.getDialogPane().setContent(fxmlLoader.load());
            // set the title for the label Window
            dialog.setTitle("Reminder details");
            // // set the header for the label Window
            dialog.setHeaderText("A Scheduled Reminder Has Been Saved!");
        }
        catch (IOException e) {
            System.out.println("IOException: Couldn't load notepad");
            //e.printStackTrace();
        }

        // adding the OK button to dialog pane
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        // wait for button to be clicked
        Optional<ButtonType> result = dialog.showAndWait();
        // once OK button is clicked
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // grab the controller for the dialog, and invoke its method
            SecondController controller = fxmlLoader.getController();
            // grab the second controller's method processLabel() and invoke it
            controller.processLabel();
        }
    }

}
