package mars.ui;
import java.util.Scanner;

/**
 * The UI class handles all interactions with user, displaying messages and reading user input
 */
public class UI {
    private final Scanner sc;
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";
    private String latestResponse;

    /**
     * Constructor for UI class. Instantiates UI object with a new Scanner for reading user input.
     */
    public UI() {
        this.sc = new Scanner(System.in);
    }
        /**
         * Displays the welcome message when the application starts.
         */
        public String welcomeMessage() {
            return HORIZONTAL_LINE + "Hello! I'm Mars, your personalised TaskList Assistant\n" + "Please enter a User Command\n"
                   +  HORIZONTAL_LINE;
        }

        public void showLine(){
            System.out.println(HORIZONTAL_LINE);
        }

        /**
         * Displays a given error message.
         *
         * @param message The error message to display.
         */
        public void showError(String message) {
                System.out.println(message);
            }

            /**
             * Reads in command from the user.
             *
             * @return command entered by the user as a string.
             */

            public String readCommand() {
                return sc.nextLine();
            }

            /**
             * Closes scanner object
             */
            public void close() {
                sc.close();
            }

    public String userGuide() {
        String guide = "QUICK GUIDE TO MARS:\n"
                + "\nTo add a ToDo:\n   'todo {task name}'"
                + "\nTo add a Deadline:\n   'deadline {task name} (by: MMM dd yyyy, h:mm a'"
                + "\nTo add an Event:\n   'event {task name} (from: MMM dd yyyy, h:mm a to MMM dd yyyy, h:mm a'\n"
                + "\nTo add an DoWithin:\n 'do within {task name} between: MMM dd yyyy, h:mm a and MMM dd yyyy, h:mm a'";

        String userCommands = "\nOTHER USER COMMANDS:\n"
                + "\n1. list  <This shows the list of ACTIVE tasks>"
                + "\n2. delete  {task number}"
                + "\n3. mark  {task number}"
                + "\n4. unmark  {task number}"
                + "\n5. find  {keyword}";

        latestResponse = guide + userCommands;
        return latestResponse;
    }

    public void goodbyeMessage() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(HORIZONTAL_LINE);
    }

    public String getResponse(){ return latestResponse;}



}


