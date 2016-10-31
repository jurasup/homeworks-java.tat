package route;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Test for CheckpointValidator.
 * String containing pair of coordinates must match following pattern:
 * two numbers separated by space (number can be integer or fractional separated by dot - ex: 1.0).
 * @see CheckpointValidator
 * @author Yury Suponev
 */
public class CheckpointValidatorTest {
  CheckpointValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new CheckpointValidator();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void positiveValidateIntegerCoordinates() throws Exception {
    String coordinates = "1 1";
    assertTrue(validator.validate(coordinates));
  }

  @Test
  public void positiveValidateFractionalCoordinates() throws Exception {
    String coordinates = "1.0 1.0";
    assertTrue(validator.validate(coordinates));
  }

  @Test
  public void positiveValidateNegativeCoordinates() throws Exception {
    String coordinates = "-1.0 -1.0";
    assertTrue(validator.validate(coordinates));
  }

  @Test
  public void positiveValidatePlusSymbolCoordinates() throws Exception {
    String coordinates = "+1.0 +1.0";
    assertTrue(validator.validate(coordinates));
  }

  @Test
  public void positiveValidateZeroCoordinates() throws Exception {
    String coordinates = "0.0 0.0";
    assertTrue(validator.validate(coordinates));
  }

  @Test(expected = Exception.class)
  public void negativeValidateEmptyCoordinates() throws Exception {
    String coordinates = "";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateOneCoordinate() throws Exception {
    String coordinates = "1.0";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateTwoInvalidCoordinates() throws Exception {
    String coordinates = "a a";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateFirstInvalidCoordinate() throws Exception {
    String coordinates = "a 1.0";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateSecondInvalidCoordinate() throws Exception {
    String coordinates = "1.0 a";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateCommaSeparatedCoordinates() throws Exception {
    String coordinates = "1,0 1,0";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateCoordinatesSeparatedByInvalidSymbol() throws Exception {
    String coordinates = "1.0:1.0";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateExponentialFormCoordinates() throws Exception {
    String coordinates = "1e2 1e2";
    validator.validate(coordinates);
  }

  @Test(expected = Exception.class)
  public void negativeValidateMoreThanOneSpaceSeparatedCoordinates() throws Exception {
    String coordinates = "1.0    1.0";
    validator.validate(coordinates);
  }
}