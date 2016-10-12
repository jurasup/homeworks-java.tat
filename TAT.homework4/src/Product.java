import java.math.BigDecimal;

/**
 * Represents a product
 * @author Yury Suponev
 */
public class Product {

  private String type;
  private String name;
  private BigDecimal amount;
  private BigDecimal price;

  /**
   * Creates a product with defined attributes
   * @param type
   * @param name
   * @param amount
   * @param price
   */
  public Product(String type, String name, BigDecimal amount, BigDecimal price) {
    this.type = type;
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

  /**
   * Getters and Setters
   */
  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
