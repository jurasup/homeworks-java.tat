package transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import route.Checkpoint;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Tests for Bicycle.
 * @see Bicycle
 */
public class BicycleTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

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

  @Test(expected = Exception.class)
  public void negativeBicycleNegativeAverageSpeed() throws Exception {
    Bicycle bicycle = new Bicycle(-1.0);
  }

  @Test(expected = Exception.class)
  public void negativeBicycleInfiniteAverageSpeed() throws Exception {
    Bicycle bicycle = new Bicycle(Double.POSITIVE_INFINITY);
  }

  @Test(expected = Exception.class)
  public void negativeBicycleNanAverageSpeed() throws Exception {
    Bicycle bicycle = new Bicycle(Double.NaN);
  }
}