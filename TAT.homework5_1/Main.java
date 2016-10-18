import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Defines an entry point of application providing creation of html file
 * with table containing list of files from current directory
 */
public class Main {
  /**
   * Creates html-file with table, containing list of files from current directory
   * @param args command line parameters
   */
  public static void main(String[] args) {
    try {
      FilesHandler filesHandler = new FilesHandler();
      HtmlReporter htmlReporter = new HtmlReporter();
      filesHandler.writeToFile(htmlReporter.HEADER);
      File[] files = filesHandler.getFileList();
      int index = 0;
      for (File file : files) {
        ArrayList<String> fileAttributes = new ArrayList<>();
        fileAttributes.add(file.getName());
        fileAttributes.add(file.isDirectory() ? "DIR" : "FILE");
        BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getCanonicalPath()), BasicFileAttributes.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        fileAttributes.add(dateFormat.format(attr.creationTime().toMillis()));
        fileAttributes.add(String.valueOf(filesHandler.getFileSize(file)/1024));
        htmlReporter.addRow(fileAttributes, index++);
      }
      filesHandler.writeToFile(htmlReporter.FOOTER);
    } catch (IOException e) {
      System.out.println("Can't write to file");
    }
  }
}
