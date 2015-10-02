package regex;

import java.util.Scanner;

public class WeirdStringsEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        inputString = inputString.replaceAll("[\\/\\|\\(\\)\\s]+", "");
        String[] words = inputString.split("[^a-zA-Z]+");

        int maxWeight = 0;
        int maxIndex=0;
        for (int i = 0; i < words.length - 1; i++) {
            String currentCouple = (words[i] + words[i + 1]).toLowerCase();
            int currentWeight = 0;
            for (int j = 0; j < currentCouple.length(); j++) {
                currentWeight += currentCouple.charAt(j) - ('a' - 1);
            }

            if (currentWeight >= maxWeight) {
                maxWeight = currentWeight;
                maxIndex=i;
            }
        }

        System.out.println(words[maxIndex]);
        System.out.println(words[maxIndex+1]);
    }

}
