package mars.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

import mars.task.Task;

/* Level 7. Save */

/** Storage class handles the loading and storing
 *  of tasks to and from the designated file path
 *
 */

public class Storage {
    private File file;
    private Scanner scanner;
    private String filePath;

    /**
     * Constructor to instantiate Storage instance
     *
     * @param filePath The file path of marsBot.txt storing the tasks
     * handles the FileNotFoundException case where the data file does
     * not exist at the start
     *
     */
    public Storage(String filePath) {
        try {
            this.file = new File(filePath);
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            // creates an empty file if a file with this name does not exist yet
            file.createNewFile();
            System.out.println("File was not found initially. New empty file created.\n");
        }
    }

    public ArrayList<String> load() {
        ArrayList<String> lines = new ArrayList<>();
        while (this.scanner.hasNext()) {
            String line = this.scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public void save(ArrayList<Task> tasks) {
        try {
            FileWriter file = new FileWriter(this.filePath, false); // overwrites existing file data
            for (Task task : tasks) {
                file.write(task.toString() + "\n");
            }
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}



}
