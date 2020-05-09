/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: May 8th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */

package com.cameron.reminder.model;

import java.util.StringTokenizer;

// a class that wraps strings
public class WrapStrings {
    // a method that splits Strings into separate lines given a max character value
    public static StringBuilder splitIntoLines(String input, int maxCharInLine){
        // StringTokenizer class in Java is used to break a string into tokens (i.e. words)
        StringTokenizer token = new StringTokenizer(input, " "); // create a new token
        // create a new StringBuilder with an input length
        StringBuilder output = new StringBuilder(input.length());
        // starting line length is zero
        int lineLength = 0;
        // while the token has more tokens
        while (token.hasMoreTokens()) {
            // process next token and assign it to a String word
            String word = token.nextToken();
            // while a word's length exceeds max amount of character
            while(word.length() > maxCharInLine){
                // append substrings to the output separated by a new line
                output.append(word, 0, maxCharInLine - lineLength).append("\n");
                // update word by removing what has already extracted
                word = word.substring(maxCharInLine-lineLength);
                // reset line length
                lineLength = 0;
            }
            // if both line and word lengths is greater than the max char line
            if (lineLength + word.length() > maxCharInLine) {
                // append a new line to output
                output.append("\n");
                // reset line length
                lineLength = 0;
            }
            // append word and a space to output
            output.append(word).append(" ");
            // update line length by adding to it a length of word plus one
            lineLength += word.length() + 1;
        }
        // use split() method with a regex
        return output;
    }

}


