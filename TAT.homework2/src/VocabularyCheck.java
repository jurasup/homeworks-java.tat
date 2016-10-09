/**
 * Checks if the string contains words from vocabulary
 * @author Yury Suponev
 */
public class VocabularyCheck extends Check implements Splitter {
  private String[] vocabulary = {"love","doing","my","homework"};

  /**
   * Check the string according the rule
   * @param str the string for check
   */
  @Override
  public void checkString(String str) {
    satisfied = false;
    for (String word : vocabulary) {
      for (String s : splitString(str)) {
        if (!s.isEmpty() && s.toLowerCase().equals(word.toLowerCase())) {
          System.out.println("...contains word from vocabulary: " + word);
          satisfied = true;
        }
      }
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
