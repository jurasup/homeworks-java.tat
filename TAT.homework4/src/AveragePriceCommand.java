import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 * Represents a command providing calculating average price of all goods
 * @author Yury Suponev
 */
public class AveragePriceCommand extends Command {
  /**
   * Sets a string representation of command
   * @param command string transcription of the command
   */
  public AveragePriceCommand(String command) {
    setCommand(command);
  }

  /**
   * Calculates an average price of products
   * @param products an array of products
   * @return average price
   */
  private BigDecimal calculateAveragePrice(ArrayList<Product> products) {
    BigDecimal averagePrice = new BigDecimal(0);
    BigDecimal numberOfProducts = new BigDecimal(0);
    for (Product product : products) {
      averagePrice = averagePrice.add(product.getAmount().multiply(product.getPrice()));
      numberOfProducts = numberOfProducts.add(product.getAmount());
    }
    return averagePrice.divide(numberOfProducts, MathContext.DECIMAL128);
  }

  /**
   * Provides executing "average price" command
   * @param products an array of products
   * @param inputCommand input command
   */
  @Override
  public void runCommand(ArrayList<Product> products, String inputCommand) {
    System.out.println("Average price " + " = " + calculateAveragePrice(products));
  }
}
