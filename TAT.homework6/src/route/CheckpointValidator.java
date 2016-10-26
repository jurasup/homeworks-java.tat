package route;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides validating checkpoints coordinates read from file.
 * @author Yury Suponev
 */
public class CheckpointValidator {
  /**
   * Valid coordinate pattern.
   */
  private final String VALID_PATTERN = "^(\\+|-)?\\d+(\\.\\d+)?";

  /**
   * Validates checkpoint.
   * @param lineFromFile line read from file
   * @return true if coordinates are valid, otherwise return false
   */
  public boolean validate(String lineFromFile) {
    String[] coordinates = lineFromFile.split(" ");
    if (coordinates.length != 2) {
      return false;
    } else if (coordinates[0].isEmpty() || coordinates[1].isEmpty()) {
      return false;
    }
    Pattern p = Pattern.compile(VALID_PATTERN);
    Matcher m = p.matcher(coordinates[0]);
    if (p.matcher(coordinates[0]).matches() && p.matcher(coordinates[1]).matches()) {
      return true;
    } else {
      return false;
    }
  }
}
