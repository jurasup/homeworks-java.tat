/**
 * Defines an entry point
 * @author Yury Suponev
 */
 
import java.util.Scanner;
 
public class Calculator {
  /**
   * Displays results of operations "+,-,/,*" applied to unput numbers 
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double a = 0;  //first number
    double b = 0;  //second number
    double ans = 0;
    boolean checkForIncorrect = false;  //flag for incorrect format of input data
	System.out.println("Please, enter 2 numbers");
    if (scanner.hasNextDouble()) {
      a = scanner.nextDouble();
      if (a == Double.POSITIVE_INFINITY || a == Double.NEGATIVE_INFINITY)
        checkForIncorrect = true;
	}
    else {
      checkForIncorrect = true;
    }
    if (scanner.hasNextDouble()) {
      b = scanner.nextDouble();
      if (b == Double.POSITIVE_INFINITY || b == Double.NEGATIVE_INFINITY)
        checkForIncorrect = true;
    }
    else {
      checkForIncorrect = true;
    }
    if (checkForIncorrect) {
      System.out.println("Incorrect input data");
    }
    else {
      ans = a + b;
      System.out.println(a + "+" + b + " = " + ans);
      ans = a - b;
      System.out.println(a + "-" + b + "2 = " + ans);
      if (Math.abs(b) < 0.00001d) {
        System.out.println(a + "/" + b + " = Infinity");
      }
      else {
        ans = a / b;
        System.out.println(a + "/" + b + " = " + ans);
      }
      ans = a * b;
      System.out.println(a + "x" + b + " = " + ans);
    }
  }
}