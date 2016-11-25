package commands;

import exceptions.CommandException;
import report.Reportable;
import report.Reporter;
import org.openqa.selenium.WebDriver;

/**
 * Represents command for testing.
 * @author Yury Suponev
 */
public abstract class Command implements Reportable {
  /**
   * Test states.
   */
  public static final int FAILED_STATE = 1;
  public static final int PASSED_STATE = 2;
  /**
   * Warning means timeout or something else.
   */
  public static final int WARNING_PASSED_STATE = 3;
  /**
   * Skipped means command "open" wasn't been executed before
   */
  public static final int SKIPPED_STATE = 4;
  private long executionTime;
  /**
   * Current test state.
   */
  private int state = 0;

  protected Command() {

  }

  /**
   * Allows to get execution time.
   * @return executionTime
   */
  public long getExecutionTime() {
    return executionTime;
  }

  /**
   * Allows to set execution time.
   * @param executionTime
   */
  public void setExecutionTime(long executionTime) {
    this.executionTime = executionTime;
  }

  /**
   * Allows to get test state.
   * @return state
   */
  public int getState() {
    return state;
  }

  /**
   * Allows to set test state.
   */
  protected void setState(int state) {
    if (state == PASSED_STATE || state == FAILED_STATE || state == WARNING_PASSED_STATE || state == SKIPPED_STATE) {
      this.state = state;
    }
  }

  /**
   * Allows to get string representation of the command.
   * @return string representation
   */
  @Override
  public abstract String toString();

  /**
   * @see Reportable#report()
   */
  @Override
  public void report() {
    Reporter reporter = Reporter.getReporter();
    reporter.addNote(this);
  }

  /**
   * Allows to run the command.
   * @param driver used to run test.
   * @return {@code true} if test passed, otherwise return {@code false}
   */
  public abstract boolean run(WebDriver driver);

  /**
   * Provides {@code Command} creation.
   * @author Yury Suponev
   */
  public abstract static class CommandBuilder {
    /**
     * Allows to build {@code Command} from {@code CommandContainer}.
     * @param container
     * @return command
     */
    public abstract Command build(CommandContainer container) throws CommandException;

    /**
     * Check if suitable builder is used.
     * @param container
     * @return {@code true} if {@code Command} can be build, otherwise return {@code false}
     */
    public abstract boolean canBuild(CommandContainer container);

    /**
     * Verifies command parameters.
     * @param container
     */
    protected abstract void validate(CommandContainer container) throws CommandException;
  }
}
