package commands;

/**
 * Provides containing command with parameters for further command building.
 * @author Yury Suponev
 */
public class CommandContainer {
  /**
   * Command name.
   */
  private String command;
  /**
   * Command parameters.
   */
  private String[] parameters;

  /**
   * Provides creation of {@code CommandContainer}.
   * @param command to contain
   * @param parameters of the command
   */
  public CommandContainer(String command, String[] parameters) {
    this.command = command;
    this.parameters = parameters;
  }

  /**
   * Allows to get command name.
   * @return command name
   */
  public String getCommand() {
    return command;
  }

  /**
   * Allows to get command parameters.
   * @return parameters
   */
  public String[] getParameters() {
    return parameters;
  }
}
