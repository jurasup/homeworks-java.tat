package transport;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import route.Checkpoint;

import static org.testng.Assert.assertTrue;

/**
 * Tests for Bus.
 * @see Bus
 */
public class BusTest {

  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider
  public Object[][] invalidParameters() {
    return new Object[][] {
            {1.0, 1.0, 1.0, -1},
            {0.0, 1.0, 1.0, 10},
            {1.0, 0.0, 1.0, 10},
            {1.0, 1.0, 0.0, 10},
            {0.0, 0.0, 0.0, 10},
            {-1.0, 1.0, 1.0, 10},
            {1.0, -1.0, 1.0, 10},
            {1.0, 1.0, -1.0, 10},
            {-1.0, -1.0, -1.0, 10},
            {Double.POSITIVE_INFINITY, 1.0, 1.0, 10},
            {1.0, Double.POSITIVE_INFINITY, 1.0, 10},
            {1.0, 1.0, Double.POSITIVE_INFINITY, 10},
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 10},
            {Double.NEGATIVE_INFINITY, 1.0, 1.0, 10},
            {1.0, Double.NEGATIVE_INFINITY, 1.0, 10},
            {1.0, 1.0, Double.NEGATIVE_INFINITY, 10},
            {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 10},
            {Double.NaN, 1.0, 1.0, 10},
            {1.0, Double.NaN, 1.0, 10},
            {1.0, 1.0, Double.NaN, 10},
            {Double.NaN, Double.NaN, Double.NaN, 10}
    };
  }

  @Test
  public void positiveTimePasses() throws Exception {
    Bus bus = new Bus();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bus.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bus.moveTo(nextCheckpoint);
    assertTrue(bus.time() > 0);
  }

  @Test
  public void positiveCostIncreases() throws Exception {
    Bus bus = new Bus();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bus.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bus.moveTo(nextCheckpoint);
    assertTrue(bus.cost() > 0);
  }

  @Test
  public void positiveNameBus() throws Exception {
    Bus bus = new Bus();
    assertTrue(bus.getName().equals("Bus"));
  }

  @Test(dataProvider = "invalidParameters", expectedExceptions = Exception.class)
  public void negativeBusInvalidParameters(double consumption, double speed,
                                           double fuelCost, int passengersNumber) throws Exception {
    Bus bus = new Bus(consumption, speed, fuelCost, passengersNumber);
  }
}