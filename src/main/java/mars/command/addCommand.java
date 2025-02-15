package mars.command;

import mars.Mars;
import mars.marsException;
import mars.task.Deadline;
import mars.task.Event;
import mars.task.Task;
import mars.task.Todo;

import java.util.ArrayList;
import java.util.Scanner;

import mars.task.TaskList;
import mars.ui.UI;
import mars.storage.Storage;


public class addCommand extends Command {
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private String taskType;
    private String details;
    public addCommand(String taskType ,String details){
        this.taskType = taskType;
        this.details = details;
    }

    public void execute(TaskList tasklist, UI ui, Storage storage){
        String taskType = this.taskType;
        String details = this.details;
        String[] parts;

        switch(taskType){
            case "todo":
                parts = details.split(" ", 2);
                if (parts[1].isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " + HORIZONTAL_LINE);
                }
                else {
                    System.out.println("Got it. I've added this task: \n");
                    tasklist.add(new Todo(parts[1], false));
                }
                break;
            case "deadline" :
                parts = details.split("/by", 2);
                if (parts[1].isEmpty()){
                    throw new marsException("Invalid or empty description of a " + taskType + "\n" +HORIZONTAL_LINE);
                }
                else {
                    String deadlineDesc = parts[0] + "(by: " + parts[1] + ")";
                    System.out.println("Got it. I've added this task: \n");
                    tasklist.add(new Deadline(deadlineDesc, false));
                }
                break;
            case "event" :
                parts = details.split(" ", 2);
                if (parts[1].isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " + HORIZONTAL_LINE);
                }
                else {
                    String[] event = parts[1].split("/from | /to ", 3);
                    if (event[0].isEmpty() || event[1].isEmpty() || event[2].isEmpty()){
                        throw new marsException("Invalid or empty description of a " + taskType + "\n" +HORIZONTAL_LINE);
                    }
                    else {
                        String eventDesc = event[0] + "from: " + event[1] + " to: " + event[2];
                        System.out.println("Got it. I've added this task: \n");
                        tasklist.add(new Event(eventDesc, false));
                    }
                }
                break;
            default: throw new marsException("OOPS!!! I'm sorry, but I don't know what that means :-(\n" + HORIZONTAL_LINE);
        }
        System.out.println(tasklist.getLast());

        if(tasklist.size() == 1){
            System.out.println("  Now you have 1 task in the list.\n");
        }
        else{
            System.out.println("  Now you have " + tasklist.size() + " tasks in the list.\n");
        }
        System.out.println(HORIZONTAL_LINE);

    }
}
