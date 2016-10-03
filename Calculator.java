import java.util.Scanner;
import java.lang.Double;

/**
 * Defines an entry point
 * @author Yury Suponev
 */  
public class Calculator {
	
  public static Double scan(Scanner scanner) {
	Double num;
    if (scanner.hasNextDouble()) {
      num = scanner.nextDouble();
      if (num > 1e10 || num < -1e10)
        return null;
	  return num;
	}
	else return null;
  }
  /**
   * Displays results of operations "+,-,/,*" applied to unput numbers 
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Double a;  //first number
    Double b;  //second number
    double ans = 0;
    boolean checkForIncorrect = false;  //flag for incorrect format of input data
	System.out.println("Please, enter 2 numbers");
    a = scan(scanner);
    b = scan(scanner);
	if (a == null || b == null)
	  checkForIncorrect = true;
    if (checkForIncorrect) {
      System.out.println("Incorrect input data");
    }
    else {
      ans = a + b;
      System.out.println(a + "+" + b + " = " + ans);
      ans = a - b;
      System.out.println(a + "-" + b + "2 = " + ans);
      if (Math.abs(b) < 1e-30) {
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