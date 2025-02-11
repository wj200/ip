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

    public addCommand(){

    }
    public addCommand(){

    }
    public addCommand(){

    }


    public void execute(TaskList tasklist, UI ui, Storage storage){
        Scanner reader = new Scanner(System.in);
        String taskType = reader.next();
        String description = reader.nextLine();
        System.out.println(HORIZONTAL_LINE);
        switch(taskType){
            case "todo":
                if (description.isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " + HORIZONTAL_LINE);
                }
                else {
                    System.out.println("Got it. I've added this task: \n");
                    lst.add(new Todo(description));
                }
                break;
            case "deadline" :
                if (description.isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " +
                            HORIZONTAL_LINE);
                }
                else {
                    String[] parts = description.split("/by", 2);
                    String deadlineDesc = parts[0] + "(by: " + parts[1] + ")";
                    System.out.println("Got it. I've added this task: \n");
                    lst.add(new Deadline(deadlineDesc));
                }
                break;
            case "event" :
                if (description.isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " +
                            HORIZONTAL_LINE);
                }
                else {
                    String[] event = description.split("/from | /to ", 3);
                    String eventDesc = event[0] + "from: " + event[1] + " to: " + event[2];
                    System.out.println("Got it. I've added this task: \n");
                    lst.add(new Event(eventDesc));
                }
                break;
            default: throw new marsException("OOPS!!! I'm sorry, but I don't know what that means :-(\n" + HORIZONTAL_LINE);
        }
        System.out.println(lst.getLast());

        if(lst.size() == 1){
            System.out.println("  Now you have 1 task in the list.\n");
        }
        else{
            System.out.println("  Now you have " + lst.size() + " tasks in the list.\n");
        }
        System.out.println(HORIZONTAL_LINE);

    }
}
