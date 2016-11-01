package transport;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import route.Checkpoint;

import static org.testng.Assert.assertTrue;

/**
 * Test for Car.
 * @see Car
 */
public class CarTest {
  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider
  public Object[][] invalidParameters() {
    return new Object[][] {
            {0.0, 1.0, 1.0},
            {1.0, 0.0, 1.0},
            {1.0, 1.0, 0.0},
            {0.0, 0.0, 0.0},
            {-1.0, 1.0, 1.0},
            {1.0, -1.0, 1.0},
            {1.0, 1.0, -1.0},
            {-1.0, -1.0, -1.0},
            {Double.POSITIVE_INFINITY, 1.0, 1.0},
            {1.0, Double.POSITIVE_INFINITY, 1.0},
            {1.0, 1.0, Double.POSITIVE_INFINITY},
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, 1.0, 1.0},
            {1.0, Double.NEGATIVE_INFINITY, 1.0},
            {1.0, 1.0, Double.NEGATIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
            {Double.NaN, 1.0, 1.0},
            {1.0, Double.NaN, 1.0},
            {1.0, 1.0, Double.NaN},
            {Double.NaN, Double.NaN, Double.NaN}
    };
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

  @Test(dataProvider = "invalidParameters", expectedExceptions = Exception.class)
  public void negativeCarInvalidParameters(double consumption, double speed, double fuelCost) throws Exception {
    Car car = new Car(consumption, speed, fuelCost);
  }
}