package mars.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Level 7. Save */

/** Storage class handles the loading and storing
 *  of tasks to and from the designated file path
 *
 */

public class Storage {
    private File file;
    private Scanner scanner;

    /**
     * Constructor to instantiate mars.storage.Storage instance
     *
     * @param filePath The file path of marsBot.txt storing the tasks
     * handles the FileNotFoundException case where the data file does
     * not exist at the start
     *
     */
    public Storage(String filePath){
        try{
            this.file = new File(filePath);
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            // creates an empty file if a file with this name does not exist yet
            file.createNewFile();
            System.out.println("File was not found initially. New empty file created.\n")
        }
    }




}
