/**
 * Checks if the string contains more than five words
 * @author Yury Suponev
 */
public class NumberOfWordsCheck extends Check implements Splitter {
  /**
   * Check the string according the rule
   * @param str the string for check
   */
  @Override
  public void checkString(String str) {
    int numberOfWords = 0;
    for (String s : splitString(str)) {
     if (!s.isEmpty()) {
       numberOfWords++;
     }
    }
    if (numberOfWords <= 5) {
      satisfied = false;
    }
    if (satisfied) {
      System.out.println("...contains more than five words");
    }
  }

  /**
   * Splits the string with spaces and punctuation marks
   * @param str the string for splitting
   * @return a {@code String} array consisting of words from string {@code str}
   */
  @Override
  public String[] splitString(String str) {
    return str.split("[ .,!?:]");
  }
}
