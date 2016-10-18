import java.io.*;

/**
 * Provides to handle files (get list of files with several attributes)
 * in current directory and to write to file
 * @author Yury Suponev
 */
public class FilesHandler {
  /**
   * HTML-file that is used to handling table
   */
  public final String fileToWrite = "table.html";
  /**
   * Allows to get list of files from current directory
   * @return list of files
   */
  public File[] getFileList() {
    File currentDir = new File(".");
    return currentDir.listFiles();
  }

  /**
   * Writes data to file
   * @param data to write
   * @throws IOException
   */
  public void writeToFile(String data) throws IOException {
    /*
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileToWrite), true));
    bw.write(data);
    bw.close();
    */
    BufferedWriter bw = new BufferedWriter
            (new OutputStreamWriter(new FileOutputStream(fileToWrite, true),"UTF-8"));
    bw.write(data);
    bw.close();
  }

  /**
   * Calculates size of file or directory
   * @param file to calculate
   * @return size in KBytes
   */
  public long getFileSize(File file) {
    if (file.isFile()) {
      return file.length();
    }
    long size = 0;
    File[] innerFiles = file.listFiles();
    for (File innerFile : innerFiles) {
      if (innerFile.isFile()) {
        size += innerFile.length();
      } else {
        size += getFileSize(innerFile);
      }
    }
    return size;
  }
}
