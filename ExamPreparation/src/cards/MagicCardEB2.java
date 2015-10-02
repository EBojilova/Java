package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MagicCardEB2 {

    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>(Arrays.asList("*", "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "*", "J", "Q", "K", "A"));
        Scanner scanner = new Scanner(System.in);
        String cardsInput = scanner.nextLine()
                                   .trim();
        String[] cards = cardsInput.split("[\\W]+");

        String oddEven = scanner.nextLine();
        String magicCard = scanner.nextLine();
        String magicCardFase = extractFace(magicCard);
        String magicCardSuite = extractSuite(magicCard);
        int startIndex = oddEven.equalsIgnoreCase("odd") ? 1 : 0;
        int handValue = 0;
        for (int i = startIndex; i < cards.length; i += 2) {
            String cardFace = extractFace(cards[i]);
            String cardSuite = extractSuite(cards[i]);
            int multiplier = 1;
            if (cardFace.equals(magicCardFase)) {
                multiplier = 3;
            }
            else if (cardSuite.equals(magicCardSuite)) {
                multiplier = 2;
            }
            handValue += values.indexOf(cardFace) * 10 * multiplier;
        }
        System.out.println(handValue);
    }

    private static String extractSuite(String card) {
        return card.substring(card.length() - 1);
    }

    private static String extractFace(String card) {
        return card.substring(0, card.length() - 1);
    }
}
