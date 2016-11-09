import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test for Triangle.
 * @see Triangle
 */
public class TriangleTest {
  /**
   * Triangle types.
   */
  private final String EQUILATERAL = "equilateral";
  private final String ISOSCELES = "isosceles";
  private final String COMMON = "common";

  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider(name = "invalid triangles")
  public Object[][] invalidTriangles() throws Exception {
    return new Object[][] {
            {0.0, 0.0, 0.0},
            {0.0, 1.0, 1.0},
            {1.0, 0.0, 1.0},
            {1.0, 1.0, 0.0},
            {1.0, 1.0, 3.0},
            {1.0, 3.0, 1.0},
            {3.0, 1.0, 1.0},
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.POSITIVE_INFINITY, 1.0, 1.0},
            {1.0, Double.POSITIVE_INFINITY, 1.0},
            {1.0, 1.0, Double.POSITIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
            {Double.NEGATIVE_INFINITY, 1.0, 1.0},
            {1.0, Double.NEGATIVE_INFINITY, 1.0},
            {1.0, 1.0, Double.NEGATIVE_INFINITY},
            {Double.NaN, Double.NaN, Double.NaN},
            {Double.NaN, 1.0, 1.0},
            {1.0, Double.NaN, 1.0},
            {1.0, 1.0, Double.NaN},
            {-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE},
            {-Double.MAX_VALUE, 1.0, 1.0},
            {1.0, -Double.MAX_VALUE, 1.0},
            {1.0, 1.0, -Double.MAX_VALUE},
            {-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE},
            {-Double.MIN_VALUE, 1.0, 1.0},
            {1.0, -Double.MIN_VALUE, 1.0},
            {1.0, 1.0, -Double.MIN_VALUE},
            {-1.0, -1.0, -1.0},
            {-1.0, 1.0, 1.0},
            {1.0, -1.0, 1.0},
            {1.0, 1.0, -1.0}
    };
  }

  @DataProvider(name = "valid triangles with types")
  public Object[][] validTriangles() throws Exception {
    return new Object[][] {
            {new Triangle(1.0, 1.5, 2.0), COMMON},
            {new Triangle(2.0, 2.0, 1.0), ISOSCELES},
            {new Triangle(1.0, 1.0, 1.0), EQUILATERAL},
            {new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE), EQUILATERAL},
            {new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, 1.0), ISOSCELES},
            {new Triangle(Double.MAX_VALUE, 1.0, Double.MAX_VALUE), ISOSCELES},
            {new Triangle(1.0, Double.MAX_VALUE, Double.MAX_VALUE), ISOSCELES},
            {new Triangle(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE), EQUILATERAL},
            {new Triangle(Double.MIN_VALUE, 1.0, 1.0), ISOSCELES},
            {new Triangle(1.0, Double.MIN_VALUE, 1.0), ISOSCELES},
            {new Triangle(1.0, 1.0, Double.MIN_VALUE), ISOSCELES}
    };
  }

  @Test(dataProvider = "invalid triangles", expectedExceptions = Exception.class)
  public void negativeTriangleInvalidSides(double firstSide, double secondSide, double thirdSide) throws Exception {
    Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
  }

  @Test(dataProvider = "valid triangles with types")
  public void positiveType(Triangle triangle, String type) throws Exception {
    assertEquals(triangle.type(), type);
  }
}