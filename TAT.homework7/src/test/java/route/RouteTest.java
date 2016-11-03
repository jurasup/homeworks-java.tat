package route;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


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

  @Before
  public void setUp() throws Exception {
    route = new Route();
    initialCheckpoint = new Checkpoint(0.0, 0.0);
    route.moveTo(initialCheckpoint);
  }

  @After
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

  @Test(expected = Exception.class)
  public void negativeMoveToNonexistentCheckpoint() throws Exception {
    nextCheckpoint = null;
    route.moveTo(nextCheckpoint);
  }
}