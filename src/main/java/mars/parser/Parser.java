package mars.parser;

import mars.command.echoCommand;
import mars.command.addCommand;
import mars.command.deleteCommand;
import mars.command.listCommand;
import mars.command.markCommand;
import mars.command.unmarkCommand;
import mars.marsException;
import mars.command.Command;

/**
 * Parser class deals with making sense of the user command
 * returns Command object
 */

public class Parser {

    /**
     * Parses the user input and returns a command to execute.
     *
     * @param userInput The raw input provided by the user.
     * @return The command object.
     * @throws marsException If the input format is incorrect
     */
    public Command parse(String userInput) throws marsException {
        String[] parts = userInput.split(" ", 3);
        String commandWord = parts[0];
        switch(commandWord) {
            case "echo":
                return new echoCommand();
            case "todo":
                return new addCommand();
            case "deadline":
                return new addCommand();
            case "delete":
                Integer index = Integer.valueOf(parts[1]);
                return new deleteCommand();
            case "list":
                return new listCommand();
            case "mark":
                Integer index = Integer.valueOf(parts[1]);
                return new markCommand(index);
            case "unmark":
                Integer index = Integer.valueOf(parts[1]);
                return new unmarkCommand(index);
            default:
                throw new marsException("Unknown command: " + commandWord);
        }
    }

}
