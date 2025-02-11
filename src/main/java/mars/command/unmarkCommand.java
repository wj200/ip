package mars.command;

import mars.task.Task;

import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;


public class unmarkCommand extends Command{
    private static void unmark(Task task){
        System.out.println(HORIZONTAL_LINE +
                "OK, I've marked this task as not done yet: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

}
