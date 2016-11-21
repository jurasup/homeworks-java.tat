package parsers;

import commands.CommandContainer;

import java.util.List;

/**
 * Provides parsing command instructions from defined source.
 * @author Yury Suponev
 */
public abstract class CommandParser {
  /**
   * Parses instruction source.
   * @return list of commands
   */
  public abstract List<CommandContainer> parse();
}
