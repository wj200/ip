import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Mars {
    public static void main(String[] args) {
        List<Task> arrayList = new ArrayList<>();
        /* PRE- COMMITS
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
         */

        /* LEVEL 0. Rename, Greet, Exit
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Mars\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________"); */
        try{
            Mars mars = new Mars();
            // mars.echo();
            //mars.store(arrayList);
            // mars.list(arrayList);
            // mars.mark(arrayList);
            // mars.unmark(arrayList);
            mars.addTask(arrayList);
        } catch (marsException e) {
            System.out.println(e.getMessage());
        }
        finally {
            ;
        }



    }

    /*Level 1. Echo*/
    private void echo(){
        System.out.println(" Hello! I'm Mars\n What can I do for you?\n");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();

        while(!n.equals("bye")){
            System.out.println("____________________________________________________________\n" +
                                n +
                                "\n____________________________________________________________\n");
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        // reader.close();
    }

    /*Level 2. Add, List */
    private void store(List<Task> arrayList){
        System.out.println(" Hello! I'm Mars\n What can I do for you?\n");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();
        while(!n.equals("bye")){
            if(n.equals("list")){
                Mars.list(arrayList);
            }
            else {
                Task task = new Task(n);
                arrayList.add(task);
                String output = "____________________________________________________________\n" +
                        "added: " + n +
                        "\n____________________________________________________________\n";
                System.out.println(output);
            }
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        //reader.close();
    }

    private static void list(List<Task> lst){
        Object[] taskArray = lst.toArray();
        System.out.println("____________________________________________________________\n");
        System.out.println("Here are the tasks in your list:\n");
        int i = 1;
        while(i <= taskArray.length){
            Task task = (Task) taskArray[i-1];
            String statusIcon = task.getStatusIcon();

            System.out.println(i + "." + taskArray[i - 1]);

            i += 1;
        }
        System.out.println("____________________________________________________________\n");
    }

    /*LEVEL 3*/
    private void mark(List<Task> lst){
        Object[] taskArray = lst.toArray();

        Scanner reader = new Scanner(System.in);
        String n = reader.next();
        int num = reader.nextInt();
        Task task = (Task) taskArray[num-1];
        task.markAsDone();

        System.out.println("____________________________________________________________\n" +
                "Nice! I've marked this task as done: ");
        System.out.println(task.toString());
        System.out.println("____________________________________________________________\n");
    }

    private void unmark(List<Task> lst){
        Object[] taskArray = lst.toArray();

        Scanner reader = new Scanner(System.in);
        String n = reader.next();
        int num = reader.nextInt();

        Task task = (Task) taskArray[num-1];
        task.unmark();
        System.out.println("____________________________________________________________\n" +
                "OK, I've marked this task as not done yet: ");
        System.out.println(taskArray[num -1].toString());
        System.out.println("____________________________________________________________\n");
    }

    private void addTask(List<Task> lst){
        Scanner reader = new Scanner(System.in);
        String taskType = reader.next();
        String description = reader.nextLine();
        System.out.println("____________________________________________________________\n");
        switch(taskType){
            case "todo":
                if (description.isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " +
                            "____________________________________________________________\n");
                }
                else {
                    System.out.println("Got it. I've added this task: \n");
                    lst.add(new Todo(description));
                }
                break;
            case "deadline" :
                if (description.isEmpty()){
                    throw new marsException("OOPS!!! The description of a " + taskType + " cannot be empty\n " +
                            "____________________________________________________________\n");
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
                            "____________________________________________________________\n");
                }
                else {
                    String[] event = description.split("/from | /to ", 3);
                    String eventDesc = event[0] + "from: " + event[1] + " to: " + event[2];
                    System.out.println("Got it. I've added this task: \n");
                    lst.add(new Event(eventDesc));
                }
                break;
                default: throw new marsException("OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                        "____________________________________________________________\n");
        }
        System.out.println(lst.getLast());

        if(lst.size() == 1){
            System.out.println("  Now you have 1 task in the list.\n");
        }
        else{
            System.out.println("  Now you have " + lst.size() + " tasks in the list.\n");
        }
        System.out.println("____________________________________________________________\n");

    }

}
