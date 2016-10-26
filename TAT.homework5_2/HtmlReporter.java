import java.util.ArrayList;

/**
 * Creates parts of html-table containing two columns: "Server", "Response"
 * @author Yury Suponev
 */
public class HtmlReporter {
  private final String HEADER = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"" +
                               "name=\"author\" content=\"Yury Suponev\"></head><body>" +
                               "<table><tr style=\"background-color:#AAAAAA; vertical-align:center;\">" +
                               "<th style=\"width:300px; height:30px;\">Server</th>" +
                               "<th style=\"width:300px; height:30px;\">Response, ms</th></tr>";
  private final String FOOTER = "</table></body></html>";

  /**
   * Allows to ger HEADER
   * @return header
   */
  public String getHeader() {
    return HEADER;
  }

  /**
   * Allows to get FOOTER
   * @return footer
   */
  public String getFooter() {
    return FOOTER;
  }

  /**
   * Creates html-table row, containing server IP and its ping
   * @param attributes #1 IP, #2 Ping, #3 Color
   * @return html-row
   */
  public String getRow(ArrayList<String> attributes) {
    StringBuilder sb = new StringBuilder();
    sb.append("<tr style=\"background-color:#" + attributes.get(2) + "; height:30px;  text-align:left;\">");
    sb.append("<th style=\"font-weight:100\">" + attributes.get(0) + "</th>");
    sb.append("<th style=\"font-weight:100\">" + attributes.get(1) + "</th></tr>");
    return sb.toString();
  }
}
