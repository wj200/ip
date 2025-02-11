package mars.command;

import mars.storage.Storage;
import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;

import java.util.ArrayList;

public class listCommand extends Command{

    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasklist, UI ui, Storage storage) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Here are the tasks in your list:\n");
        int i = 1;
        while (i <= tasklist.size()) {
            System.out.println(i + "." + tasklist.get(i - 1));
            i += 1;
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
