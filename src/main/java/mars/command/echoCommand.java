package mars.command;

import java.util.Scanner;
import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;

public class echoCommand extends Command{
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    public void execute(TaskList tasks, UI ui, Storage storage){
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();
        while(!n.equals("bye")) {
            System.out.println(HORIZONTAL_LINE + n + "\n" + HORIZONTAL_LINE);
            n = reader.nextLine();
        }
        reader.close();
    }
}
