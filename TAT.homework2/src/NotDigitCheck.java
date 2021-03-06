/**
 * Checks if the string does not contain digits
 * @author Yury Suponev
 */
public class NotDigitCheck extends Check {
  /**
   * Check the string according the rule
   * @param str the string for check
   * @return true if the string does not contain digits
   * @return false if the string contains digits
   */
  @Override
  public boolean checkString(String str) {
    char[] chars = str.toCharArray();
    for (char c : chars) {
      if(Character.isDigit(c)) {
        return false;
      }
    }
    System.out.println("...doesn't contain digits");
    return true;
  }
}
