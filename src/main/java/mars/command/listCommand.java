package mars.command;

import mars.storage.Storage;
import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;
import mars.marsException;

import java.util.ArrayList;

public class listCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasklist, UI ui, Storage storage){
        System.out.println("Here are the tasks in your list:\n");
        for (Task task : tasklist.getTasks()) {
            System.out.println(task);
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
