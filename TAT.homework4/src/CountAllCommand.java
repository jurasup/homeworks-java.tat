import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Represents a command providing counting all goods
 * @author Yury Suponev
 */
public class CountAllCommand extends Command {

  /**
   * Sets a string representation of command
   * @param command string transcription of the command
   */
  public CountAllCommand(String command) {
    setCommand(command);
  }

  /**
   * Counts a whole number of products
   * @param products an array of products
   * @return number of products
   */
  private BigDecimal countAll(ArrayList<Product> products) {
    BigDecimal numberOfProducts = new BigDecimal(0);
    for (Product product : products) {
      numberOfProducts = numberOfProducts.add(product.getAmount());
    }
    return numberOfProducts;
  }

  /**
   * Provides executing "count all" command
   * @param products an array of products
   * @param inputCommand input command
   */
  @Override
  public void runCommand(ArrayList<Product> products, String inputCommand) {
    System.out.println("You have " + countAll(products) + " products");
  }
}
