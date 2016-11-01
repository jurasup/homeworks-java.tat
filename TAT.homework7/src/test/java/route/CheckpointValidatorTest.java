package route;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test for CheckpointValidator.
 * String containing pair of coordinates must match following pattern:
 * two numbers separated by space (number can be integer or fractional separated by dot - ex: 1.0).
 * @see CheckpointValidator
 * @author Yury Suponev
 */
public class CheckpointValidatorTest {
  CheckpointValidator validator;

  @BeforeMethod
  public void setUp() throws Exception {
    validator = new CheckpointValidator();
  }

  @AfterMethod
  public void tearDown() throws Exception {
  }

  @DataProvider
  public Object[][] invalidCoordinates() {
    return new Object[][] {
            {""},
            {"1.0"},
            {"a a"},
            {"1 a"},
            {"a 1"},
            {"1,0 1,0"},
            {"1.0:1.0"},
            {"1.0    1.0"},
            {"1e10 1e10"},
            {"1.0 1.0 1.0"},
            {"NaN NaN"},
            {"NaN 1.0"},
            {"1.0 NaN"},
    };
  }

  @DataProvider
  public Object[][] validCoordinates() {
    return new Object[][] {
            {"1 1"},
            {"1.0 1.0"},
            {"-1.0 -1.0"},
            {"+1.0 +1.0"},
            {"0.0 0.0"}
    };
  }

  @Test(dataProvider = "invalidCoordinates", expectedExceptions = Exception.class)
  public void negativeValidateCoordinates(String coordinates) throws Exception {
    validator.validate(coordinates);
  }

  @Test(dataProvider = "validCoordinates")
  public void positiveValidateCoordinates(String coordinates) throws Exception {
    assertTrue(validator.validate(coordinates));
  }
}