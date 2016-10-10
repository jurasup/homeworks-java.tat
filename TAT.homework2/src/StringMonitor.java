import java.util.Scanner;

/**
 * Defines an entry point for the application, which determines whether a string satisfies the rules
 * @version 1.0
 * @author Yury Suponev
 */
public class StringMonitor {
  /**
   * Check the string
   * @param str the string for check
   */
  private static void check(String str) {
    CheckArray checkArray = new CheckArray();
    boolean satisfyAny = false;
    for (Check check : checkArray.getChecks()) {
      satisfyAny = check.checkString(str) || satisfyAny;
    }
    if (!satisfyAny) {
      System.out.println("...doesn't satisfy any rule");
    }
  }

  /**
   * Reads a string from console
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Type something");
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    str = str.trim();
    System.out.println("Your string: " + str);
    check(str);
  }
}
