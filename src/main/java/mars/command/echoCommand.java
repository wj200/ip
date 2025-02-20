package mars.command;

import java.util.Scanner;
import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;

public class echoCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private String echo;

    public echoCommand(String echo){
        this.echo = echo;
    }

    public void execute(TaskList tasks, UI ui, Storage storage){
        System.out.println(this.echo + "\n" + HORIZONTAL_LINE);
    }

}
