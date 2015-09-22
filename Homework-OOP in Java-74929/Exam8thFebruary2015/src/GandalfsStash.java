import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class GandalfsStash {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int gandalfsHappinessPoints = Integer.parseInt(input.nextLine());
		String gandalfsFood = input.nextLine().toLowerCase();
		String[] gandalfsFoods = gandalfsFood.split("[^a-z]+");
		
		List<String> gandalfsMoods = new ArrayList<String>(Arrays
				.asList("Angry", "Sad", "Happy", "Special JavaScript mood"));
		
		Map<String, Integer> gandalfsFavouriteFoods = new HashMap<String, Integer>();
		gandalfsFavouriteFoods.put("cram", 2);
		gandalfsFavouriteFoods.put("lembas", 3);
		gandalfsFavouriteFoods.put("apple", 1);
		gandalfsFavouriteFoods.put("melon", 1);
		gandalfsFavouriteFoods.put("honeycake", 5);
		gandalfsFavouriteFoods.put("mushrooms", -10);
		
		
		gandalfsHappinessPoints = calculateGandalfsHappinessPoints(
				gandalfsFavouriteFoods, gandalfsHappinessPoints, gandalfsFoods);
		
		printGandalfsMood(gandalfsMoods, gandalfsHappinessPoints);
		
		input.close();
	}

	private static int calculateGandalfsHappinessPoints(
			Map<String, Integer> gandalfsFavouriteFoods,
			int gandalfsHappinessPoints, String[] gandalfsFoods) {
		for (String food : gandalfsFoods) {
			if (gandalfsFavouriteFoods.containsKey(food)) {
				gandalfsHappinessPoints += gandalfsFavouriteFoods.get(food);
			} else {
				gandalfsHappinessPoints--;
			}
		}
		return gandalfsHappinessPoints;
	}

	private static void printGandalfsMood(List<String> gandalfsMoods,
			int gandalfsMood) {
		System.out.println(gandalfsMood);
		if (gandalfsMood < -5) {
			System.out.println(gandalfsMoods.get(0));
		} else if (gandalfsMood >= -5 && gandalfsMood < 0) {
			System.out.println(gandalfsMoods.get(1));
		} else if (gandalfsMood >= 0 && gandalfsMood < 15) {
			System.out.println(gandalfsMoods.get(2));
		} else {
			System.out.println(gandalfsMoods.get(3));
		}
	}
	
}
