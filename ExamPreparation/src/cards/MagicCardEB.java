package cards;

import java.util.Scanner;

public class MagicCardEB {

    public static void main(String[] args) {
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
            handValue += getCardValue(cardFace) * multiplier;
        }
        System.out.println(handValue);
    }

    private static String extractSuite(String card) {
        return card.substring(card.length() - 1);
    }

    private static String extractFace(String card) {
        return card.substring(0, card.length() - 1);
    }

    private static int getCardValue(String card) {
        switch (card) {
            case "2":
                return 20;
            case "3":
                return 30;
            case "4":
                return 40;
            case "5":
                return 50;
            case "6":
                return 60;
            case "7":
                return 70;
            case "8":
                return 80;
            case "9":
                return 90;
            case "10":
                return 100;
            case "J":
                return 120;
            case "Q":
                return 130;
            case "K":
                return 140;
            case "A":
                return 150;
            default:
                throw new IllegalArgumentException("Invalid card: " + card);
        }
    }
}
