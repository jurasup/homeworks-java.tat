package route;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Tests for Route class.
 * @see Route
 * @author Yury Suponev
 */
public class RouteTest {
  private Route route;
  private Checkpoint initialCheckpoint;
  private Checkpoint nextCheckpoint;
  private static final double DELTA = 1e-10;

  @BeforeMethod
  public void setUp() throws Exception {
    route = new Route();
    initialCheckpoint = new Checkpoint(0.0, 0.0);
    route.moveTo(initialCheckpoint);
  }

  @AfterMethod
  public void tearDown() throws Exception {
  }

  @Test
  public void positiveMoveToIncreaseDistance() throws Exception {
    nextCheckpoint = new Checkpoint(3.0, 4.0);
    route.moveTo(nextCheckpoint);
    assertEquals(5.0, route.getDistance(), DELTA);
  }

  @Test
  public void negativeMoveToUnalteredDistance() throws Exception {
    nextCheckpoint = initialCheckpoint;
    route.moveTo(nextCheckpoint);
    assertEquals(0.0, route.getDistance(), DELTA);
  }

  @Test(expectedExceptions = Exception.class)
  public void negativeMoveToNonexistentCheckpoint() throws Exception {
    nextCheckpoint = null;
    route.moveTo(nextCheckpoint);
  }
}