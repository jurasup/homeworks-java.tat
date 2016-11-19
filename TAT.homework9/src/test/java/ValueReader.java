import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Allows to read data required by tests from xml.
 * @author Yury Suponev
 */
public class ValueReader {
  /**
   * File to read from.
   */
  private static final String file = "test_data.xml";
  private Document document;
  /**
   * ValueReader singleton.
   */
  private static ValueReader reader;

  /**
   * Creates ValueReader with defined xml file to read from.
   * @throws Exception
   */
  private ValueReader() throws Exception {
    DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = f.newDocumentBuilder();
    document = builder.parse(file);
  }

  /**
   * Allows to ger reader instance (lazy initialization is used).
   * @return reader
   */
  public static ValueReader getReader() throws Exception {
    if (reader == null) {
      reader = new ValueReader();
    }
    return reader;
  }

  /**
   * Allows to get array of values from xml-file by tag and attributes names.
   * @param tagName
   * @param attributes names of attributes
   * @return values
   */
  public String[][] getNodeValuesByTagWithAttributes(String tagName, String[] attributes) {
    NodeList nodes = document.getElementsByTagName(tagName);
    String[][] result = new String[nodes.getLength()][];
    for (int i = 0; i < nodes.getLength(); i++) {
      NamedNodeMap map = nodes.item(i).getAttributes();
      String[] values = new String[attributes.length];
      for (int j = 0; j < attributes.length; j++) {
        values[j] = map.getNamedItem(attributes[j]).getNodeValue();
      }
      result[i] = values;
    }
    return result;
  }
}
