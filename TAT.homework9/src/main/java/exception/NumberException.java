package exception;

/**
 * Can be thrown if number doesn't satisfy several conditions (negative, infinite or NaN).
 * @author Yury Suponev
 */
public class NumberException extends Exception {
  private String message;
  /**
   * Error messages.
   */
  private final String NEGATIVE = "Error: number is negative!";
  private final String INFINITE = "Error: number is infinite!";
  private final String NAN = "Error: not a number!";
  private final String NUMBER_EXCEPTION = "Error: incorrect number!";
  /**
   * Error codes.
   */
  public static final int NEGATIVE_NUMBER_CODE = 1;
  public static final int INFINITE_NUMBER_CODE = 2;
  public static final int NAN_CODE = 3;


  /**
   * Creates new exception with error code.
   * @param errorCode
   */
  public NumberException(int errorCode) {
    switch (errorCode) {
      case NEGATIVE_NUMBER_CODE:
        message = NEGATIVE;
        break;
      case INFINITE_NUMBER_CODE:
        message = INFINITE;
        break;
      case NAN_CODE:
        message = NAN;
        break;
      default:
        message = NUMBER_EXCEPTION;
        break;
    }
  }

  /**
   * Allows to get error message.
   * @return message
   */
  @Override
  public String getMessage() {
    return message;
  }
}
