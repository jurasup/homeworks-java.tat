/**
 * Provides creating an array of {@code Check}
 * @author Yury Suponev
 */
public class CheckArray {
  private final int numberOfChecks = 4;
  private Check[] checks;

  /**
   * Creates an array of {@code Check}
   */
  public CheckArray() {
    checks = new Check[numberOfChecks];
    checks[0] = new DigitCheck();
    checks[1] = new NotDigitCheck();
    checks[2] = new VocabularyCheck();
    checks[3] = new NumberOfWordsCheck();
  }

  /**
   * Allows you to get an array of {@code Check}
   * @return checks an array
   */
  public Check[] getChecks() {
    return checks;
  }
}
