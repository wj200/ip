package mars.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

import mars.marsException;

/**
 * Wrapper class to an ArrayList of tasks
 * add, delete, mark, and unmark operations
 */
public class TaskList {
    static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList instance with an input list of tasks.
     *
     * @param tasks The initial list of tasks in string format.
     */
    public TaskList(ArrayList<String> tasks) {
        this.tasks = new ArrayList<>();

        try{
        for (String line : tasks) {
            String desc;
            boolean isDone = (line.charAt(5) == 'X');
            if (line.charAt(1) == 'T') {
                 desc = "todo " + line.substring(8);
            } else if (line.charAt(1) == 'D') {
                String remaining_line = line.substring(8);
                String[] split_line = remaining_line.split(" \\(by: ");
                String name = split_line[0];
                String endDate = split_line[1].split("\\)")[0];
                String formattedEndDate = LocalDateTime.parse(endDate, OUTPUT_FORMATTER).format(INPUT_FORMATTER);
                 desc= "deadline " + name + " /by " + formattedEndDate;
            } else {
                String remaining_line = line.substring(8);
                String[] split_line = remaining_line.split(" \\(from: ");
                String name = split_line[0];
                String[] dates = split_line[1].split(" to: ");
                String startDate = dates[0];
                String formattedStartDate = LocalDateTime.parse(startDate, OUTPUT_FORMATTER).format(INPUT_FORMATTER);
                String endDate = dates[1].split("\\)")[0];
                String formattedEndDate = LocalDateTime.parse(endDate, OUTPUT_FORMATTER).format(INPUT_FORMATTER);
                desc = "event " + name + " /from " + formattedStartDate + " /to " + formattedEndDate;
            }
            this.add(new Task(desc, isDone));
        }
        } catch (PatternSyntaxException e) {
           System.out.println("PatternSyntaxException: " + e.getMessage());
        }
    }

    /**
     * @return length of the ArrayList<Task>
     */
    public int size() {
         return tasks.size();
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task at the specified index.
     *
     * @param index array index of the task to be deleted
     * @throws marsException if the index is out of bounds.
     */
    public void delete(int index) throws marsException {
        if (index < 0 || index >= tasks.size()) {
                throw new marsException("invalid task number. Please try deleting again");
        }
        tasks.remove(index);
    }

    /**
     * Marks task as done at the specified index.
     *
     * @param index array index of the task to be marked as done
     * @throws marsException If the index is out of bounds.
     */
        public void markAsDone(int index) throws marsException {
            if (index < 0 || index >= tasks.size()) {
                throw new marsException("invalid task number. Please mark again");
            }
            tasks.get(index).mark();
        }

        /**
         * Unmarks a task at the specified index.
         *
         * @param index array index of the task to be unmarked
         * @throws marsException If the index is out of bounds.
         */
        public void unmarkTask(int index) throws marsException {
            if (index < 0 || index >= tasks.size()) {
                throw new marsException("invalid task number. Please unmark again");
            }
            tasks.get(index).unmark();
        }

        /**
         * @return The list of tasks as an ArrayList<Task>
         */
        public ArrayList<Task> getTasks() {
            return tasks;
        }

    /**
     * @return the task at the specified index
     */
    public Task get(int index) throws marException {
        if (index < 0 || index >= tasks.size()) {
            throw new marsException("invalid task number. Please try to get the specified taks again");
        }
        return tasks.get(index);
    }

    /**
     * Prints the task list to the console.
     */
        public void printList() {
            if (tasks.isEmpty()) {
                System.out.println("list is empty");
            }
            else if(tasks.size() == 1){
                System.out.println("  Now you have 1 task in the list.\n");
            }
            else {
                System.out.println(" Now you have " + tasks.size() + " tasks in the list.\n");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }
        }
}
}
