package transport;

import route.Route;

/**
 * Represents touring on foot.
 * @author Yury Suponev
 */
public class OnFoot extends MuscleMovementWay {
  private static final String NAME = "On foot";
  /**
   * Default average speed for moving on foot (km/h).
   */
  private static final double AVERAGE_SPEED = 5.0;
  /**
   * Trip route.
   */
  private Route route = new Route();

  /**
   * Creates on foot moving way with default average speed.
   */
  public OnFoot() {
    super(AVERAGE_SPEED);
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
