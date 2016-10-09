/**
 * Implementors of this interface are able to check the string for being in line with specific rule
 * @author Yury Suponev
 */
public abstract class Check {
  protected boolean satisfied = true;
  /**
   * Check a string according specific rule
   * @param str the string for check
   */
  abstract void checkString(String str);

  /**
   * Returns the condition of check (confirmed/unconfirmed)
   * @return true if the rule is satisfied
   * @return false if the rule is not satisfied
   */
  public boolean isSatisfied() {
    return satisfied;
  }
}
