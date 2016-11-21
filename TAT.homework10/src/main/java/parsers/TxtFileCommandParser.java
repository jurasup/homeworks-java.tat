package parsers;

import commands.CommandContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides parsing command instructions from txt file.
 * example of the command: open url timeout
 */
public class TxtFileCommandParser extends FileCommandParser {
  /**
   * Creates parser with defined source txt file.
   * @param sourceFile
   */
  public TxtFileCommandParser(File sourceFile) {
    super(sourceFile);
  }

  /**
   * Allows to parse instructions from txt file.
   * @return containers list of commands
   */
  @Override
  public List<CommandContainer> parse() {
    LinkedList<CommandContainer> containers = new LinkedList<>();
    try {
      Scanner scanner = new Scanner(getSourceFile());
      while (scanner.hasNext()) {
        String[] parameters = scanner.nextLine().split("\\s+");
        String commandName = parameters[0];
        String[] commandParameters = Arrays.copyOfRange(parameters, 1, parameters.length);
        for (int i = 0; i < commandParameters.length; i++) {
          commandParameters[i] = deleteQuotes(commandParameters[i]);
        }
        containers.add(new CommandContainer(commandName, commandParameters));
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return containers;
  }

  /**
   * Allows to delete quotes in parameter.
   * @param parameter
   * @return parameter without quotes
   */
  private String deleteQuotes(String parameter) {
    return parameter.substring(1, parameter.length() - 1);
  }
}
