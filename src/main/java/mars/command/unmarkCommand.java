package mars.command;

import mars.task.Task;

import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;


public class unmarkCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private int itemNumber;

    public unmarkCommand(int itemNumber){
       super();
       this.itemNumber = itemNumber;
   }

    public void execute(TaskList tasklist, UI ui, Storage storage){
        tasklist.unmark(itemNumber -1);
        Task task = tasklist.get(itemNumber -1);
        System.out.println("OK, I've marked this task as not done yet: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

}
