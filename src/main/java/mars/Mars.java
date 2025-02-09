package mars;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import mars.storage.Storage;
import mars.task.Deadline;
import mars.task.Event;
import mars.task.Task;
import mars.task.Todo;


/**
 * mars.Mars class is the entry point of the taskbot's execution
 */

public class Mars {
    private List<Task> tasks;
    private Storage storage;

    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    /**
     * Constructor to instantiate mars.Mars instance with
     * the file path of marsBot.txt
     *
     * @param filePath The file path of marsBot.txt storing the tasks
     */
    public Mars(String filePath){
          this.storage = new Storage(filePath);
          this.tasks = new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        try{
            Mars mars = new Mars("./data/MarsBot.txt");
            while ()


        } catch (marsException e) {
            System.out.println(e.getMessage());
        }
        finally {
            ;
        }
    }
    /*Level 1. Echo*/
    private void echo(){
        System.out.println(" Hello! I'm mars.Mars\n What can I do for you?\n");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();

        while(!n.equals("bye")){
            System.out.println( HORIZONTAL_LINE+ n + "\n" + HORIZONTAL_LINE);
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        // reader.close();
    }

    /*Level 2. Add, List */
    private void store(List<Task> arrayList){
        System.out.println(" Hello! I'm mars.Mars\n What can I do for you?\n");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();
        while(!n.equals("bye")){
            if(n.equals("list")){
                Mars.list(arrayList);
            }
            else {
                Task task = new Task(n);
                arrayList.add(task);
                String output = HORIZONTAL_LINE + "added: " + n + "\n" + HORIZONTAL_LINE;
                System.out.println(output);
            }
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        //reader.close();
    }

    private static void list(List<Task> lst){
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Here are the tasks in your list:\n");
        int i = 1;
        while(i <= lst.size()){
            System.out.println(i + "." + lst.get(i-1));
            i += 1;
        }
        System.out.println(HORIZONTAL_LINE);
    }

    /*LEVEL 3*/
    private void mark(List<Task> lst){
        Scanner reader = new Scanner(System.in);
        String n = reader.next();
        int num = reader.nextInt();
        Task task = lst.get(num-1);
        task.markAsDone();

        System.out.println(HORIZONTAL_LINE +
                "Nice! I've marked this task as done: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

    private void unmark(List<Task> lst){
        Scanner reader = new Scanner(System.in);
        String n = reader.next();
        int num = reader.nextInt();

        Task task = lst.get(num-1);
        task.unmark();
        System.out.println(HORIZONTAL_LINE +
                "OK, I've marked this task as not done yet: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

    private void addTask(List<Task> lst){
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

    private void deleteTask(List<Task> lst){
        Scanner reader = new Scanner(System.in);
        String delete = reader.next();
        int num = reader.nextInt();
        System.out.println(HORIZONTAL_LINE);
            try {
                Task task = lst.get(num - 1);
                System.out.println("Noted. I've removed this task: " + task.toString());
                lst.remove(task);
                System.out.println("Now you have " + lst.size() + " tasks in the list.\n");
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Please input a valid index\n");
            }
        finally {
                reader.close();
            }

    }

    /* Level 7. Save */




}
