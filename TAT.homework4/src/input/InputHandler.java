package input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Provides handling input data for further creating products
 * Creates a set of products type
 * @author Yury Suponev
 */
public class InputHandler {
  private HashSet<String> types;

  /**
   * Creates set of types
   */
  public InputHandler() {
    types = new HashSet<>();
  }

  /**
   * Handles input attributes for further creating products
   * @return inputs an array of entered attributes
   */
  public ArrayList<String> handle() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> attributes = new ArrayList<>();
    read(attributes, scanner);
    return attributes;
  }

  /**
   * Allows to get a set of product types
   * @return types a set of types
   */
  public HashSet<String> getTypes() {
    return types;
  }

  /**
   * Reads attributes of product from console and validates them
   * Recursively repeats request for input if isn't pass
   * @param attributes an array of attributes
   * @param scanner a {@code Scanner} that is used to read inputs
   */
  private void read(ArrayList<String> attributes, Scanner scanner) {
    System.out.println("Enter information about your product:");
    System.out.println("1. Type (ex. Car)...");
    attributes.add(scanner.nextLine());
    System.out.println("2. Name (ex. BMW)...");
    attributes.add(scanner.nextLine());
    System.out.println("3. Amount (only integers)...");
    attributes.add(scanner.nextLine());
    System.out.println("4. Price...");
    attributes.add(scanner.nextLine());
    if (!InputValidator.validate(attributes)) {
      System.out.println("Incorrect input. Try again...");
      attributes.clear();
      read(attributes, scanner);
    } else {
      types.add(attributes.get(0));
    }
  }
}
