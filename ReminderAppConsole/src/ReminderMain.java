/**
 * Skillspire 2020 Final Project: Reminder App
 *
 * last updated: April 24th, 2020
 *
 * @author: Cameron Imanpour (CIMAN01@github.com)
 *
 */

// main driver that acts as main for the reminder class
public class ReminderMain {
    // main method
    public static void main(String[] args) {
        // create a reminder object
        Reminder reminderObj = new Reminder();
        // ask user for a reminder task
        reminderObj.askForReminder();
    }
}