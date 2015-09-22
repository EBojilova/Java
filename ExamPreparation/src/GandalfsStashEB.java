import java.util.Scanner;

public class GandalfsStashEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int happiness = Integer.parseInt(input.nextLine());
        String[] foods = input.nextLine()
                              .trim()
                              .split("[^a-zA-Z]+");
        for (int i = 0; i < foods.length; i++) {
            happiness += getFoodValue(foods[i]);
        }
        System.out.println(happiness);
        System.out.println(getMood(happiness));
    }

    private static int getFoodValue(String card) {
        if (card.equalsIgnoreCase("Cram")) {
            return 2;
        }
        if (card.equalsIgnoreCase("Lembas")) {
            return 3;
        }
        if (card.equalsIgnoreCase("Apple")) {
            return 1;
        }
        if (card.equalsIgnoreCase("Melon")) {
            return 1;
        }
        if (card.equalsIgnoreCase("HoneyCake")) {
            return 5;
        }
        if (card.equalsIgnoreCase("Mushrooms")) {
            return -10;
        }
        return -1;
    }

    private static String getMood(int happiness) {
        if (happiness < -5) {
            return "Angry";
        }
        if (happiness >= -5 && happiness < 0) {
            return "Sad";
        }
        if (happiness >= -0 && happiness < 15) {
            return "Happy";
        }
        return "Special JavaScript mood";
    }
}
