package transport;

import route.Checkpoint;
import route.Route;

import java.util.ArrayList;

/**
 * Represents bicycle.
 * @author Yury Suponev
 */
public class Bicycle implements Tour {
  private static final String NAME = "Bicycle";
  /**
   * Trip route.
   */
  private Route route = new Route();
  /**
   * Default average speed for bicycles (km/h).
   */
  private static final double AVERAGE_SPEED = 15.0;
  /**
   * Trip cost
   */
  private static final double COST = 0.0;

  /**
   * Moves bicycle to the next checkpoint.
   * @param next checkpoint
   */
  @Override
  public void moveTo(Checkpoint next) {
    route.moveTo(next);
  }

  /**
   * Allows to get statistics (total price and time).
   * @return statistics
   */
  @Override
  public ArrayList<Double> getStatistics() {
    Double cost = COST;
    Double time = route.getDistance() / AVERAGE_SPEED;
    ArrayList<Double> statistics = new ArrayList<>();
    statistics.add(cost);
    statistics.add(time);
    return statistics;
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
