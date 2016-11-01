package transport;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import route.Checkpoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Tests for OnFoot.
 * @see OnFoot
 */
public class OnFootTest {

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
    OnFoot onFoot = new OnFoot();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    onFoot.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    onFoot.moveTo(nextCheckpoint);
    assertTrue(onFoot.time() > 0);
  }

  @Test
  public void positiveCostFree() throws Exception {
    OnFoot onFoot = new OnFoot();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    onFoot.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    onFoot.moveTo(nextCheckpoint);
    assertEquals(0.0, onFoot.cost(), 1e-10);
  }

  @Test
  public void positiveNameOnFoot() throws Exception {
    OnFoot onFoot = new OnFoot();
    assertTrue(onFoot.getName().equals("On foot"));
  }

  @Test(dataProvider = "invalidSpeed", expectedExceptions = Exception.class)
  public void negativeBicycleInvalidSpeed(double averageSpeed) throws Exception {
    OnFoot onFoot = new OnFoot(averageSpeed);
  }
}