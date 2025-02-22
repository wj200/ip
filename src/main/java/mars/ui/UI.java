package mars.ui;
import java.util.Scanner;

/**
 * The UI class handles all interactions with user, displaying messages and reading user input
 */
public class UI {
    private final Scanner sc;
    private static final String HORIZONTAL_LINE = "____________________________________________________________\n";

    /**
     * Constructor for UI class. Instantiates UI object with a new Scanner for reading user input.
     */
    public UI() {
        this.sc = new Scanner(System.in);
    }
        /**
         * Displays the welcome message when the application starts.
         */
        public void welcomeMessage() {
            System.out.println(HORIZONTAL_LINE);
            System.out.println("Hello! I'm Mars\n" + "What can I do for you?\n");
            System.out.println(HORIZONTAL_LINE);
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
    public void goodbyeMessage() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(HORIZONTAL_LINE);
    }
}


