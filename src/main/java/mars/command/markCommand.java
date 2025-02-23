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
        Task task = tasklist.get(itemNumber - 1);
        assert task != null : "Task cannot be null.";
        if(task.getStatusIcon().equals("X")){
            System.out.println("This task has already been marked.");
        }
        else{
            tasklist.mark(itemNumber - 1);
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(task);
            System.out.println(HORIZONTAL_LINE);
        }
    }
}
