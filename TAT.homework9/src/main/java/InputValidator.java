import exception.NumberException;

/**
 * Provides validation for input string, containing length of the triangle side.
 * @author Yury Suponev
 */
public class InputValidator {
  /**
   * Verifies whether the input string is a positive number.
   * @param side
   * @throws NumberFormatException if string isn't a number
   * @throws NumberException if string isn't correct number
   */
  void validate(String side) throws NumberFormatException, NumberException {
    Double number = Double.parseDouble(side);
    if (number <= 0.0) {
      throw new NumberException(NumberException.NEGATIVE_NUMBER_CODE);
    } else if(number.isInfinite()) {
      throw new NumberException(NumberException.INFINITE_NUMBER_CODE);
    } else if (number.isNaN()) {
      throw new NumberException(NumberException.NAN_CODE);
    }
  }
}
