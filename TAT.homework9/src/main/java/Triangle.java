import java.math.BigDecimal;

/**
 * This class is used to represent triangle.
 * @author Yury Suponev
 */
public class Triangle {
  private final String INVALID_SIDE_LENGTH = "Error: invalid side length!";
  private final String INVALID_TRIANGLE = "Error: such triangle doesn't exist!";
  private final String EQUILATERAL = "equilateral";
  private final String ISOSCELES = "isosceles";
  private final String COMMON = "common";

  /**
   * The triangle sides length.
   */
  private BigDecimal firstSide;
  private BigDecimal secondSide;
  private BigDecimal thirdSide;

  /**
   * Gets length of all sides.
   * @param firstSideLength
   * @param secondSideLength
   * @param thirdSideLength
   */
  public Triangle(double firstSideLength, double secondSideLength, double thirdSideLength) throws Exception {
    validateSideLength(firstSideLength);
    validateSideLength(secondSideLength);
    validateSideLength(thirdSideLength);
    this.firstSide = BigDecimal.valueOf(firstSideLength);
    this.secondSide = BigDecimal.valueOf(secondSideLength);
    this.thirdSide = BigDecimal.valueOf(thirdSideLength);
    checkIfExists();
  }

  /**
   * Validates length of the input triangle side.
   * @param sideLength length of the side
   * @throws Exception if side is invalid
   */
  private void validateSideLength(double sideLength) throws Exception {
    if (sideLength <= 0.0 || Double.isInfinite(sideLength) || Double.isNaN(sideLength)) {
      throw new Exception(INVALID_SIDE_LENGTH);
    }
  }

  /**
   * Checks existing condition for triangle.
   * @throws Exception if condition isn't satisfied
   */
  private void checkIfExists() throws Exception {
    if (firstSide.compareTo(secondSide.add(thirdSide)) >= 0) {
      throw new Exception(INVALID_TRIANGLE);
    }
    if (secondSide.compareTo(firstSide.add(thirdSide)) >= 0) {
      throw new Exception(INVALID_TRIANGLE);
    }
    if (thirdSide.compareTo(firstSide.add(secondSide)) >= 0) {
      throw new Exception(INVALID_TRIANGLE);
    }
  }

  /**
   * @return true if triangle is equilateral; false if it os not equilateral.
   */
  private boolean isEquilateral() {
    if (firstSide.compareTo(secondSide) == 0 && firstSide.compareTo(thirdSide) == 0) {
      return true;
    }
    return false;
  }

  /**
   * @return true if triangle is isosceles; false if it is not isosceles.
   */
  private boolean isIsosceles() {
    if (firstSide.compareTo(secondSide) == 0 || firstSide.compareTo(thirdSide) == 0 ||
            secondSide.compareTo(thirdSide) == 0) {
      return true;
    }
    return false;
  }

  /**
   * Defines the triangle type.
   * @return a string describing the type.
   */
  public String type() {
    if (isEquilateral()) {
      return EQUILATERAL;
    } else if (isIsosceles()) {
      return ISOSCELES;
    } else {
      return COMMON;
    }
  }
}