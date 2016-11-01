package transport;

import route.Checkpoint;
import route.Route;

/**
 * Represents abstract vehicle.
 * @author Yury Suponev
 */
public abstract class Vehicle implements Tour {
  private static final String INVALID_PARAMETERS = "Error: invalid parameters!";
  /**
   * Average fuel consumption (L/100km) of the vehicle.
   */
  private double fuelConsumption;
  /**
   * Price of the fuel.
   */
  private double fuelCost;
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
   * @param fuelCost
   */
  protected Vehicle(double fuelConsumption, double averageSpeed, double fuelCost) throws Exception {
    if (fuelConsumption <= 0.0 || Double.isInfinite(fuelConsumption) || Double.isNaN(fuelConsumption)) {
      throw new Exception(INVALID_PARAMETERS);
    }
    if (averageSpeed <= 0.0 || Double.isInfinite(averageSpeed) || Double.isNaN(averageSpeed)) {
      throw new Exception(INVALID_PARAMETERS);
    }
    if (fuelCost <= 0.0 || Double.isInfinite(fuelCost) || Double.isNaN(fuelCost)) {
      throw new Exception(INVALID_PARAMETERS);
    }
    this.fuelConsumption = fuelConsumption;
    this.averageSpeed = averageSpeed;
    this.fuelCost = fuelCost;
  }

  /**
   * Moves vehicle to the next checkpoint.
   * @throws Exception while moving to the nonexistent checkpoint
   * @param next checkpoint
   */
  @Override
  public void moveTo(Checkpoint next) throws Exception {
    route.moveTo(next);
  }

  /**
   * Calculates time spent on the trip.
   * @return time
   */
  @Override
  public double time() {
    return route.getDistance() / averageSpeed;
  }

  /**
   * Calculates cost of the trip.
   * @return cost
   */
  @Override
  public double cost() {
    return route.getDistance() / 100 * fuelConsumption * fuelCost;
  }
}
