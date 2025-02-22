package mars;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import mars.storage.Storage;
import mars.task.Deadline;
import mars.task.Event;
import mars.task.Task;
import mars.task.Todo;
import mars.task.TaskList;
import mars.parser.Parser;
import mars.command.Command;

import mars.ui.UI;

/**
 * Mars class is the entry point of the task bot's execution
 */

public class Mars {
    private TaskList tasks;
    private Storage storage;
    private UI ui;

    /**
     * Constructor to instantiate Mars instance with
     * the file path of marsBot.txt
     *
     * @param filePath The file path of marsBot.txt storing the tasks
     */
    public Mars(String filePath) throws IOException{
        this.ui = new UI();
        this.storage = new Storage(filePath);
        this.tasks = new TaskList(storage.load());
    }

    public void run() throws IOException{
        ui.welcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (marsException e) {
                ui.showError(e.getMessage());
            }
            finally {
                ui.showLine();
            }
        }
    }
    public static void main(String[] args) {
        try {
            new Mars("src/main/data/marsBot.txt").run();
        }
        /*
        try{
            ArrayList<Task> tasks = new ArrayList<>();
            Mars mars = new Mars("./data/marsBot.txt" );
            mars.ui.welcomeMessage();
            while (true){
                Scanner reader = new Scanner(System.in);
                String command = reader.nextLine();
                if (command.equals("echo")){
                    Mars.echo();
                }
                else if (command.equals("bye")){
                    mars.ui.goodbyeMessage();
                }
                else if (command.equals("list")){
                    Mars.list(tasks);
                }
                else if(command.startsWith("mark")){
                    int index = Integer.parseInt(command.split(" ")[1]);
                    Task task = tasks.get(index-1);
                    task.markAsDone();
                    Mars.mark(task);
                }
                else if (command.startsWith("unmark")){
                    int index = Integer.parseInt(command.split(" ")[1]);
                    Task task = tasks.get(index-1);
                    task.unmark();
                    Mars.unmark(task);
                }
                else if (command.startsWith("todo") || command.startsWith("deadline") ||command.startsWith("event") ){
                    mars.addTask(tasks);
                    mars.storage.save(tasks);
                }
                else if(command.startsWith("delete")){
                    mars.deleteTask(tasks);
                    mars.storage.save(tasks);
                }
                else {
                    throw new IllegalArgumentException("Unknown command: " + command);
                }

            }
        } */
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
