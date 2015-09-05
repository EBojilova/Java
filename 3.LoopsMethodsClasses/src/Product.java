import java.math.BigDecimal;

public class Product implements Comparable<Product> {

    private String name;

    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.getPrice().compareTo(otherProduct.getPrice());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", this.price, this.name);
    }
}
