/**
 * Implementors of this interface are able to split the string with spaces and punctuation marks
 * @author Yury Suponev
 */
public interface Splitter {
  /**
   * Splits the string with spaces and punctuation marks
   * @param str the string for splitting
   * @return a {@code String} array consisting of words from string {@code str}
   */
  String[] splitString(String str);
}
