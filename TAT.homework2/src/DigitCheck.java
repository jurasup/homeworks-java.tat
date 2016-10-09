/**
 * Checks if the string consists only of digits
 * @author Yury Suponev
 */
public class DigitCheck extends Check {
  /**
   * Check the string according the rule
   * @param str the string for check
   * @return true if the string consists only of digits
   * @return false if the string contains something except digits
   */
  @Override
  public boolean checkString(String str) {
    char[] chars = str.toCharArray();
    if (chars.length > 0) {
      for (char c : chars) {
        if (!Character.isDigit(c)) {
          return false;
        }
      }
    }
    System.out.println("...consists only of digits");
    return true;
  }
}
