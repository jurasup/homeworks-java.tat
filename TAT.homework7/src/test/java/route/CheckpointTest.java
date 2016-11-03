package route;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for Checkpoint.
 * @see Checkpoint
 * @author Yury Suponev
 */
public class CheckpointTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void positiveEqualsEqualCheckpoints() throws Exception {
    Checkpoint firstPoint = new Checkpoint(1.0, 1.0);
    Checkpoint secondPoint = new Checkpoint(1.0, 1.0);
    assertTrue(firstPoint.equals(secondPoint));
  }

  @Test
  public void negativeEqualsDifferentCheckpoints() throws Exception {
    Checkpoint firstPoint = new Checkpoint(1.0, 1.0);
    Checkpoint secondPoint = new Checkpoint(1.0, 5.0);
    assertTrue(!firstPoint.equals(secondPoint));
  }

  @Test(expected = Exception.class)
  public void negativeEqualsPositiveInfiniteCheckpoints() throws Exception {
    Checkpoint firstPoint = new Checkpoint(1.0, Double.POSITIVE_INFINITY);
    Checkpoint secondPoint = new Checkpoint(1.0, Double.POSITIVE_INFINITY);
    firstPoint.equals(secondPoint);
  }

  @Test(expected = Exception.class)
  public void negativeEqualsNegativeInfiniteCheckpoints() throws Exception {
    Checkpoint firstPoint = new Checkpoint(1.0, Double.NEGATIVE_INFINITY);
    Checkpoint secondPoint = new Checkpoint(1.0, Double.NEGATIVE_INFINITY);
    firstPoint.equals(secondPoint);
  }

  @Test(expected = Exception.class)
  public void negativeEqualsNanCheckpoints() throws Exception {
    Checkpoint firstPoint = new Checkpoint(1.0, Double.NaN);
    Checkpoint secondPoint = new Checkpoint(1.0, Double.NaN);
    firstPoint.equals(secondPoint);
  }
}