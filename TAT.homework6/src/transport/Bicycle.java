package transport;

/**
 * Represents bicycle.
 * @author Yury Suponev
 */
public class Bicycle extends MuscleMovementWay {
  private static final String NAME = "Bicycle";
  /**
   * Default average speed for bicycles (km/h).
   */
  private static final double AVERAGE_SPEED = 15.0;

  /**
   * Creates bicycle with default average speed.
   */
  public Bicycle() {
    super(AVERAGE_SPEED);
  }

  /**
   * Provides getting name of the moving way "by bicycle".
   * @return NAME
   */
  @Override
  public String getName() {
    return NAME;
  }
}
