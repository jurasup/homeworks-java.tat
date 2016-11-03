package transport;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import route.Checkpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Tests for Bicycle.
 * @see Bicycle
 */
public class BicycleTest {

  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider
  public Object[][] invalidSpeed() {
    return new Object[][] {
            {-1.0},
            {Double.POSITIVE_INFINITY},
            {Double.NEGATIVE_INFINITY},
            {Double.NaN}
    };
  }

  @Test
  public void positiveTimePasses() throws Exception {
    Bicycle bicycle = new Bicycle();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bicycle.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bicycle.moveTo(nextCheckpoint);
    assertTrue(bicycle.time() > 0);
  }

  @Test
  public void positiveCostFree() throws Exception {
    Bicycle bicycle = new Bicycle();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bicycle.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bicycle.moveTo(nextCheckpoint);
    assertEquals(0.0, bicycle.cost(), 1e-10);
  }

  @Test
  public void positiveNameBicycle() throws Exception {
    Bicycle bicycle = new Bicycle();
    assertTrue(bicycle.getName().equals("Bicycle"));
  }

  @Test(dataProvider = "invalidSpeed", expectedExceptions = Exception.class)
  public void negativeBicycleInvalidSpeed(double averageSpeed) throws Exception {
    Bicycle bicycle = new Bicycle(averageSpeed);
  }
}