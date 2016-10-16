import java.util.ArrayList;

/**
 * Creates an array of defined commands
 * @author Yury Suponev
 */
public class CommandBuilder {
  /**
   * List of commands
   */
  private ArrayList<Command> commands;

  public CommandBuilder() {
    commands = new ArrayList<>();
  }

  /**
   * Allows to build a command array
   * @param command command to add
   * @return a {@code Command} array
   */
  public CommandBuilder build(Command command) {
    commands.add(command);
    return this;
  }

  /**
   * Allows to get an array of commands
   * @return commands an array of commands
   */
  public ArrayList<Command> getCommands() {
    return commands;
  }
}
