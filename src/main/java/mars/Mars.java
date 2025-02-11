package mars;

import java.util.Scanner;
import java.util.ArrayList;

import mars.storage.Storage;
import mars.task.Deadline;
import mars.task.Event;
import mars.task.Task;
import mars.task.Todo;

import mars.ui.UI;

/**
 * Mars class is the entry point of the taskbot's execution
 */

public class Mars {
    private ArrayList<Task> tasks;
    private ArrayList<String> taskStrings;
    private Storage storage;
    private UI ui;

    /**
     * Constructor to instantiate Mars instance with
     * the file path of marsBot.txt
     *
     * @param filePath The file path of marsBot.txt storing the tasks
     */
    public Mars(String filePath){
          this.storage = new Storage(filePath);
          this.ui = new UI();
          this.taskStrings = new ArrayList<>(storage.load());
    }

    public static void main(String[] args) {
        try{
            ArrayList<Task> tasks = new ArrayList<>();
            Mars mars = new Mars("./data/marsBot.txt" );
            mars.ui.welcomeMessage();
            while (true){
                Scanner reader = new Scanner(System.in);
                String command = reader.nextLine();
                if (command.equals("echo")){
                    Mars.echo();
                }
                else if (command.equals("bye")){
                    mars.ui.goodbyeMessage();
                }
                else if (command.equals("list")){
                    Mars.list(tasks);
                }
                else if(command.startsWith("mark")){
                    int index = Integer.parseInt(command.split(" ")[1]);
                    Task task = tasks.get(index-1);
                    task.markAsDone();
                    Mars.mark(task);
                }
                else if (command.startsWith("unmark")){
                    int index = Integer.parseInt(command.split(" ")[1]);
                    Task task = tasks.get(index-1);
                    task.unmark();
                    Mars.unmark(task);
                }
                else if (command.startsWith("todo") || command.startsWith("deadline") ||command.startsWith("event") ){
                    mars.addTask(tasks);
                    mars.storage.save(tasks);
                }
                else if(command.startsWith("delete")){
                    mars.deleteTask(tasks);
                    mars.storage.save(tasks);
                }
                else {
                    throw new IllegalArgumentException("Unknown command: " + command);
                }

            }
        } catch (marsException e) {
            System.out.println(e.getMessage());
        }
    }
    /*Level 1. Echo*/

    private static void echo(){
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();

        while(!n.equals("bye")) {
            System.out.println(HORIZONTAL_LINE + n + "\n" + HORIZONTAL_LINE);
            n = reader.nextLine();
        }
        // reader.close();
    }

    /*Level 2. Add, List */
    private void store(ArrayList<Task> arrayList){
        Mars.greet();
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
        Mars.bye();
        //reader.close();
    }

    private static void list(ArrayList<Task> lst){
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
    private static void mark(Task task){
        System.out.println(HORIZONTAL_LINE +
                "Nice! I've marked this task as done: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

    private static void unmark(Task task){
        System.out.println(HORIZONTAL_LINE +
                "OK, I've marked this task as not done yet: ");
        System.out.println(task);
        System.out.println(HORIZONTAL_LINE);
    }

    private void addTask(ArrayList<Task> lst){
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

    private void deleteTask(ArrayList<Task> lst){
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



}
