package ExecutingPurchases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Customers.Customer;
import Enumerations.AgeRestriction;
import Products.Appliance;
import Products.Computer;
import Products.FoodProduct;
import Products.Product;

public class PurchasesExecution {

	public static void main(String[] args) {
		try {
			Product whiteCheese = new FoodProduct("Бор Чвор", 2.50, 10, AgeRestriction.NONE);
			FoodProduct whiteCheeseFoodProduct = (FoodProduct) whiteCheese;
			whiteCheeseFoodProduct.setExpirationDate(30);
			
			Product yougurt = new FoodProduct("Ханско", 1.50, 20, AgeRestriction.NONE);
			FoodProduct yogurtFoodProduct = (FoodProduct) yougurt;
			yogurtFoodProduct.setExpirationDate(20);
			
			Product beer = new FoodProduct("Шуменско", 1.30, 14, AgeRestriction.ADULT);
			FoodProduct beerFoodProduct = (FoodProduct) beer;
			beerFoodProduct.setExpirationDate(14);
			
			Product energyDrink = new FoodProduct("Пит Бул", 1.90, 15, AgeRestriction.TEENAGER);
			FoodProduct energyDrinkFoodProduct = (FoodProduct) energyDrink;
			energyDrinkFoodProduct.setExpirationDate(35);
			
			Product laptop = new Computer("Asus", 1400, 10, AgeRestriction.NONE);

			Product tablet = new Computer("Xmart", 109, 10, AgeRestriction.NONE);
			
			Product serverAppliance = new Appliance("Cobalt Qube 3", 250, 30, AgeRestriction.ADULT);
			
			Product digitalVideoRecorder = new Appliance("Foxtel iQ", 300, 10, AgeRestriction.ADULT);
			
			List<Product> products = new ArrayList<Product>(Arrays.asList(
					whiteCheese, yougurt, beer, energyDrink, laptop, tablet, serverAppliance, digitalVideoRecorder));
			
			// printing the collection of products on the console
			products.forEach(p -> System.out.println(p));
			
			// getting the name of the first product with the soonest date of expiration
			System.out.println(
					products.stream()
					.filter(p -> p instanceof FoodProduct)
					.map(p -> (FoodProduct) p)
					.sorted()
					.findFirst()
					);
			
			// getting all products with adult age restriction and sorting them by price in ascending order
			products.stream()
				.filter(p -> p.getAgeRestriction() == AgeRestriction.ADULT)
				.sorted()
				.forEach(p -> System.out.println(p));
			
			// processing the sample input from the task's condition
			FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 1400, AgeRestriction.ADULT);
			cigars.setExpirationDate(830);
			Customer pecata = new Customer("Pecata", 17, 30.00);
			PurchaseManager.processPurchase(pecata, cigars);
			Customer gopeto = new Customer("Gopeto", 18, 0.44);
			PurchaseManager.processPurchase(gopeto, cigars);

		} catch (IllegalArgumentException illArgEx) {
			illArgEx.printStackTrace();
		}
	}
}
