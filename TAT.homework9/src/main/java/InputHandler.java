import java.util.Scanner;

/**
 * Defines an entry point.
 * @author Yury Suponev
 */
public class InputHandler {

  private static final int SIDES_NUMBER = 3;
  private static final String INVALID_INPUT = "Invalid input. Try again using only positive numbers.";
  private static final String ENTER_NUMBER = "You are entering the length of side #";

  /**
   * Reads input numbers.
   * @param scanner Scanner object that is used to read numbers from console
   * @param sidesLength Length of each triangle side
   */
  private static void scan(Scanner scanner, double[] sidesLength) {
    int i = 0;
    while (i < SIDES_NUMBER) {
      try {
        System.out.println(ENTER_NUMBER + (i + 1));
        sidesLength[i] = Double.parseDouble(scanner.nextLine());
        if (sidesLength[i] > 0 && !Double.isInfinite(sidesLength[i]) && !Double.isNaN(sidesLength[i])) {
          i++;
        } else {
          System.out.println(INVALID_INPUT);
        }
      } catch (NumberFormatException e) {
        System.out.println(INVALID_INPUT);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double sidesLength[] = new double[SIDES_NUMBER];
    System.out.println("Enter the length of each triangle side (3 positive numbers):");
    scan(scanner, sidesLength);
    try {
      Triangle triangle = new Triangle(sidesLength[0], sidesLength[1], sidesLength[2]);
      System.out.println("This triangle is " + triangle.type());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}