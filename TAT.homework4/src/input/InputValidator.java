package input;

import java.util.ArrayList;

/**
 * Provides validating input attributes
 * @author Yury Suponev
 */
public class InputValidator {
  /**
   * Checks input attributes for emptiness and numbers for consisting
   * only digits and separating dot
   * @param attributes an array of input attributes
   * @return true if pass, otherwise false
   */
  public static boolean validate(ArrayList<String> attributes) {
    for (String attribute : attributes) {
      if (attribute.isEmpty()) {
        return false;
      }
    }
    if (!attributes.get(2).matches("[0-9]+")) {
      return false;
    }
    if (!attributes.get(3).matches("[0-9]+(.[0-9]+)?")) {
      return false;
    }
    return true;
  }
}
