package mars.command;

import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;

public class markCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasklist, UI ui, Storage storage){
        System.out.println(HORIZONTAL_LINE +
                "Nice! I've marked this task as done: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }
}
