import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides creating of html table containing list of files
 * @author Yury Suponev
 */
public class HtmlReporter {
  public final String HEADER = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\" name=\"author\" " +
          "content=\"Yury Suponev\"></head><body><table><tr style=\"background-color:#CCCCCC; " +
          "vertical-align:top;\"><th style=\"width:130px; height:40px;\">ИМЯ</th><th style=" +
          "\"width:130px; height:40px;\">ТИП</th><th style=\"width:130px; height:40px;\">" +
          "ДАТА СОЗДАНИЯ</th><th style=\"width:130px; height:40px;\">РАЗМЕР (В Kb)</th></tr>";
  public final String FOOTER = "</table></body></html>";
  private final String[] ROW_COLORS = {"AFFFFF", "F0FFFF"};

  /**
   * Provides adding a row to table
   * @param fileAttributes List of necessary arguments (Name, Type, Creation date, Size)
   * @param index Index of current row. Row color depends on its parity
   */
  public void addRow(ArrayList<String> fileAttributes, int index) throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append("<tr style=\"background-color:#");
    if (index % 2 == 0) {
      sb.append(ROW_COLORS[0] + "; text-align: left\">");
    } else {
      sb.append(ROW_COLORS[1] + "; text-align: left\">");
    }
    sb.append("<th style=\"font-weight:100;\">" + fileAttributes.get(0) + "</th>");
    sb.append("<th style=\"font-weight:100;\">" + fileAttributes.get(1) + "</th>");
    sb.append("<th style=\"font-weight:100;\">" + fileAttributes.get(2) + "</th>");
    sb.append("<th style=\"font-weight:100;\">" + fileAttributes.get(3) + "</th></tr>");
    new FilesHandler().writeToFile(sb.toString());
  }
}
