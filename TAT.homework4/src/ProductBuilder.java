import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Provides creating of product
 * @author Yury Suponev
 */
public class ProductBuilder {
  public Product build(ArrayList<String> attributes) {
    return new Product(attributes.get(0), attributes.get(1),
                       new BigDecimal(attributes.get(2)), new BigDecimal(attributes.get(3)));
  }
}
