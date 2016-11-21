package commands;

import exceptions.CommandException;
import main.FrameworkLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Represents command "checkLinkPresentByName".
 * @author Yury Suponev
 */
public class CheckLinkByNameCommand extends Command {
  private static final String CHECK_NAME_COMMAND = "checkLinkPresentByName";
  private String linkName;

  /**
   * Creates {@code CheckLinkByNameCommand} with parameter.
   * @param linkName
   */
  private CheckLinkByNameCommand(String linkName) {
    super();
    this.linkName = linkName;
  }

  /**
   * Returns string representation with following pattern: checkLinkPresentByName "LINK_NAME"
   * @return string representation
   */
  @Override
  public String toString() {
    return CHECK_NAME_COMMAND + " \"" + linkName + "\"";
  }

  /**
   * Allows to run the command.
   * @param driver used to run test.
   * @return {@code true} if test passed, otherwise return {@code false}
   */
  @Override
  public boolean run(WebDriver driver) {
    if (!driver.getCurrentUrl().equals(FrameworkLauncher.startPageUrl)) {
      By elementLocator = By.name(linkName);
      try {
        driver.findElement(elementLocator);
      } catch (NoSuchElementException e) {
        setState(FAILED_STATE);
        return false;
      }
      setState(PASSED_STATE);
      return true;
    } else {
      setState(SKIPPED_STATE);
      return false;
    }
  }

  /**
   * Provides {@code CheckLinkByNameCommand} creation.
   * @author Yury Suponev
   */
  public static class CommandBuilder extends Command.CommandBuilder {
    /**
     * Allows to build {@code CheckLinkByNameCommand} from {@code CommandContainer}.
     * @param container
     * @return null if this builder is not suitable, otherwise return command
     */
    public Command build(CommandContainer container) throws CommandException {
      if (canBuild(container)) {
        validate(container);
        return new CheckLinkByNameCommand(container.getParameters()[0]);
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
      return container.getCommand().equals(CHECK_NAME_COMMAND);
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
      if (parameters.length != 1) {
        throw new CommandException(fullCommand, "invalid parameters number.");
      }
      if (parameters[0] == null) {
        throw new CommandException(fullCommand, "null parameter.");
      }
      if (parameters[0].isEmpty()) {
        throw new CommandException(fullCommand, "empty parameter.");
      }
    }
  }
}
