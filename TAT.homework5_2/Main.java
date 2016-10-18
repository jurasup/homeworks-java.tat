import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Defines an entry point for application providing creation of html-table
 * consisting list of servers with their response time
 * @author Yury Suponev
 */
public class Main {
  /**
   * Files: to read (containing servers list), to write (table will be here)
   */
  private static final String FILE_TO_READ = "server_list.txt";
  private static final String FILE_TO_WRITE = "servers_table.html";

  /**
   * Creates html-file containing table with servers IPs and their pings
   * Reads servers IPs from command line if it isn't empty, otherwise reads from file
   * @param args command line parameters
   */
  public static void main(String[] args) {
    ArrayList<String> ipList;
    IpReader ipReader = new IpReader();
    try {
      if (args.length != 0) {
        ipList = ipReader.readFromConsole(args);
      }
      else {
        ipList = ipReader.readFromFile(FILE_TO_READ);
      }
      AvailabilityChecker availabilityChecker = new AvailabilityChecker();
      TableBuilder tableBuilder = new TableBuilder();
      tableBuilder.build(availabilityChecker.getDelays(ipList), FILE_TO_WRITE);
    } catch (FileNotFoundException e) {
      System.out.println("Error: can't find file to read from.");
    } catch (IOException e) {
      System.out.println("Error: can't write to file.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
