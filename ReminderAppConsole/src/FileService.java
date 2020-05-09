
import java.io.*;

public class FileService {

    // a console-to-disk method that uses a FileWriter
    public static void writeToFileFromConsole(String str) {
        // try-catch statement with resources
        try (FileWriter fw = new FileWriter("reminder.txt")) {
            fw.write(str);
            System.out.println("successfully wrote to the file.");
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }

}
