package exceptions;

/**
 * Can be thrown if can't be created.
 */
public class CommandException extends Exception {
  /**
   * Creates {@code CommandException} with defined error message.
   * @param command with error
   * @param message error
   */
  public CommandException(String command, String message) {
    super("Wrong command: " + command + " - " + message);
  }
}
