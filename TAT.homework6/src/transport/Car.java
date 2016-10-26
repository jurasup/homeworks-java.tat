package transport;

/**
 * Represents type of vehicle: car.
 * Car can move around its route and maintain statistics.
 * @author Yury Suponev
 */
public class Car extends Vehicle {
  private static final String NAME = "Car";
  /**
   * Default average fuel consumption for cars (L/100km).
   */
  private static final double FUEL_CONSUMPTION = 10.0;
  /**
   * Default average speed for cars (km/h).
   */
  private static final double AVERAGE_SPEED = 70.0;

  /**
   * Creates car with default parameters of fuel consumption and average speed.
   */
  public Car() {
    super(FUEL_CONSUMPTION, AVERAGE_SPEED);
  }

  /**
   * Provides getting name of the vehicle "car".
   * @return NAME
   */
  @Override
  public String getName() {
    return NAME;
  }
}
