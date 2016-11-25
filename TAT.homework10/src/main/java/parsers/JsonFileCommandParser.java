package parsers;

import com.google.gson.*;
import commands.CommandContainer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides parsing command instructions from json file.
 */
public class JsonFileCommandParser extends FileCommandParser {
  private final String COMMANDS_ATTRIBUTE = "commands";
  private final String NAME_ATTRIBUTE = "name";
  private final String PARAMETERS_ATTRIBUTE = "parameters";

  /**
   * Creates parser with defined source json file.
   * @param sourceFile
   */
  public JsonFileCommandParser(File sourceFile) {
    super(sourceFile);
  }

  /**
   * Allows to parse instructions from json file.
   * @return containers list of commands
   */
  @Override
  public List<CommandContainer> parse() {
    LinkedList<CommandContainer> containers = new LinkedList<>();
    try {
      JsonParser parser = new JsonParser();
      JsonObject json = parser.parse(new BufferedReader(new FileReader(getSourceFile()))).getAsJsonObject();
      JsonArray commandArray = json.getAsJsonArray(COMMANDS_ATTRIBUTE);
      for (JsonElement command : commandArray) {
        try {
          CommandContainer container = parse(command.getAsJsonObject());
          if (container != null) {
            containers.add(container);
          }
        } catch (IllegalStateException e) {
          System.out.println(e.getMessage());
        }
      }
    } catch (IOException | JsonParseException e) {
      System.out.println(e.getMessage());
    }
    return containers;
  }

  /**
   * Allows to parse single instruction.
   * @param command instruction
   * @return command
   */
  private CommandContainer parse(JsonObject command) {
    String commandName = command.get(NAME_ATTRIBUTE).getAsString();
    JsonArray jsonArray = command.get(PARAMETERS_ATTRIBUTE).getAsJsonArray();
    if (jsonArray != null) {
      String[] commandParameters = new String[jsonArray.size()];
      for (int i = 0; i < commandParameters.length; i++) {
        JsonElement element = jsonArray.get(i);
        if (!element.isJsonNull()) {
          commandParameters[i] = deleteQuotes(element.getAsString());
        } else {
          commandParameters[i] = null;
        }
      }
      return new CommandContainer(commandName, commandParameters);
    }
    return null;
  }

  /**
   * Allows to delete quotes in parameter.
   * @param parameter
   * @return parameter without quotes
   */
  private String deleteQuotes(String parameter) {
    return parameter.substring(1, parameter.length() - 1);
  }
}
