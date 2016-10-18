import java.util.Random;

/**
 * Provides request to server for response delay
 * @author Yury Suponev
 */
public class PingRequester {
  private final int MIN_VALUE = 10;
  private final int MAX_VALUE = 500;
  /**
   * Emulates request to server by generating random ping
   * @return ping in ms
   */
  public int request() {
    Random random = new Random();
    return random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
  }
}
