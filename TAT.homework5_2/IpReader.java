import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides reading IPs from command line or defined file
 * @author Yury Suponev
 */
public class IpReader {
  /**
   * Regular expression for validating IPv4
   */
  private String IP_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                               "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                               "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                               "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

  /**
   * Read IPs from defined file and returns list containing them
   * @param fileToRead
   * @return list of IPs
   * @throws FileNotFoundException if file is not found
   * @throws Exception if file is empty or there isn't any valid IP in it
   */
  public ArrayList<String> readFromFile(String fileToRead) throws FileNotFoundException, Exception {
    ArrayList<String> ipList = new ArrayList<>();
    Scanner scanner = new Scanner(new FileReader(fileToRead));
    if (!scanner.hasNext()) {
      throw new Exception("Error: file is empty.");
    }
    while (scanner.hasNext()) {
      String ip = scanner.nextLine();
      if (ip.matches(IP_PATTERN)) {
        ipList.add(ip);
      }
    }
    if (ipList.isEmpty()) {
      throw new Exception("Error: no valid IPs.");
    }
    return ipList;
  }

  /**
   * Read IPs from command line and returns list containing them
   * @param args command line arguments
   * @return list of IPs
   * @throws Exception if there isn't any valid IP
   */
  public ArrayList<String> readFromConsole(String[] args) throws Exception {
    ArrayList<String> ipList = new ArrayList<>();
    for (String arg : args) {
      if (arg.matches(IP_PATTERN)) {
        ipList.add(arg);
      }
    }
    if (ipList.isEmpty()) {
      throw new Exception("Error: no valid IPs.");
    }
    return ipList;
  }
}
