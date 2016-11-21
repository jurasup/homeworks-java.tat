package report;

import commands.Command;

/**
 * Allows to track statistics for tests.
 */
public class TestStatistics implements Reportable {
  private static final String TOTAL_TESTS = "Total tests: ";
  private static final String PASSED_FAILED = "Passed/failed: ";
  private static final String TOTAL_TIME = "Total time: ";
  private static final String AVERAGE_TIME = "Average time: ";
  /**
   * Numbers of tests: all/failed/passed.
   */
  private static int testsNumber = 0;
  private static int failedTestsNumber = 0;
  private static int passedTestsNumber = 0;
  private static long executionTime = 0;

  public int getTestsNumber() {
    return testsNumber;
  }

  public int getFailedTestsNumber() {
    return failedTestsNumber;
  }

  public int getPassedTestsNumber() {
    return passedTestsNumber;
  }

  /**
   * Allows to count all tests, passed and failed of them.
   * @param passed defines if test were passed
   */
  public void addTest(Command command, boolean passed) {
    testsNumber++;
    executionTime += command.getExecutionTime();
    if (passed) {
      passedTestsNumber++;
    } else {
      failedTestsNumber++;
    }

  }

  /**
   * Allows to report statistics for all tests.
   */
  @Override
  public void report() {
    Reporter reporter = Reporter.getReporter();
    StringBuilder builder = new StringBuilder();
    builder.append(TOTAL_TESTS).append(testsNumber).append(System.lineSeparator())
            .append(PASSED_FAILED).append(passedTestsNumber).append("/").append(failedTestsNumber)
            .append(System.lineSeparator()).append(TOTAL_TIME).append(executionTime).append("ms")
            .append(System.lineSeparator());
    if (testsNumber == 0) {
      builder.append(TOTAL_TIME).append(executionTime).append("ms");
    } else {
      builder.append(AVERAGE_TIME).append(executionTime / testsNumber).append("ms");
    }
    reporter.addNote(builder.toString());
  }
}
