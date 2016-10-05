/**
 * This class is used to represent triangle.
 * @author Yury Suponev
 */
public class Triangle {

  /**
   * The triangle sides length.
   */
  private double firstSideLength;
  private double secondSideLength;
  private double thirdSideLength;

  /**
   * Gets length of all sides.
   * @param firstSideLength
   * @param secondSideLength
   * @param thirdSideLength
   */
  public Triangle(double firstSideLength, double secondSideLength, double thirdSideLength) {
    this.firstSideLength = firstSideLength;
    this.secondSideLength = secondSideLength;
    this.thirdSideLength = thirdSideLength;
  }

  /**
   * Checking existing condition for certain side.
   * @param index No. of side
   * @return true if condition is satisfied; false if it is not satisfied.
   */
  private boolean checkOneSide(int index) {
    if (index == 1) {
      return (firstSideLength < (secondSideLength + thirdSideLength)) ? true : false;
    }
    if (index == 2) {
      return (secondSideLength < (firstSideLength + thirdSideLength)) ? true : false;
    }
    return (thirdSideLength < (secondSideLength + firstSideLength)) ? true : false;
  }

  /**
   * Checking existing condition for triangle.
   * @return the result of joint check.
   */
  private boolean ifExists() {
    return (checkOneSide(1) && checkOneSide(2) && checkOneSide(3));
  }

  /**
   * @return true if triangle is equilateral; false if it os not equilateral.
   */
  private boolean isEquilateral() {
    if (firstSideLength == secondSideLength && firstSideLength == thirdSideLength) {
      return true;
    }
    return false;
  }

  /**
   * @return true if triangle is isosceles; false if it is not isosceles.
   */
  private boolean isIsosceles() {
    if (firstSideLength == secondSideLength) {
      return true;
    }
    if (firstSideLength == thirdSideLength) {
      return true;
    }
    if (secondSideLength == thirdSideLength) {
      return true;
    }
    return false;
  }

  /**
   * Defines the triangle type.
   * @return a string describing the type.
   */
  private String type() {
    if (ifExists()) {
      if (isEquilateral()) {
        return "is equilateral.";
      }
      if (isIsosceles()) {
        return "is isosceles.";
      }
      return "is common.";
    }
    else {
      return "doesn't exist.";
    }
  }

  /**
   * The string representation is "This triangle + TYPE"
   * Where TYPE is triangle type.
   * @return string representation;
   */
  @Override
  public String toString() {
    return "This triangle " + type();
  }
}