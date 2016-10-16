import java.util.ArrayList;

/**
 * Represents an abstract command
 * A string representation must be initialized in inheritors constructors
 * @author Yury Suponev
 */
public abstract class Command {
  /**
   * A string representation of the command
   * Every inheritor must initialize this field when created
   */
  private String command;

  /**
   * Defines a string representation of command
   * @param command string representation
   */
  protected void setCommand(String command) {
    this.command = command;
  }

  /**
   * Provides getting a string representation of the command
   * @return command
   */
  protected String getCommand() {
    return command;
  }

  /**
   * Compares external command with its own
   * @param command an external command
   * @return true if equal, otherwise false
   */
  public boolean compareCommand(String command) {
    return this.command.equals(command);
  }

  /**
   * Allows user to execute command
   * @param products an array of products to work with
   * @param inputCommand input command
   */
  public abstract void runCommand(ArrayList<Product> products, String inputCommand);
}
