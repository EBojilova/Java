package Products;

import Enumerations.AgeRestriction;

public abstract class ElectonicsProduct extends Product {
	protected int guaranteePeriod;
	protected double priceRatio;
	protected int priceChangingQuantity;

	public ElectonicsProduct(String name, double price, int quantity,
			AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
	}
	
	public int getGuaranteePeriod() {
		return guaranteePeriod;
	}

	public double getPriceRatio() {
		return priceRatio;
	}

	public int getPriceChangingQuantity() {
		return priceChangingQuantity;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(super.toString());
		result.append(String.format("Guarantee period: %d months\n",
				this.guaranteePeriod));
		return result.toString();
	}

}
