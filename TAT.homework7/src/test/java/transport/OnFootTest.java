package transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import route.Checkpoint;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Tests for OnFoot.
 * @see OnFoot
 */
public class OnFootTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

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

  @Test(expected = Exception.class)
  public void negativeOnFootNegativeAverageSpeed() throws Exception {
    OnFoot onFoot = new OnFoot(-1.0);
  }

  @Test(expected = Exception.class)
  public void negativeOnFootInfiniteAverageSpeed() throws Exception {
    OnFoot onFoot = new OnFoot(Double.POSITIVE_INFINITY);
  }

  @Test(expected = Exception.class)
  public void negativeOnFootNanAverageSpeed() throws Exception {
    OnFoot onFoot = new OnFoot(Double.NaN);
  }
}