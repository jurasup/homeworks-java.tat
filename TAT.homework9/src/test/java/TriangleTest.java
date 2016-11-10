import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test for Triangle.
 * @see Triangle
 */
public class TriangleTest {
  private final String MAX_VALUE = "MAX_VALUE";
  private final String MIN_VALUE = "MIN_VALUE";
  /**
   * Tags & attributes.
   */
  private final String invalidTriangleTag = "invalid_triangle";
  private final String validTriangleTag = "valid_triangle";
  private final String firstSide = "first_side";
  private final String secondSide = "second_side";
  private final String thirdSide = "third_side";
  private final String type = "type";
  /**
   * Triangle types.
   */
  private final String EQUILATERAL = "equilateral";
  private final String ISOSCELES = "isosceles";
  private final String COMMON = "common";

  /**
   * Provides parsing input string attribute to double number.
   * @param number input string attribute
   * @return double number
   */
  private double getDoubleValue(String number) {
    switch (number) {
      case MAX_VALUE:
        return Double.MAX_VALUE;
      case "-" + MAX_VALUE:
        return -Double.MAX_VALUE;
      case MIN_VALUE:
        return Double.MIN_VALUE;
      case "-" + MIN_VALUE:
        return -Double.MIN_VALUE;
      default:
        return Double.parseDouble(number);
    }
  }

  /**
   * Allows to get expected type of triangle.
   * @param expectedType
   * @return type
   */
  private String getExpectedType(String expectedType) {
    if (expectedType.equals(COMMON)) {
      return COMMON;
    } else if (expectedType.equals(ISOSCELES)) {
      return ISOSCELES;
    } else {
      return EQUILATERAL;
    }
  }

  @DataProvider(name = "invalid triangles")
  public Object[][] invalidTriangles() throws Exception {
    ValueReader reader = ValueReader.getReader();
    String[] attributes = {firstSide, secondSide, thirdSide};
    String[][] values = reader.getNodeValuesByTagWithAttributes(invalidTriangleTag, attributes);
    Object[][] result = new Double[values.length][];
    for (int i = 0; i < values.length; i++) {
      result[i] = new Double[values[0].length];
      for (int j = 0; j < values[0].length; j++) {
        result[i][j] = getDoubleValue(values[i][j]);
      }
    }
    return result;
  }

  @DataProvider(name = "valid triangles with types")
  public Object[][] validTriangles() throws Exception {
    ValueReader reader = ValueReader.getReader();
    String[] attributes = {firstSide, secondSide, thirdSide, type};
    String[][] values = reader.getNodeValuesByTagWithAttributes(validTriangleTag, attributes);
    Object[][] result = new Object[values.length][];
    for (int i = 0; i < values.length; i++) {
      result[i] = new Object[values[0].length];
      for (int j = 0; j < values[0].length - 1; j++) {
        result[i][j] = getDoubleValue(values[i][j]);
      }
      result[i][values[0].length - 1] = getExpectedType(values[i][values[0].length - 1]);
    }
    return result;
  }

  @Test(dataProvider = "invalid triangles", expectedExceptions = Exception.class)
  public void negativeTriangleInvalidSides(double firstSide, double secondSide, double thirdSide) throws Exception {
    Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
  }

  @Test(dataProvider = "valid triangles with types")
  public void positiveType(double firstSide, double secondSide, double thirdSide, String type) throws Exception {
    Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
    assertEquals(triangle.type(), type);
  }
}