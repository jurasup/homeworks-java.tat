package commands;

import exceptions.CommandException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

/**
 * Represents command "open" (opening web page).
 * @author Yury Suponev
 */
public class OpenCommand extends Command {
  private static final String OPEN_COMMAND = "open";
  private String url;
  private long timeout;

  /**
   * Creates {@code OpenCommand} with parameters.
   * @param url
   * @param timeout
   */
  private OpenCommand(String url, long timeout) {
    super();
    this.url = url;
    this.timeout = timeout;
  }

  /**
   * Returns string representation with following pattern: open "URL" "TIMEOUT"
   * @return string representation
   */
  @Override
  public String toString() {
    return OPEN_COMMAND + " \"" + url + "\" \"" + timeout + "\"";
  }

  /**
   * Allows to run the command.
   * @param driver used to run test.
   * @return {@code true} if test passed, otherwise return {@code false}
   */
  @Override
  public boolean run(WebDriver driver) {
    long start = System.currentTimeMillis();
    try {
      driver.get(url);
    } catch (TimeoutException e) {
      System.out.println("Connection to URL: " + url + " is failed.");
      setState(FAILED_STATE);
      return false;
    }
    long total = System.currentTimeMillis();
    total -= start;
    if (total > timeout) {
      setState(WARNING_PASSED_STATE);
    } else {
      setState(PASSED_STATE);
    }
    return true;
  }

  /**
   * Provides {@code OpenCommand} creation.
   * @author Yury Suponev
   */
  public static class CommandBuilder extends Command.CommandBuilder {
    /**
     * Allows to build {@code OpenCommand} from {@code CommandContainer}.
     * @param container
     * @return null if this builder is not suitable, otherwise return command
     */
    public Command build(CommandContainer container) throws CommandException {
      if (canBuild(container)) {
        validate(container);
        return new OpenCommand(container.getParameters()[0], Long.parseLong(container.getParameters()[1]));
      } else {
        return null;
      }
    }

    /**
     * Check if suitable builder is used.
     * @param container
     * @return {@code true} if {@code Command} can be build, otherwise return {@code false}
     */
    public boolean canBuild(CommandContainer container) {
      return container.getCommand().equals(OPEN_COMMAND);
    }

    /**
     * Verifies command parameters.
     * @param container
     * @throws CommandException if command format is invalid.
     */
    protected void validate(CommandContainer container) throws CommandException {
      String command = container.getCommand();
      String[] parameters = container.getParameters();
      String fullCommand = command;
      if (parameters == null) {
        throw new CommandException(fullCommand, "no parameters.");
      }
      for (String parameter : parameters) {
        fullCommand = fullCommand.concat(parameter).concat(" ");
      }
      if (parameters.length != 2) {
        throw new CommandException(fullCommand, "invalid parameters number.");
      }
      if (parameters[0] == null || parameters[1] == null) {
        throw new CommandException(fullCommand, "null parameters.");
      }
      if (parameters[0].isEmpty() || parameters[1].isEmpty()) {
        throw new CommandException(fullCommand, "empty parameters.");
      }
      if (!(parameters[0].startsWith("http://") || parameters[0].startsWith("https://"))) {
        throw new CommandException(fullCommand, "invalid protocol (must be \"http(s)://\")");
      }
      try {
        long timeout = Long.parseLong(parameters[1]);
        if (timeout <= 0) {
          throw new CommandException(fullCommand, "negative or zero timeout.");
        }
      } catch (NumberFormatException e) {
        throw new CommandException(fullCommand, "invalid timeout.");
      }
    }
  }
}
