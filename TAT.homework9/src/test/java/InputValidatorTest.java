import exception.NumberException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test for InputValidator.
 * @see InputValidator
 * @author Yury Suponev
 */
public class InputValidatorTest {
  private InputValidator validator = new InputValidator();

  @BeforeMethod
  public void setUp() throws Exception {

  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @DataProvider(name = "invalid input string")
  public Object[][] invalidInputString() throws Exception {
    return new Object[][]{
            {"1,0"},
            {"a"},
            {"1.0 1.0"},
            {"1.0 a"}
    };
  }

  @DataProvider(name = "invalid number")
  public Object[][] invalidInputStringIncorrectNumbers() throws Exception {
    return new Object[][]{
            {"-1.0"},
            {"Infinity"},
            {"NaN"}
    };
  }

  @Test(dataProvider = "invalid input string", expectedExceptions = NumberFormatException.class)
  public void negativeValidateInvalidInputString(String input) throws NumberException, NumberFormatException {
    validator.validate(input);
  }

  @Test(dataProvider = "invalid number", expectedExceptions = NumberException.class)
  public void negativeValidateInvalidNumbers(String input) throws NumberFormatException, NumberException {
    validator.validate(input);
  }
}