package transport;

import java.util.ArrayList;

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
   * Number of passengers.
   */
  private int passengersNumber;

  /**
   * Creates bus with default parameters of fuel consumption and average speed.
   */
  public Bus(int passengersNumber) {
    super(FUEL_CONSUMPTION, AVERAGE_SPEED);
    this.passengersNumber = passengersNumber;
  }

  /**
   * Provides getting name of the vehicle "bus".
   * @return NAME
   */
  @Override
  public String getName() {
    return NAME;
  }

  /**
   * Fuel price is divided between passengers in buses.
   * @return statistics
   */
  @Override
  public ArrayList<Double> getStatistics() {
    Double cost = getRoute().getDistance() / 100 * FUEL_CONSUMPTION * super.getFuelCost() / passengersNumber;
    Double time = getRoute().getDistance() / AVERAGE_SPEED;
    ArrayList<Double> statistics = new ArrayList<>();
    statistics.add(cost);
    statistics.add(time);
    return statistics;
  }
}
