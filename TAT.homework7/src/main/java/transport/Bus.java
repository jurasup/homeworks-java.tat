package transport;

/**
 * Represents type of vehicle: bus.
 * Bus can move around its route and maintain statistics.
 * @author Yury Suponev
 */
public class Bus extends Vehicle {
  private static final String NAME = "Bus";
  /**
   * Default average fuel consumption for buses (L/100km).
   */
  private static final double FUEL_CONSUMPTION = 20.0;
  /**
   * Default average speed for buses (km/h).
   */
  private static final double AVERAGE_SPEED = 60.0;
  /**
   * Default price of the fuel ($).
   */
  private static final double FUEL_COST = 1.0;
  /**
   * Number of passengers.
   */
  private int passengersNumber = 30;

  /**
   * Creates bus with default parameters.
   */
  public Bus() throws Exception {
    super(FUEL_CONSUMPTION, AVERAGE_SPEED, FUEL_COST);
  }

  /**
   * Creates bus with defined parameters.
   * @param fuelConsumption
   * @param averageSpeed
   * @param fuelCost
   * @param passengersNumber
   */
  public Bus(double fuelConsumption, double averageSpeed, double fuelCost, int passengersNumber) throws Exception {
    super(fuelConsumption, averageSpeed, fuelCost);
    if (passengersNumber > 0) {
      this.passengersNumber = passengersNumber;
    } else {
      throw new Exception("Error: invalid parameters!");
    }
  }

  /**
   * Cost is divided by passengers in buses.
   * @return cost
   */
  @Override
  public double cost() {
    return super.cost() / passengersNumber;
  }

  /**
   * Provides getting name of the vehicle "bus".
   * @return NAME
   */
  @Override
  public String getName() {
    return NAME;
  }
}
