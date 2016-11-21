package commands;

import exceptions.CommandException;
import main.FrameworkLauncher;
import org.openqa.selenium.WebDriver;

/**
 * Represents command "checkPageTitle".
 * @author Yury Suponev
 */
public class CheckPageTitleCommand extends Command {
  private static final String CHECK_TITLE_COMMAND = "checkPageTitle";
  private String title;

  /**
   * Creates {@code CheckPageTitleCommand} with parameter.
   * @param title
   */
  private CheckPageTitleCommand(String title) {
    super();
    this.title = title;
  }

  /**
   * Returns string representation with following pattern: checkPageTitle "TITLE"
   * @return string representation
   */
  @Override
  public String toString() {
    return CHECK_TITLE_COMMAND + " \"" + title + "\"";
  }

  /**
   * Allows to run the command.
   * @param driver used to run test.
   * @return {@code true} if test passed, otherwise return {@code false}
   */
  @Override
  public boolean run(WebDriver driver) {
    if (!driver.getCurrentUrl().equals(FrameworkLauncher.startPageUrl)) {
      boolean passed = title.equals(driver.getTitle());
      if (passed) {
        setState(PASSED_STATE);
        return true;
      } else {
        setState(FAILED_STATE);
        return false;
      }
    } else {
      setState(SKIPPED_STATE);
      return false;
    }
  }

  /**
   * Provides {@code CheckPageTitleCommand} creation.
   * @author Yury Suponev
   */
  public static class CommandBuilder extends Command.CommandBuilder {
    /**
     * Allows to build {@code CheckPageTitleCommand} from {@code CommandContainer}.
     * @param container
     * @return null if this builder is not suitable, otherwise return command
     */
    public Command build(CommandContainer container) throws CommandException {
      if (canBuild(container)) {
        validate(container);
        return new CheckPageTitleCommand(container.getParameters()[0]);
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
      return container.getCommand().equals(CHECK_TITLE_COMMAND);
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
