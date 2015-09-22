package ExecutingPurchases;

import java.time.LocalDate;
import java.time.ZoneId;

import Customers.Customer;
import Enumerations.AgeRestriction;
import Messages.Messages;
import Products.FoodProduct;
import Products.Product;

public final class PurchaseManager {
	private PurchaseManager() {
	}

	public static void processPurchase(Customer customer, Product product) {
		if (product.getQuantity() <= 0) {
			throw new IllegalArgumentException(Messages.noProductQuantity);
		}
		
		if (product instanceof FoodProduct) {
			LocalDate expirationDate = ((FoodProduct) product)
					.getExpirationDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
			if (LocalDate.now().isAfter(expirationDate)) {
				throw new IllegalArgumentException(Messages.expiredProduct);
			}
		}
		
		if (product.getPrice() > customer.getBalance()) {
			throw new IllegalArgumentException(Messages.notEnoughMoney);
		}
		
		if ((product.getAgeRestriction() == AgeRestriction.TEENAGER && customer.getAge() < 14) || 
				(product.getAgeRestriction() == AgeRestriction.ADULT && customer.getAge() < 18)) {
			throw new IllegalArgumentException(Messages.notOldEnough);
		}
		
		product.reduceQuantity();
		customer.exetutePayment(product.getPrice());
	}
}
