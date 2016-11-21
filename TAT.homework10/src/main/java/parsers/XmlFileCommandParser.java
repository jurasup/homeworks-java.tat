package parsers;

import commands.CommandContainer;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides parsing command instructions from xml file.
 */
public class XmlFileCommandParser extends FileCommandParser {
  private final String COMMAND_TAG = "command";

  /**
   * Creates parser with defined source xml file.
   * @param sourceFile
   */
  public XmlFileCommandParser(File sourceFile) {
    super(sourceFile);
  }

  /**
   * Allows to parse instructions from xml file.
   * @return containers list of commands
   */
  @Override
  public List<CommandContainer> parse() {
    LinkedList<CommandContainer> containers = new LinkedList<>();
    try {
      DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = f.newDocumentBuilder();
      Document document = builder.parse(getSourceFile());
      NodeList nodeList = document.getElementsByTagName(COMMAND_TAG);
      for (int i = 0; i < nodeList.getLength(); i++) {
        containers.add(parse(nodeList.item(i)));
      }
    } catch (ParserConfigurationException | SAXException | IOException e) {
      System.out.println(e.getMessage());
    }
    return containers;
  }

  /**
   * Allows to parse single tag.
   * @param tag
   * @return command
   */
  private CommandContainer parse(Node tag) {
    NodeList childNodes = tag.getChildNodes();
    ArrayList<String> parametersList = new ArrayList<>();
    for (int i = 0; i < childNodes.getLength(); i++) {
      if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) {
        continue;
      }
      parametersList.add(childNodes.item(i).getTextContent());
    }
    String[] commandParameters = new String[parametersList.size()];
    for (int i = 0; i < parametersList.size(); i++) {
      commandParameters[i] = parametersList.get(i);
    }
    NamedNodeMap map = tag.getAttributes();
    Node name = map.getNamedItem("name");
    return new CommandContainer(name.getNodeValue(), commandParameters);
  }
}
