package mars.command;

import mars.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;


public class deleteCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasklist, UI ui, Storage storage){
        Scanner reader = new Scanner(System.in);
        String delete = reader.next();
        int num = reader.nextInt();
        System.out.println(HORIZONTAL_LINE);
        try {
            Task task = tasklist.get(num - 1);
            System.out.println("Noted. I've removed this task: " + task.toString());
            tasklist.delete(num);
            System.out.println("Now you have " + tasklist.size() + " tasks in the list.\n");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Please input a valid index\n");
        }
        finally {
            reader.close();
        }

    }

}
