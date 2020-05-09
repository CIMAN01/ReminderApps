package com.cameron.reminder.model;


import javafx.scene.control.TextArea;
import java.io.*;


public class FileService {

    /** Fields **/

    // by instantiating an object of this class WITHIN the class, and by
    // creating a private constructor, we make this a singleton class.
    private static final FileService instance = new FileService();

    /** Constructor **/

    // because this is a singleton class, we create a private constructor.
    private FileService() {}

    /** Getters and Setters **/

    // Getter for the instance
    public static FileService getInstance() {
        return instance;
    }

    /**
     * methods
     **/

    // a console-to-disk method that uses a FileWriter
    public static void writeToFile(String str) {
        // try-with-resources
        try (FileWriter fw = new FileWriter("./lib/reminder.txt")) { // relative path
            fw.write(str);
            System.out.println("\nsuccessfully wrote to the file.\n");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }


    // a method that reads a lines from a text file
    public static void readFromTextFile() {
        // try with resources
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/reminder.txt"))) {
            // create an empty String
            String line = "";
            // while text is not empty
            while ((line = reader.readLine()) != null) {
                // process and print each line of text
                System.out.println(line);
            }
            // catch statement
        } catch (IOException e) {
            System.out.println("error - no such file exists");
        }
    }

}
