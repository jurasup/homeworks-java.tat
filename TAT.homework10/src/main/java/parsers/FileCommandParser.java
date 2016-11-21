package parsers;

import java.io.File;

/**
 * Provides parsing command instructions from defined file.
 * @author Yury Suponev
 */
public abstract class FileCommandParser extends CommandParser {
  /**
   * File to parse.
   */
  private File sourceFile;

  /**
   * Allows to create {@code FileCommandParser} with defined source file.
   * @param sourceFile
   */
  protected FileCommandParser(File sourceFile) {
    this.sourceFile = sourceFile;
  }

  /**
   * Allows to get source file.
   * @return sourceFile
   */
  protected File getSourceFile() {
    return sourceFile;
  }
}
