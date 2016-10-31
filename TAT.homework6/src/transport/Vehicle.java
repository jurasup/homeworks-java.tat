package transport;

import route.Checkpoint;
import route.Route;

import java.util.ArrayList;

/**
 * Represents abstract vehicle.
 * @author Yury Suponev
 */
public abstract class Vehicle implements Tour {
  /**
   * Average fuel consumption (L/100km) of the vehicle.
   */
  private double fuelConsumption;
  /**
   * Default price of the fuel.
   */
  private static final double FUEL_COST = 1.0;
  /**
   * Average speed of the vehicle.
   */
  private double averageSpeed;
  /**
   * Trip route.
   */
  private Route route = new Route();

  /**
   * Creates vehicle with defined fuel consumption and average speed.
   * @param fuelConsumption
   * @param averageSpeed
   */
  protected Vehicle(double fuelConsumption, double averageSpeed) {
    this.fuelConsumption = fuelConsumption;
    this.averageSpeed = averageSpeed;
  }

  /**
   * Moves vehicle to the next checkpoint.
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
    Double cost = route.getDistance() / 100 * fuelConsumption * FUEL_COST;
    Double time = route.getDistance() / averageSpeed;
    ArrayList<Double> statistics = new ArrayList<>();
    statistics.add(cost);
    statistics.add(time);
    return statistics;
  }

  /**
   * Allows to get route.
   * @return route
   */
  protected Route getRoute() {
    return route;
  }

  /**
   * Allows to get fuel cost.
   * @return fuel cost
   */
  protected double getFuelCost() {
    return FUEL_COST;
  }
}
