package mars.command;

import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;

public class markCommand extends Command {
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private int itemNumber;

    public markCommand(int itemNumber) {
        super();
        this.itemNumber = itemNumber;
    }

    public void execute(TaskList tasklist, UI ui, Storage storage) {
        tasklist.mark(itemNumber - 1);
        Task task = tasklist.get(itemNumber - 1);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }
}
