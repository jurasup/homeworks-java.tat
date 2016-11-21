package report;

import commands.Command;
import java.util.LinkedList;

/**
 * Allows reporting for tests.
 * @author Yury Suponev
 */
public class Reporter {
  /**
   * Test states.
   */
  private static final String FAILED_STATE = "!";
  private static final String PASSED_STATE = "+";
  private static final String TIMEOUT_STATE = "X";
  private static final String SKIPPED_STATE = "?";
  /**
   * Reporter singleton.
   */
  private static Reporter reporter;
  /**
   * Reporting notes.
   */
  private LinkedList<String> notes = new LinkedList<>();

  private Reporter() {

  }

  /**
   * Allows to get reporter instance.
   * @return reporter
   */
  public static Reporter getReporter() {
    if (reporter == null) {
      reporter = new Reporter();
    }
    return reporter;
  }

  /**
   * Provides adding report-note for command.
   * @param command for reporting
   */
  public void addNote(Command command) {
    if (command != null) {
      notes.add(getState(command.getState()) + " [" + command.toString() + "] " + command.getExecutionTime() + "ms");
    }
  }

  /**
   * Provides adding report-note.
   * @param note for reporting
   */
  public void addNote(String note) {
    if (note != null) {
      notes.add(note);
    }
  }

  /**
   * Allows to get notes.
   * @return notes
   */
  public LinkedList<String> getNotes() {
    return notes;
  }

  private String getState(int state) {
    switch (state) {
      case Command.FAILED_STATE:
        return FAILED_STATE;
      case Command.PASSED_STATE:
        return PASSED_STATE;
      case Command.WARNING_PASSED_STATE:
        return TIMEOUT_STATE;
      default:
        return SKIPPED_STATE;
    }
  }
}
