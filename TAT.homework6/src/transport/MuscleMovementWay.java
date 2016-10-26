package transport;

import route.Checkpoint;
import route.Route;

/**
 * Represents abstract way of movement using muscle force.
 * @author Yury Suponev
 */
public abstract class MuscleMovementWay implements Tour {
  private double averageSpeed;
  /**
   * Trip route.
   */
  private Route route = new Route();

  /**
   * Defines average speed.
   * @param averageSpeed
   */
  protected MuscleMovementWay(double averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  /**
   * Moves to the next checkpoint.
   * @param next checkpoint
   */
  @Override
  public void moveTo(Checkpoint next) {
    route.moveTo(next);
  }

  /**
   * Allows to get message with statistics (total price and time).
   * @return
   */
  @Override
  public String getStatistics() {
    return "Total price: it's free!   Total time: " + (route.getDistance() / averageSpeed);
  }

}
