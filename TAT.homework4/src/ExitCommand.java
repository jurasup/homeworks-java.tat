import java.util.ArrayList;

/**
 * Represents a command providing exit from application
 * @author Yury Suponev
 */
public class ExitCommand extends Command {
  /**
   * Sets a string representation of command
   * @param command string transcription of the command
   */
  public ExitCommand(String command) {
    setCommand(command);
  }

  /**
   * Provides executing "exit" command by clearing the array
   * @param products an array of products
   * @param inputCommand input command
   */
  @Override
  public void runCommand(ArrayList<Product> products, String inputCommand) {
    products.clear();
  }
}
