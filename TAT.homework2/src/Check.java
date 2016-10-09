/**
 * Inheritors of this class are able to check the string for being in line with specific rule
 * @author Yury Suponev
 */
public abstract class Check {
  /**
   * Check a string according specific rule
   * @param str the string for check
   */
  abstract boolean checkString(String str);
}
