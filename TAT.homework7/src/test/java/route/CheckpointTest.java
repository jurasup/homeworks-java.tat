package route;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test for Checkpoint.
 * @see Checkpoint
 * @author Yury Suponev
 */
public class CheckpointTest {

  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider(name = "invalidCoordinates")
  public Object[][] InvalidCoordinates() {
    return new Object[][] {
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.POSITIVE_INFINITY, 1.0},
            {1.0, Double.POSITIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, 1.0},
            {1.0, Double.NEGATIVE_INFINITY},
            {Double.NaN, Double.NaN},
            {Double.NaN, 1.0},
            {1.0, Double.NaN},
            {null, null},
            {null, 1.0},
            {1.0, null}
    };
  }

  @DataProvider(name = "notEqualCheckpoints")
  public Object[][] notEqualCheckpoints() throws Exception {
    return new Object[][] {
            {new Checkpoint(1.0, 1.0), new Checkpoint(-1.0, -1.0)},
            {new Checkpoint(1.0, 1.0), new Checkpoint(1.0, -1.0)},
            {new Checkpoint(1.0, 1.0), new Checkpoint(-1.0, 1.0)},
            {new Checkpoint(1.0, 1.0), new Checkpoint(1.01, 1.01)},
            {new Checkpoint(1.0, 1.0), new Checkpoint(1.01, 1.0)},
            {new Checkpoint(1.0, 1.0), new Checkpoint(1.0, 1.01)},
            {new Checkpoint(0.0, 0.0), new Checkpoint(Double.MIN_VALUE, 0.0)},
            {new Checkpoint(0.0, 0.0), new Checkpoint(0.0, Double.MIN_VALUE)},
            {new Checkpoint(0.0, 0.0), new Checkpoint(Double.MIN_VALUE, Double.MIN_VALUE)}
    };
  }

  @DataProvider(name = "equalCheckpoints")
  public Object[][] equalCheckpoints() throws Exception {
    return new Object[][] {
            {new Checkpoint(1.0, 1.0), new Checkpoint(1.0, 1.0)},
            {new Checkpoint(Double.MIN_VALUE, Double.MIN_VALUE), new Checkpoint(Double.MIN_VALUE, Double.MIN_VALUE)},
            {new Checkpoint(Double.MAX_VALUE, Double.MAX_VALUE), new Checkpoint(Double.MAX_VALUE, Double.MAX_VALUE)}
    };
  }

  @Test(dataProvider = "invalidCoordinates", expectedExceptions = Exception.class)
  public void negativeCheckpointInvalidCoordinates(Double firstCoordinate, Double secondCoordinate) throws Exception {
    Checkpoint checkpoint = new Checkpoint(firstCoordinate, secondCoordinate);
  }

  @Test(dataProvider = "notEqualCheckpoints")
  public void negativeEquals(Checkpoint firstPoint, Checkpoint secondPoint) throws Exception {
    assertTrue(!firstPoint.equals(secondPoint));
  }

  @Test(dataProvider = "equalCheckpoints")
  public void positiveEquals(Checkpoint firstPoint, Checkpoint secondPoint) throws Exception {
    assertTrue(firstPoint.equals(secondPoint));
  }
}