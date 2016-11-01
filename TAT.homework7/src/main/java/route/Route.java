package route;

/**
 * Provides tracking the route:
 * Calculating general distance;
 * Recording current position (checkpoint).
 * @author Yury Suponev
 */
public class Route {
  /**
   * Current position (checkpoint).
   */
  private Checkpoint currentCheckpoint;
  /**
   * Distance passed (in km).
   */
  private double distance = 0;

  /**
   * Allows to get passed distance.
   * @return distance
   */
  public double getDistance() {
    return distance;
  }

  /**
   * Sets start position if it wasn't initialized before,
   * otherwise tracks the moving to a next checkpoint by increasing passed distance.
   * @param nextCheckpoint
   */
  public void moveTo(Checkpoint nextCheckpoint) throws Exception {
    if (nextCheckpoint == null) {
      throw new Exception("Error: nonexistent checkpoint!");
    }
    if (currentCheckpoint != null) {
      double deltaX = currentCheckpoint.getFirstCoordinate() - nextCheckpoint.getFirstCoordinate();
      double deltaY = currentCheckpoint.getSecondCoordinate() - nextCheckpoint.getSecondCoordinate();
      distance += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
      currentCheckpoint = nextCheckpoint;
    } else {
      currentCheckpoint = nextCheckpoint;
    }
  }
}
