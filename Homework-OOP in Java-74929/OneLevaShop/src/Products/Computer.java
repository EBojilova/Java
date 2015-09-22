package Products;

import Enumerations.AgeRestriction;

public class Computer extends ElectonicsProduct {

	public Computer(String name, double price, int quantity,
			AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
		this.guaranteePeriod = 24;
		this.priceRatio = 0.95;
		this.priceChangingQuantity = 1000;
	}

	@Override
	public double getPrice() {
		double price = this.getPrice();
		int quantity = this.getQuantity();
		if (quantity > this.priceChangingQuantity) {
			price *= priceRatio;
		}
		return price;
	}

}
