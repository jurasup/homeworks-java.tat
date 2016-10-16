import input.InputHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Defines an entry point for application that provides user to handle goods
 * Maintains several commands: "count types", "count all", "average price",
 * "average price TYPE", "exit"
 * @author Yury Suponev
 */
public class ProductsHandler {
  public static final String[] TRANSCRIPTIONS = {"count types", "count all", "average price",
                                                 "exit", "average price "};
  public final String ENTER_COMMAND = "Enter a command, please...";
  public final String WANT_MORE = "Do you want to enter one more? (Y - yes, another symbol - no)";

  /**
   * Creates an array of products
   * Fill a set of product types
   * @return products array
   */
  private ArrayList<Product> createProducts(HashSet<String> types) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ProductBuilder productBuilder = new ProductBuilder();
    InputHandler inputHandler = new InputHandler();
    boolean createOneMore = true;
    while (createOneMore) {
      products.add(productBuilder.build(inputHandler.handle()));
      System.out.println(WANT_MORE);
      createOneMore = scanner.next().equals("Y");
    }
    types.addAll(inputHandler.getTypes());
    return products;
  }

  /**
   * Executes commands
   * @param products an array of products
   * @param commands an array of commands
   */
  private void runCommands(ArrayList<Product> products, ArrayList<Command> commands) {
    Scanner scanner = new Scanner(System.in);
    String inputCommand;
    while (!products.isEmpty()) {
      System.out.println(ENTER_COMMAND);
      System.out.println("Available commands:");
      for (String cmd : TRANSCRIPTIONS) {
        System.out.println(cmd);
      }
      boolean isFounded = false;
      inputCommand = scanner.nextLine();
      for (Command command : commands) {
        if (command.compareCommand(inputCommand)) {
          isFounded = true;
          command.runCommand(products, inputCommand);
        }
      }
      if (!isFounded) {
        System.out.println("Invalid command");
      }
    }
  }

  /**
   * Creates a list of commands
   * @param types an array of product types
   * @return commands list of commands
   */
  private ArrayList<Command> setCommandList(HashSet<String> types) {
    CommandBuilder commandBuilder = new CommandBuilder();
    ArrayList<Command> commands = commandBuilder.build(new CountTypesCommand(ProductsHandler.TRANSCRIPTIONS[0]))
            .build(new CountAllCommand(ProductsHandler.TRANSCRIPTIONS[1]))
            .build(new AveragePriceCommand(ProductsHandler.TRANSCRIPTIONS[2]))
            .build(new ExitCommand(ProductsHandler.TRANSCRIPTIONS[3]))
            .build(new AveragePriceTypeCommand(ProductsHandler.TRANSCRIPTIONS[4], types))
            .getCommands();
    return commands;
  }

  /**
   * An entry point of application
   * @param args command line arguments
   */
  public static void main(String[] args) {
    ProductsHandler productsHandler = new ProductsHandler();
    HashSet<String> types = new HashSet<>();
    ArrayList<Product> products = productsHandler.createProducts(types);
    ArrayList<Command> commands = productsHandler.setCommandList(types);
    productsHandler.runCommands(products, commands);
  }
}
