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
   * Default price of the fuel ($).
   */
  private static final double FUEL_COST = 1.0;

  /**
   * Creates car with default parameters.
   */
  public Car() throws Exception {
    super(FUEL_CONSUMPTION, AVERAGE_SPEED, FUEL_COST);
  }

  /**
   * Creates car with defined parameters.
   * @param fuelConsumption
   * @param averageSpeed
   * @param fuelCost
   */
  public Car(double fuelConsumption, double averageSpeed, double fuelCost) throws Exception {
    super(fuelConsumption, averageSpeed, fuelCost);
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
