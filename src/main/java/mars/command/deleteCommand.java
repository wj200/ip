package mars.command;

import mars.storage.Storage;
import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;


public class deleteCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private int itemNumber;

    public deleteCommand(int itemNumber){
        super();
        this.itemNumber = itemNumber;
    }

    public void execute(TaskList tasklist, UI ui, Storage storage){
        Task task = tasklist.get(itemNumber - 1);
        System.out.println("Noted. I've removed this task: " + task.toString());
        tasklist.delete(itemNumber -1);
        System.out.println("Now you have " + tasklist.size() + " tasks in the list.\n" + HORIZONTAL_LINE);
    }

}
