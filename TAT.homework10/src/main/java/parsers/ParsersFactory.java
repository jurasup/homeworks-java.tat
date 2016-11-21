package parsers;

import java.io.File;

/**
 * Allows to create {@code CommandParser} depending on command line parameters.
 * @author Yury Suponev
 */
public class ParsersFactory {
  private static final String FILE_SYMBOL = "-file";
  private static final String SEPARATOR_SYMBOL = "=";
  /**
   * Txt file format name.
   */
  public static final String TXT = ".txt";
  /**
   * Xml file format name.
   */
  public static final String XML = ".xml";
  /**
   * Json file format name.
   */
  public static final String JSON = ".json";

  /**
   * Allows to get {@code CommandParser}.
   * @param args command line parameters
   * @return parser
   */
  public CommandParser getParser(String[] args) {
    if (args[0].startsWith(FILE_SYMBOL + SEPARATOR_SYMBOL)) {
      String sourceFile = args[0].substring(args[0].lastIndexOf(SEPARATOR_SYMBOL) + 1);
      CommandParser parser = getFileCommandParser(sourceFile);
      if (parser != null) {
        return parser;
      }
    }
    return new CommandLineParser(args);
  }

  /**
   * Allows to get {@code FileCommandParser} with defined source file.
   * @param sourceFile
   * @return null if file doesn't exist, otherwise return parser
   */
  private FileCommandParser getFileCommandParser(String sourceFile) {
    File file = new File(sourceFile);
    if (file.exists()) {
      if (sourceFile.endsWith(JSON)) {
        return new JsonFileCommandParser(file);
      } else if (sourceFile.endsWith(XML)) {
        return new XmlFileCommandParser(file);
      } else {
        return new TxtFileCommandParser(file);
      }
    }
    return null;
  }

}
