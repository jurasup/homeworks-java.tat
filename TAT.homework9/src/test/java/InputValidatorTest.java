import exception.NumberException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test for InputValidator.
 * @see InputValidator
 * @author Yury Suponev
 */
public class InputValidatorTest {
  private final String invalidInputTag = "invalid_input";
  private final String input = "input_string";
  private InputValidator validator = new InputValidator();

  @DataProvider(name = "invalid input")
  public Object[][] invalidInputString() throws Exception {
    ValueReader reader = ValueReader.getReader();
    String[] attributes = {input};
    return reader.getNodeValuesByTagWithAttributes(invalidInputTag, attributes);
  }

  @Test(dataProvider = "invalid input", expectedExceptions = Exception.class)
  public void negativeValidateInvalidInputString(String input) throws NumberFormatException, NumberException {
    validator.validate(input);
  }
}