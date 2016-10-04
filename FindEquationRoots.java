import java.util.Scanner;

/**
 * Defines an entry point.
 * @author Yury Suponev
 */
public class FindEquationRoots {

  private static final int COEFF_NUMBER = 3;
  private static final String INVALID_INPUT = "Invalid input, try again.";

  /**
   * Reads 3 numbers from console.
   * Prints out the warning message in case of invalid inputs.
   * @param scanner A Scanner object that is used to read inputs
   * @param coeff Quadratic equation coefficients
   */
  private static void scan(Scanner scanner, Double[] coeff) {
    int i = 0;
    while (i < COEFF_NUMBER) {
      try {
        coeff[i] = Double.parseDouble(scanner.next());
        if (!coeff[i].isInfinite()) {
          i++;
        } else {
          System.out.println(INVALID_INPUT);
        }
      } catch (NumberFormatException e) {
        System.out.println(INVALID_INPUT);
      }
    }
  }
	
  /**
   * Finds a roots of equation.
   * @param coeff Quadric equation coefficients
   * @param roots Solution (roots) of equation
   * @return false If is not quadric equation; true if it is.
   */
  private static boolean findRoots(Double[] coeff, Double[] roots) {
    double discriminant = coeff[1] * coeff[1] - 4 * coeff[0] * coeff[2];
    if (((Double)(1.0 / coeff[0])).isInfinite()) {
      System.out.println("Invalid inpit. Not a quadratic equation.");
      return false;
    }
    if (((Double)(1.0 / discriminant)).isInfinite()) {
      roots[0] = roots[1] = new Double(-coeff[1] / (2.0 * coeff[0]));
    } else if (discriminant > 0.0) {
      roots[0] = new Double((-coeff[1] + Math.sqrt(discriminant)) / (2 * coeff[0]));
      roots[1] = new Double((-coeff[1] - Math.sqrt(discriminant)) / (2 * coeff[0]));
    }
    return true;
 }
  
  /**
   * Prints out equation roots.
   * @param args Command line parameters
   */
  public static void main(String[] args) {
    System.out.println("Enter a coefficients of quadratic equation ax^2+bx+c");
    Scanner scanner = new Scanner(System.in);
    Double[] coefficients = new Double[3];
    scan(scanner, coefficients);
    Double[] roots = new Double[2];
    if (findRoots(coefficients,roots)) {
      if (roots[0] == null || roots[1] == null) {
        System.out.println("No real solutions.");
      } else {
        System.out.println("x1 = " + roots[0]);
        System.out.println("x2 = " + roots[1]);
      }
    }
  }
}