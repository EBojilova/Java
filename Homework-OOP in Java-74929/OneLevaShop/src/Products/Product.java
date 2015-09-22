package Products;

import Enumerations.AgeRestriction;
import Interfaces.Buyable;
import Messages.Messages;

public abstract class Product implements Buyable, Comparable<Product> {
	
	private String name;
	private double price;
	private int quantity;
	private AgeRestriction ageRestriction;

	public Product(String name, double price, int quantity,
			AgeRestriction ageRestriction) {
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setAgeRestriction(ageRestriction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException(Messages.invalidProductName);
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException(Messages.invalidProductPrice);
		}
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(Messages.invalidProductQuantity);
		}
		this.quantity = quantity;
	}

	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public void reduceQuantity() {
		if (this.quantity == 0) {
			throw new IllegalArgumentException(Messages.noProductQuantity);
		}
		this.quantity -= 1;
	}
	
	@Override
	public int compareTo(Product product) {
		if (this.price < product.getPrice()) {
			return -1;
		} else if (this.price == product.getPrice()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String
				.format("Product name: %s\nProduct price: %.2f\nProduct quantity: %d\nAge restriction: %s\n",
						this.name, this.price, this.quantity,
						this.ageRestriction));
		return result.toString();
	}

}
