import java.util.*;

public class _06RandomHandsOfFiveCards {

    public static void main(String[] args) {
        Random rand = new Random();

        Scanner input = new Scanner(System.in);

        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};

        System.out.print("Number of hands: ");
        int numberOfHands = input.nextInt();
        if (numberOfHands > 10) {
            System.out.println("Number of hands can not exceed 10.");
            return;
        }
        SortedSet<String> allHands = new TreeSet<String>();
        HashSet<String> cardsUsed = new HashSet<>();

        while (allHands.size() < numberOfHands) {
            SortedSet<String> hand = new TreeSet<String>();

            while (hand.size() < 5) {
                String face = faces[rand.nextInt(13)];
                String suit = suits[rand.nextInt(4)];

                String card = String.format("%2s%s", face, suit);
                if (cardsUsed.contains(card)) {
                    continue;
                }
                hand.add(card);
                cardsUsed.add(card);
            }

            allHands.add(String.join(" ", hand));
        }

        System.out.println(String.join("\n", allHands));
        System.out.printf("%d hands", allHands.size());
    }
}
