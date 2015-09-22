package Products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import Enumerations.AgeRestriction;
import Interfaces.Expirable;

public class FoodProduct extends Product implements Expirable, Comparator<FoodProduct> {
	private final double EXPIRATION_PRICE_RATIO = 0.7;
	private Date creationDate;
	private Date expirationDate;

	public FoodProduct(String name, double price, int quantity,
			AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
		this.creationDate = new Date();
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(int days) {
		this.expirationDate = addDays(days);
	}

	@Override
	public double getPrice() {
		double price = super.getPrice();
		LocalDate localCurrentDate = LocalDate.now();
		LocalDate localExpirationDate = this.expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long daysToProductExpiration = ChronoUnit.DAYS.between(localCurrentDate, localExpirationDate);
		if (daysToProductExpiration < 15) {
			price *= EXPIRATION_PRICE_RATIO;
		}
		return price;
	}
	
	@Override
	public int compare(FoodProduct foodProduct1, FoodProduct foodProduct2) {
		if (foodProduct1.expirationDate.before(foodProduct2.expirationDate)) {
			return -1;
		} else if (foodProduct1.expirationDate.equals(foodProduct2.expirationDate)) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(super.toString());
		result.append(String.format("Date of product creation: %s\nDate of product expiration: %s\n",
				this.creationDate.toString(), this.expirationDate.toString()));
		return result.toString();
	}
	
	private Date addDays(int days) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.creationDate);
        calendar.add(Calendar.DATE, days);
                 
        return calendar.getTime();
    }

//	private Date formatDate() throws ParseException {
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(this.expirationDate.toString());
//		return date;
//	}

}
