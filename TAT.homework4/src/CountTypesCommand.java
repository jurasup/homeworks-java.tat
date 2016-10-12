import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a command providing counting all types of goods
 * @author Yury Suponev
 */
public class CountTypesCommand extends Command {

  /**
   * Sets a string representation of command
   * @param command string transcription of the command
   */
  public CountTypesCommand(String command) {
    setCommand(command);
  }

  /**
   * Calculates number of types
   * @param products an array of products
   * @return number of products
   */
  private int countTypes(ArrayList<Product> products) {
    HashSet<String> types = new HashSet<>();
    for (Product product : products) {
      types.add(product.getType());
    }
    return types.size();
  }

  /**
   * Provides executing "count types" command
   * @param products an array of products
   * @param inputCommand input command
   */
  @Override
  public void runCommand(ArrayList<Product> products, String inputCommand) {
    System.out.println("You have " + countTypes(products) + " type(s)");
  }
}
