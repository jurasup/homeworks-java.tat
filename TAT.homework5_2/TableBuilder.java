import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides creating of table containing list of servers with response delays
 * @author Yury Suponev
 */
public class TableBuilder {
  /**
   * Colors of rows in table
   */
  private static final String[] ROW_COLORS = {"FF0000", "AFFFFF", "F0FFFF"};

  /**
   * Creates a table with servers/delays list
   * @param serversWithDelays list of servers with response delays
   */
  public void build(HashMap<String, Integer> serversWithDelays, String fileToWrite) throws IOException {
    CommunicationQualitySupervisor supervisor = new CommunicationQualitySupervisor();
    int highestPing = supervisor.findHighestPing(serversWithDelays.values());
    int index = 0;
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
    HtmlReporter htmlReporter = new HtmlReporter();
    bw.write(htmlReporter.getHeader());
    for (Map.Entry<String, Integer> entry : serversWithDelays.entrySet()) {
      ArrayList<String> attributes = new ArrayList<>();
      attributes.add(entry.getKey());
      attributes.add(entry.getValue().toString());
      if (entry.getValue().intValue() == highestPing) {
        attributes.add(ROW_COLORS[0]);
      } else {
        if (index % 2 == 0) {
          attributes.add(ROW_COLORS[1]);
        } else {
          attributes.add(ROW_COLORS[2]);
        }
        index++;
      }
      bw.write(htmlReporter.getRow(attributes));
    }
    bw.write(htmlReporter.getFooter());
    bw.close();
  }
}
