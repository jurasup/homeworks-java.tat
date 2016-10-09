/**
 * Checks if the string contains more than five words
 * @author Yury Suponev
 */
public class NumberOfWordsCheck extends Check implements Splitter {
  /**
   * Check the string according the rule
   * @param str the string for check
   * @return true if the string consists of more than five words
   * @return false if the string consists of five or less words
   */
  @Override
  public boolean checkString(String str) {
    int numberOfWords = 0;
    for (String s : splitString(str)) {
     if (!s.isEmpty()) {
       numberOfWords++;
     }
    }
    if (numberOfWords <= 5) {
      return false;
    }
    System.out.println("...contains more than five words");
    return true;
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
