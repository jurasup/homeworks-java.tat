import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a command providing calculating average price of all goods
 * @author Yury Suponev
 */
public class AveragePriceTypeCommand extends Command {
  /**
   * All allowed commands
   */
  private ArrayList<String> commandsWithTypes;

  /**
   * Sets a string representation of command
   * @param command string transcription of the command
   */
  public AveragePriceTypeCommand(String command, HashSet<String> types) {
    setCommand(command);
    setCommandsWithTypes(types);
  }

  /**
   * Defines full commands to be able to run command
   * @param types a set of product types
   */
  private void setCommandsWithTypes(HashSet<String> types) {
    commandsWithTypes = new ArrayList<>();
    for (String type : types) {
      commandsWithTypes.add(getCommand() + type);
    }
  }

  /**
   * Compares external command with its own
   * @param command an external command
   * @return
   */
  @Override
  public boolean compareCommand(String command) {
    for (String commandWithType : commandsWithTypes) {
      if (commandWithType.equals(command)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Calculates average price for product of specific type
   * @param products an array of products
   * @param type TYPE of the product
   * @return average price
   */
  private BigDecimal calculateAveragePrice(ArrayList<Product> products, String type) {
    BigDecimal averagePrice = new BigDecimal(0);
    BigDecimal numberOfProducts = new BigDecimal(0);
    for (Product product : products) {
      if (product.getType().equals(type)) {
        averagePrice = averagePrice.add(product.getAmount().multiply(product.getPrice()));
        numberOfProducts = numberOfProducts.add(product.getAmount());
      }
    }
    return averagePrice.divide(numberOfProducts, MathContext.DECIMAL128);
  }

  /**
   * Provides executing "average price TYPE" command,
   * where TYPE is entered by user type of product
   * @param products an array of products
   * @param inputCommand input command
   */
  @Override
  public void runCommand(ArrayList<Product> products, String inputCommand) {
    String type = inputCommand.substring(inputCommand.lastIndexOf(' ') + 1, inputCommand.length());
    System.out.println("Average price for type " + type + " = " + calculateAveragePrice(products, type));
  }
}
