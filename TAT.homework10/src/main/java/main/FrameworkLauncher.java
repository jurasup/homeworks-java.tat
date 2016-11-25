package main;

import commands.*;
import exceptions.CommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import parsers.ParsersFactory;
import report.FileLogger;
import report.Reporter;
import report.TestStatistics;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides testing web-page with several commands.
 * @author Yury Suponev
 */
public class FrameworkLauncher {
  private static final String logFile = "log.txt";
  private static WebDriver driver;
  public static String startPageUrl;

  static {
    driver = new HtmlUnitDriver();
    startPageUrl = driver.getCurrentUrl();
  }

  /**
   * Allows to get command builder.
   * @return builder
   */
  private TestCommandsBuilder getBuilder() {
    TestCommandsBuilder builder = new TestCommandsBuilder();
    builder.add(new OpenCommand.CommandBuilder())
            .add(new CheckLinkByHrefCommand.CommandBuilder())
            .add(new CheckLinkByNameCommand.CommandBuilder())
            .add(new CheckPageTitleCommand.CommandBuilder())
            .add(new CheckPageContainsCommand.CommandBuilder());
    return builder;
  }

  /**
   * Allows to get commands list.
   * @param builder
   * @param containers list
   * @return list of commands
   */
  private LinkedList<Command> getCommands(TestCommandsBuilder builder, List<CommandContainer> containers) {
    LinkedList<Command> commands = new LinkedList<>();
    for (CommandContainer container : containers) {
      try {
        commands.add(builder.build(container));
      } catch (CommandException e) {
        System.out.println(e.getMessage());
      }
    }
    return commands;
  }

  /**
   * Defines an entry point for framework.
   * "-file" command line parameter defines file with instructions.
   * @param args command line parameters
   */
  public static void main(String[] args) {
    if (args.length > 0) {
      FrameworkLauncher launcher = new FrameworkLauncher();
      TestCommandsBuilder builder = launcher.getBuilder();
      LinkedList<Command> commands = launcher.getCommands(builder, new ParsersFactory().getParser(args).parse());
      Reporter reporter = Reporter.getReporter();
      TestStatistics statistics = new TestStatistics();
      for (Command command : commands) {
        long startTime = System.currentTimeMillis();
        boolean passed = command.run(driver);
        long totalTime = System.currentTimeMillis();
        totalTime -= startTime;
        command.setExecutionTime(totalTime);
        statistics.addTest(command, passed);
        reporter.addNote(command);
      }
      statistics.report();
      FileLogger logger = new FileLogger(new File(logFile));
      try {
        logger.log();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
      driver.close();
    } else {
      System.out.println("Error: empty command line arguments.");
    }
  }
}
