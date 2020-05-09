/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 6th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */

package com.cameron.reminder.model;

import javafx.scene.control.TextField;

// a class that inherits a TextField class
public class TextFieldLimited extends TextField {

    // field
    private int maxLength;

    // constructor
    public TextFieldLimited() {
        // set the maximum amount of characters for the TextField
        setMaxLength(55); // max Chars for TextField - preferred value: 55
    }

    // setter
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    // a method that replaces text
    @Override
    public void replaceText(int start, int end, String text) {
        // delete or backspace user input.
        if (text.equals("")) {
            // replace text via super
            super.replaceText(start, end, text);
        }
        else if (getText().length() < maxLength) {
            // replace text via super
            super.replaceText(start, end, text);
        }
    }

    // a method that replaces selection
    @Override
    public void replaceSelection(String text) {
        // delete or backspace user input.
        if (text.equals("")) {
            super.replaceSelection(text);
        }
        else if (getText().length() < maxLength) {
            // add characters, but do not exceed maxLength.
            if (text.length() > maxLength - getText().length()) {
                text = text.substring(0, maxLength - getText().length());
            }
            // replace selection using super
            super.replaceSelection(text);
        }
    }

}