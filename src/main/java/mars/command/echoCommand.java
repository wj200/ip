package mars.command;

import mars.storage.Storage;
import mars.task.TaskList;
import mars.ui.UI;

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
