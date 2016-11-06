import exception.NumberException;

import java.util.Scanner;

/**
 * Defines an entry point.
 * @author Yury Suponev
 */
public class InputHandler {

  private static final int SIDES_NUMBER = 3;
  private static final String INVALID_INPUT = "Error: Invalid input. Try again using only positive numbers.";
  private static final String ENTER_NUMBER = "You are entering the length of side #";

  /**
   * Reads input numbers.
   * @param sidesLength Length of each triangle side
   */
  private void scan(double[] sidesLength) {
    int i = 0;
    Scanner scanner = new Scanner(System.in);
    InputValidator validator = new InputValidator();
    while (i < SIDES_NUMBER) {
      try {
        System.out.println(ENTER_NUMBER + (i + 1));
        String input = scanner.nextLine();
        validator.validate(input);
        sidesLength[i] = Double.parseDouble(input);
        i++;
      } catch (NumberFormatException e) {
        System.out.println(INVALID_INPUT);
      } catch (NumberException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   * Provides reading triangle sides length and triangle type definition.
   * @param args command line parameters
   */
  public static void main(String[] args) {
    InputHandler inputHandler = new InputHandler();
    double sidesLength[] = new double[SIDES_NUMBER];
    System.out.println("Enter the length of each triangle side (3 positive numbers):");
    inputHandler.scan(sidesLength);
    try {
      Triangle triangle = new Triangle(sidesLength[0], sidesLength[1], sidesLength[2]);
      System.out.println("This triangle is " + triangle.type());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}