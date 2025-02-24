package mars.command;

import mars.storage.Storage;
import mars.task.Task;
import mars.task.TaskList;
import mars.ui.UI;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Platform;

public class byeCommand extends Command {
    public void execute(TaskList tasks, UI ui, Storage storage){
        String message = "Bye. Hope to see you again soon!\n"
        ui.setResponse(message);
        Platform.exit();
    }

    @Override
    public boolean isExit(){
        return true;
    }

}
