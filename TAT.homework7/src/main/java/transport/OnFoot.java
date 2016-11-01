package transport;

import route.Checkpoint;
import route.Route;

/**
 * Represents touring on foot.
 * @author Yury Suponev
 */
public class OnFoot implements Tour {
  private static final String NAME = "On foot";
  /**
   * Trip route.
   */
  private Route route = new Route();
  /**
   * Default average speed for moving on foot (km/h).
   */
  private double averageSpeed = 5.0;
  /**
   * Trip cost
   */
  private static final double COST = 0.0;

  /**
   * Creates on foot moving way with default speed.
   */
  public OnFoot() {

  }

  /**
   * Creates on foot moving way with defined speed.
   * @param averageSpeed
   */
  public OnFoot(double averageSpeed) throws Exception {
    if (averageSpeed <= 0 || Double.isInfinite(averageSpeed) || Double.isNaN(averageSpeed)) {
      throw new Exception("Error: invalid parameters!");
    }
    this.averageSpeed = averageSpeed;
  }

  /**
   * Moves to the next checkpoint.
   * @throws Exception while moving to the nonexistent checkpoint
   * @param next checkpoint
   */
  @Override
  public void moveTo(Checkpoint next) throws Exception {
    route.moveTo(next);
  }

  /**
   * Provides getting resulting cost of the tour.
   * @return cost
   */
  @Override
  public double cost() {
    return COST;
  }

  /**
   * Provides getting resulting time of the tour.
   * @return time
   */
  @Override
  public double time() {
    return route.getDistance() / averageSpeed;
  }

  /**
   * Provides getting name of the moving way "on foot".
   * @return NAME
   */
  @Override
  public String getName() {
    return NAME;
  }
}
