package transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import route.Checkpoint;

import static junit.framework.Assert.assertTrue;

/**
 * Test for Car.
 * @see Car
 */
public class CarTest {
  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void positiveTimePasses() throws Exception {
    Car car = new Car();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    car.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    car.moveTo(nextCheckpoint);
    assertTrue(car.time() > 0);
  }

  @Test
  public void positiveCostIncreases() throws Exception {
    Car car = new Car();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    car.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    car.moveTo(nextCheckpoint);
    assertTrue(car.cost() > 0);
  }

  @Test
  public void positiveNameCar() throws Exception {
    Car car = new Car();
    assertTrue(car.getName().equals("Car"));
  }

  @Test(expected = Exception.class)
  public void negativeCarZeroFuelConsumption() throws Exception {
    Car car = new Car(0.0, 1.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarZeroAverageSpeed() throws Exception {
    Car car = new Car(1.0, 0.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarNegativeFuelCost() throws Exception {
    Car car = new Car(1.0, 1.0, -1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarNegativeFuelConsumption() throws Exception {
    Car car = new Car(-1.0, 1.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarNegativeAverageSpeed() throws Exception {
    Car car = new Car(1.0, -1.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarInfiniteFuelConsumption() throws Exception {
    Car car = new Car(Double.POSITIVE_INFINITY, 1.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarInfiniteAverageSpeed() throws Exception {
    Car car = new Car(1.0, Double.POSITIVE_INFINITY, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarInfiniteFuelCost() throws Exception {
    Car car = new Car(1.0, 1.0, Double.POSITIVE_INFINITY);
  }

  @Test(expected = Exception.class)
  public void negativeCarInfiniteParameters() throws Exception {
    Car car = new Car(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  @Test(expected = Exception.class)
  public void negativeCarNanFuelConsumption() throws Exception {
    Car car = new Car(Double.NaN, 1.0, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarNanAverageSpeed() throws Exception {
    Car car = new Car(1.0, Double.NaN, 1.0);
  }

  @Test(expected = Exception.class)
  public void negativeCarNanFuelCost() throws Exception {
    Car car = new Car(1.0, 1.0, Double.NaN);
  }

  @Test(expected = Exception.class)
  public void negativeCarNanParameters() throws Exception {
    Car car = new Car(Double.NaN, Double.NaN, Double.NaN);
  }
}