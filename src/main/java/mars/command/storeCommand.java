package mars.command;

import mars.Mars;
import mars.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;


public class storeCommand extends Command {
    public void execute(TaskList tasklist, UI ui, Storage storage){
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();
        while(!n.equals("bye")) {
            if (n.equals("list")) {
                Mars.list(arrayList);
            } else {
                Task task = new Task(n);
                arrayList.add(task);
                String output = HORIZONTAL_LINE + "added: " + n + "\n" + HORIZONTAL_LINE;
                System.out.println(output);
            }
            n = reader.nextLine();
        }
        reader.close();
    }
}
