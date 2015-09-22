package Products;

import Enumerations.AgeRestriction;


public class Appliance extends ElectonicsProduct {

	public Appliance(String name, double price, int quantity,
			AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
		this.guaranteePeriod = 6;
		this.priceRatio = 1.05;
		this.priceChangingQuantity = 50;
	}

	@Override
	public double getPrice() {
		double price = super.getPrice();
		int quantity = this.getQuantity();
		if (quantity < this.priceChangingQuantity) {
			price *= priceRatio;
		}
		return price;
	}

}
