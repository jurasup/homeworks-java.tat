package commands;

import exceptions.CommandException;

import java.util.ArrayList;

/**
 * Provides creation of {@code Command}.
 * @author Yury Suponev
 */
public class TestCommandsBuilder {
  /**
   * List of builders.
   */
  private ArrayList<Command.CommandBuilder> builders = new ArrayList<>();

  /**
   * Allows to add {@code CommandBuilder}.
   * @param builder to add
   * @return TestCommandBuilder to use over and over
   */
  public TestCommandsBuilder add(Command.CommandBuilder builder) {
    builders.add(builder);
    return this;
  }

  /**
   * Allows to build {@code Command}
   * @param container
   * @return command
   * @throws CommandException if command format is invalid
   */
  public Command build(CommandContainer container) throws CommandException {
    Command command = null;
    for (Command.CommandBuilder builder : builders) {
      if (builder.canBuild(container)) {
        command = builder.build(container);
        if (command != null) {
          return command;
        }
      }
    }
    String[] parameters = container.getParameters();
    String fullCommand = container.getCommand();
    for (String parameter : parameters) {
      fullCommand = fullCommand.concat(parameter).concat(" ");
    }
    throw new CommandException(fullCommand, "no such command.");
  }
}
