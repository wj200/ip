package mars.command;

import mars.storage.Storage;
import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class byeCommand extends Command {
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasks, UI ui, Storage storage){
        System.out.println("Bye. Hope to see you again soon!\n" + HORIZONTAL_LINE);
    }

    @Override
    public boolean isExit(){
        return false;
    }

}
