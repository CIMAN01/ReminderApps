/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 8th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */

package com.cameron.reminder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    Purpose of this class is to grab data from the text file and to add it to a new Label window
    to be shown in the UI after the save and confirmation button have both been clicked
*/
public class SecondController {
    // FXML fields
    @FXML
    private StackPane mainPane;
    @FXML
    private Label label;

    // getter
    public Label getLabel() {
        return label;
    }

    /* initialize() is needed to actually see any text in the label window */
    @FXML
    public void initialize() {
        processLabel();
    }

    // a method that reads a lines from a text file
    public void processLabel() {
        // try with resources
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/reminder.txt"))) {
            // create an empty String
            String line;
            // while text is not empty
            while ((line = reader.readLine()) != null) {
                // process each and append lines of text to the Label
                label.setText(label.getText() +"\n" + line); // append each line to label
            }
            // catch statement
        } catch (IOException e) {
            System.out.println("error - no such file exists");
            //System.out.println("I/O Error: " + e);
            //e.printStackTrace();
        }
    }

}