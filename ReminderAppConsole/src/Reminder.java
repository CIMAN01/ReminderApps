/**
 * Skillspire 2020 Final Project: CourseManagementTool
 *
 * last updated: April 30th, 2020
 *
 * @author Cameron Imanpour (CIMAN01@github.com)
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

// main class
public class Reminder {

    /**
     * fields
     **/

    // task name/type
    String taskReminder;
    // task date (i.e. 4/29/2020)
    String taskDate;
    // task time (i.e. 6.30 pm)
    String taskTime;
    // task repetition
    int taskRepeat;
    // task notes
    String taskNotes;

    // a boolean variable for making sure the input time is entered correctly
    boolean isTimeValid = false;
    // a boolean variable for making sure the input date is entered correctly
    boolean isDateValid = false;

    /**
     * constructor
     **/

    // empty default constructor
    public Reminder() {
    }

    // overloaded constructor with parameters
    public Reminder(String taskReminder, String taskDate, String taskTime, int taskRepeat, String taskNotes) {
        setTaskReminder(taskReminder);
        setTaskDate(taskDate);
        setTaskTime(taskTime);
        setTaskRepeat(taskRepeat);
        setTaskNotes(taskNotes);
    }

    /**
     * getters and setters
     **/

    public String getTaskReminder() {
        return taskReminder;
    }

    public void setTaskReminder(String taskReminder) {
        this.taskReminder = taskReminder;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public int getTaskRepeat() {
        return taskRepeat;
    }

    public void setTaskRepeat(int taskRepeat) {
        this.taskRepeat = taskRepeat;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(String taskNotes) {
        this.taskNotes = taskNotes;
    }

    /**
     * methods
     **/

    // a method that changes a String to a date format
    public void changeToDateFormat(String input) {
        // display given date in month/day/year format
        // String input = "04/24/2020";
        ///////////////////////////////////////////////////////////////////////////
        // simple date format (using polymorphism)
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        // setLenient() is needed to strictly enforce pattern
        sdf.setLenient(false);
        // try-catch statement
        try {
            // parsing input and converting Date type back to String
            String date = sdf.format(sdf.parse(input));
            // user setter to set/store date in string format
            setTaskDate(date);
            // update to true
            sdf.setLenient(true);
            // update boolean variable to exit while-loop in setDate method
            isDateValid = true;
        } catch (ParseException e) {
            System.out.println("error: you must use MM/dd/yyyy format (i.e. 04/24/2020) - try again");
            System.out.println();
        }
    }

    // a method that changes a String to a time format
    public void changeToTimeFormat(String input) {
        // display given time in 12 hour format with AM/PM
        // String input = "10:22 PM";
        //////////////////////////////////////////////////////////////////////////
        // simple date format (using polymorphism)
        DateFormat stf = new SimpleDateFormat("hh:mm aa");
        // try-catch statement
        try {
            // parsing input and converting Date/Time type back to String
            String time = stf.format(stf.parse(input));
            // user setter to set/store time in string format
            setTaskTime(time); // user setter to set/store time
            // update boolean variable to exit while-loop in setTime method
            isTimeValid = true;
        } catch (ParseException e) {
            System.out.println("error: you must use 24HR format (i.e. 4:30 PM) - try again");
            System.out.println();
        }
    }

    // a method that makes sure input is an integer
    public int checkInputIsInteger(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next(); // read and discard offending non-int input
            System.out.print("invalid input, please enter an integer: "); // re-prompt
        }
        return scan.nextInt();
    }

    // a method that sets a task for a reminder schedule
    public void setTask() {
        // create a scanner object to process user input
        Scanner scan = new Scanner(System.in);
        // create an empty string
        String input = "";
        // do-while loop that makes sure user input is not empty/blank
        do {
            // ask user for input
            System.out.println("enter a task: ");
            input = scan.nextLine(); // read in a line of input
            // if string is empty or blank display error to user
            if (input.trim().isEmpty()) {
                // re-prompt user if empty
                System.out.print("error: input cannot be empty - try again\n");
            }
        } while (input.trim().isEmpty()); // while the string is not blank/empty
        // store user input using setter
        setTaskReminder(input);
        System.out.println();
    }

    // a method that sets the date for a reminder schedule
    public void setDate() {
        // create a scanner object to process user input
        Scanner scan = new Scanner(System.in);
        // while user enters invalid date keep asking for correct input
        while (!isDateValid) { // isDateValid must be updated in changeToDateFormat()
            // ask user for input
            System.out.println("enter a date (use MM/dd/yyyy format): ");
            // store the input given by user
            String dateString = scan.nextLine();
            // process String input and convert to date format
            changeToDateFormat(dateString);
        }
        // update boolean condition for future setDate() invocation(s)
        isDateValid = false;
        System.out.println();
    }

    // a method that sets the time for a reminder schedule
    public void setTime() {
        // create a scanner object to process user input
        Scanner scan = new Scanner(System.in);
        // while user enters invalid time keep asking for correct input
        while (!isTimeValid) { // isDateValid must be updated in changeToTimeFormat()
            // ask user for input
            System.out.println("enter a time (use 24HR format, i.e. 4:30 PM): ");
            // store the input given by user
            String timeString = scan.nextLine();
            // Process String input and convert to time format
            changeToTimeFormat(timeString);
        }
        // update boolean condition for future setTime() invocation(s)
        isTimeValid = false;
        System.out.println();
    }

    // a method that creates a repetition of a task for a reminder schedule
    public void setRepeater() {
        // create a scanner object to process user input
        Scanner scan = new Scanner(System.in);
        // ask user for input
        System.out.println("enter how many times you would like to repeat this task: ");
        // repeat until next item is an integer
        int repeat = checkInputIsInteger(scan);
        // store the input given by user
        setTaskRepeat(repeat);
        System.out.println();
    }

    // a method that creates additional notes for a reminder schedule (optional)
    public void setNotes() {
        // create an empty string
        String input = "";
        // create a scanner object to process user input
        Scanner scan = new Scanner(System.in);
        // ask user for input
        System.out.println("enter additional notes (optional): ");
        input = scan.nextLine();
        // store the input given by user (can be blank as notes are optional)
        if (!input.trim().isEmpty()) {
            setTaskNotes(input);
        } else {
            setTaskNotes("no additional notes added!");
        }
        System.out.println();
    }

    // a method that set up a reminder
    public void setReminder() {
        // ask user to setup up a task
        setTask();
        // ask user to set up a date
        setDate();
        // ask user to set up a time
        setTime();
        // ask user how many times they want to repeat the task
        setRepeater();
        // ask user if they want to add any additional notes
        setNotes();
        // confirm/validate the data entered by user
        confirmReminder();
    }

    // a method that shows the Reminder set up by user
    public void getReminderStatus() {
        // print all available data
        System.out.println("a reminder with the following have been entered...");
        // display the task name set by user
        System.out.println("task: "+ getTaskReminder());
        // display the date set by user
        System.out.println("date: "+ getTaskDate());
        // display the time set by user
        System.out.println("time: "+ getTaskTime());
        // display the amount of repetition given by user
        System.out.println("task to be repeated "+ getTaskRepeat() + " time(s)");
        // display the optional notes given by user
        System.out.println("additional notes (optional): "+ getTaskNotes());
        System.out.println();
    }

    // a method that confirms a Reminder
    public void confirmReminder() {
        // show all the reminder data that has been set up user
        getReminderStatus();
        // create a scanner object to process user input
        Scanner scanner = new Scanner(System.in);
        // ask user for input
        System.out.println("is all the information entered above correct? ");
        System.out.println("1 - to confirm, 2 - to start over");
        // store the choice made by user
        String userChoice = scanner.next();
        // use switch statement
        switch (userChoice) {
            // 1 to confirm
            case "1":
                System.out.println("reminder set!");
                sendViaEmail();
                break;
            // 2 to start over
            case "2":
                setReminder(); // start over
                break;
            // default error message
            default:
                // if an invalid input is entered, tell user by print an error
                System.out.println("that is not a valid choice, please try again!");
                System.out.println();
                confirmReminder(); // restart menu until user enters valid choice
        }
    }

    // a method that asks for a reminder
    public void askForReminder() {
        // create a scanner object to process user input
        Scanner scanner = new Scanner(System.in);
        // ask user for input
        System.out.println("would you like to set up a reminder?");
        System.out.println("1 - yes, 2 - no");
        // store the choice made by user
        String userChoice = scanner.next();
        // use switch statement
        switch (userChoice) {
            // 1 for yes
            case "1":
                setReminder();
                break;
            // 2 for no
            case "2":
                System.out.println("reminder canceled!");
                System.out.println("exiting program...");
                break;
            // default error message
            default:
                // if an invalid input is entered, tell user by print an error
                System.out.println("that is not a valid choice, please try again!");
                System.out.println();
                askForReminder(); // restart menu until user enters valid choice
        }
    }

    /** sendViaEmail() dummy method - not yet fully implemented **/
    // a method that sends a reminder to online servers (i.e. email)
    public void sendViaEmail() {
        System.out.println("contacting email servers...");
        System.out.println("uploading reminder...");
        System.out.println("email successfully sent!");
        FileService.writeToFileFromConsole("////////////////// Scheduled Reminder //////////////////"
                + "\n\n" + "Task: " + getTaskReminder() + "\n" + "Task date: "
                + getTaskDate() + "\n" + "Task time: " + getTaskTime() + "\n" + "Task repetition: "
                + "task will be repeated " + getTaskRepeat() + " time(s)" + "\n" + "Additional notes: "
                + getTaskNotes());
    }

}
