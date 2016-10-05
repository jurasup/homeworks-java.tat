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
  private static void scan(Scanner scanner, Double[] sidesLength) {
    int i = 0;
    while (i < SIDES_NUMBER) {
      try {
        System.out.println(ENTER_NUMBER + (i + 1));
        sidesLength[i] = Double.parseDouble(scanner.next());
        if (!sidesLength[i].isInfinite() && sidesLength[i] > 0) {
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
    Double sidesLength[] = new Double[SIDES_NUMBER];
    System.out.println("Enter the length of each triangle side (3 positive numbers):");
    scan(scanner, sidesLength);
    Triangle triangle = new Triangle(sidesLength[0], sidesLength[1], sidesLength[2]);
    System.out.println(triangle.toString());
  }
}