Reminders Applications created by Cameron Imanpour 

The reminder apps have similar functionlity, but one uses a graphical user interface (coded in javaFX), while the other is console-based (coded in Java.)

The JavaFX application that sets up a scheduled reminder for a task.

The user will schedule a specific task, with a date and time, how many times they wish to repeat that
specific task, and optionally enter any additional notes.

The user can then either clear all data entered (by clicking the clear button) and re-enter them, and once
the user clicks the save button, a confirmation dialog will appear and then the user has the option to confirm
by clicking the okay button, at which point the saved data will be shown in a new label window.

Once the app is closed all of the data entered by the user will be shown in the console and will also be
stored to a text file, locally.

When the app is restarted the previous stored text file will appear in the console.

The application uses several helper classes to create alerts, manipulate Strings, limit inputs, and finally
create and read text files.


The console application sets up a scheduled reminder for a task. The user will schedule a specific task, with a time and date, how many times they wish to repeat that specific task, and optionally enter any additional notes. 

All this will be stored locally and the user can either confirm the schedule or start over. Once the schedule is confirm, the data will stored will locally to a text file (and then uses a method that "pretends" to upload that text file to email servers.) 
