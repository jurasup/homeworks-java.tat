package report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Provides logging into defined txt file.
 * @author Yury Suponev
 */
public class FileLogger {
  private File fileToLog;

  /**
   * Creates {@code FileLogger} with file to log.
   * @param fileToLog
   */
  public FileLogger(File fileToLog) {
    this.fileToLog = fileToLog;
  }

  /**
   * Provides logging into txt file.
   * @throws IOException
   */
  public void log() throws IOException {
    Reporter reporter = Reporter.getReporter();
    LinkedList<String> notes = reporter.getNotes();
    FileWriter writer = new FileWriter(fileToLog);
    for (String note : notes) {
      writer.write(note + System.lineSeparator());
    }
    writer.flush();
    writer.close();
  }
}
