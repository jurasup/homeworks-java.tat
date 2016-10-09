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
    DigitCheck digitCheck = new DigitCheck();
    NotDigitCheck notDigitCheck = new NotDigitCheck();
    VocabularyCheck vocabularyCheck = new VocabularyCheck();
    NumberOfWordsCheck numberOfWordsCheck = new NumberOfWordsCheck();
    digitCheck.checkString(str);
    notDigitCheck.checkString(str);
    vocabularyCheck.checkString(str);
    numberOfWordsCheck.checkString(str);
    if (!digitCheck.isSatisfied() && !notDigitCheck.isSatisfied() && !vocabularyCheck.isSatisfied()
        && !numberOfWordsCheck.isSatisfied()) {
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
