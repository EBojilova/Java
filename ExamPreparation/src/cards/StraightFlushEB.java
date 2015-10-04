package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class StraightFlushEB {

    public static ArrayList<String> straightFlush = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputCards = sc.nextLine()
                                .split("\\W+");

        HashSet<String> existingCards = new HashSet<>();
        existingCards.addAll(Arrays.asList(inputCards));

        int count = 0;
        for (String card : inputCards) {
            String cardFace = card.substring(0, card.length() - 1);
            String cardSuit = card.substring(card.length() - 1);
            findStraightFlush(cardFace, cardSuit);

            if (existingCards.containsAll(straightFlush) && straightFlush.size() == 5) {
                System.out.println(straightFlush);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No Straight Flushes");
        }
    }

    public static void findStraightFlush(String cardFace, String cardSuit) {
        straightFlush = new ArrayList<>();
        ArrayList<String> cardFaces = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
        int startIndex = cardFaces.indexOf(cardFace);
        int endIndex = startIndex + 5 - 1;
        if (endIndex < cardFaces.size()) {
            for (int i = 0; i < 5; i++) {
                straightFlush.add(cardFaces.get(startIndex + i) + cardSuit);
            }
        }
    }
}
