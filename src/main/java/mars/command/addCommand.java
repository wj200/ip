package mars.command;

import mars.marsException;
import mars.storage.Storage;
import mars.task.Deadline;
import mars.task.Event;
import mars.task.TaskList;
import mars.task.Todo;
import mars.ui.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class addCommand extends Command {
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    static final DateTimeFormatter YEAR_MONTH_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static final DateTimeFormatter MONTH_DAY_YEAR = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

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
                    Todo todo =  new Todo(parts[1], false);
                    tasklist.add(todo);
                    System.out.println("Got it. I've added this task: \n" + todo);
                }
                break;
            case "deadline" :
                parts = details.split(" \\(by: ", 2);
                if (parts[1].isEmpty()){
                    throw new marsException("Invalid or empty description of a " + taskType + "\n" +HORIZONTAL_LINE);
                }
                else {
                    String endDate = parts[1];
                    String formattedEndDate = LocalDateTime.parse(endDate, MONTH_DAY_YEAR).format(YEAR_MONTH_DAY);
                    String deadlineDesc = parts[0] + " by " + formattedEndDate;
                    Deadline deadline = new Deadline(deadlineDesc, false);
                    tasklist.add(deadline);
                    System.out.println("Got it. I've added this task: \n" + deadline);
                }
                break;
            case "event" :
                parts = details.split(" ", 2);
                if (parts[1].isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " + HORIZONTAL_LINE);
                }
                else {
                    String[] desc = parts[1].split("\\(from: ", 2);
                    String event = desc[0];
                    String[] dates = desc[1].split(" to: ", 2);
                    String startDate = dates[0];
                    String endDate = dates[1].split("\\)")[0];

                    if (startDate.isEmpty() || endDate.isEmpty()){
                        throw new marsException("Invalid or empty description of a " + taskType + "\n" +HORIZONTAL_LINE);
                    }
                    else {
                        String formattedStartDate = LocalDateTime.parse(startDate, MONTH_DAY_YEAR).format(YEAR_MONTH_DAY);
                        String formattedEndDate = LocalDateTime.parse(endDate, MONTH_DAY_YEAR).format(YEAR_MONTH_DAY);
                        String eventDesc = event + "from: " + formattedStartDate + " to: " + formattedEndDate;
                        Event eventTask = new Event(eventDesc, false);
                        tasklist.add(eventTask);
                        System.out.println("Got it. I've added this task: \n" + eventTask);
                    }
                }
                break;
            default: throw new marsException("OOPS!!! I'm sorry, but I don't know what that means :-(\n" + HORIZONTAL_LINE);
        }


        if(tasklist.size() == 1){
            System.out.println("Now you have 1 task in the list.\n");
        }
        else{
            System.out.println("Now you have " + tasklist.size() + " tasks in the list.\n");
        }
        ui.showLine();

    }
}
