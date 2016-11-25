package parsers;

import commands.CommandContainer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides parsing command instructions from command line.
 * example of the command: -command="open url timeout"
 * @author Yury Suponev
 */
public class CommandLineParser extends CommandParser {
  private static final String commandSymbol = "-command";
  private static final String separatorSymbol = "=";
  private String[] args;

  /**
   * Gets instructions from command line parameters.
   * @param args command line parameters
   */
  public CommandLineParser(String[] args) {
    this.args = args;
  }

  /**
   * Allows to parse instructions from command line.
   * @return containers list of commands
   */
  @Override
  public List<CommandContainer> parse() {
    LinkedList<CommandContainer> containers = new LinkedList<>();
    for (String arg : args) {
      CommandContainer container = parseArgument(arg);
      if (container != null) {
        containers.add(container);
      }
    }
    return containers;
  }

  /**
   * Parses single instruction.
   * @param arg command line parameter
   * @return null if parameter isn't a command, otherwise return command
   */
  private CommandContainer parseArgument(String arg) {
    if (arg.startsWith(commandSymbol)) {
      String[] parameters = arg.split("\\s+");
      String commandName = parameters[0].substring(parameters[0].lastIndexOf(separatorSymbol) + 1);
      String[] commandParameters = Arrays.copyOfRange(parameters, 1, parameters.length);
      return new CommandContainer(commandName, commandParameters);
    } else {
      System.out.println("Invalid command: " + arg);
      return null;
    }
  }
}
