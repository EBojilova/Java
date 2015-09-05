import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class _06RandomHandsOfFiveCards {

    public static void main(String[] args) {
        Random rand = new Random();

        Scanner input = new Scanner(System.in);

        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};

        System.out.print("Number of hands: ");
        int numberOfHands = input.nextInt();
        if (numberOfHands>10){
            System.out.println("Number of hands can not exceed 10.");
            return;
        }
        HashSet<String> allHands = new HashSet<String>();

        while (allHands.size() < numberOfHands) {
            HashSet<String> hand = new HashSet<String>();

            while (hand.size() < 5) {
                String face = faces[rand.nextInt(13)];
                String suit = suits[rand.nextInt(4)];

                hand.add(String.format("%2s%s", face, suit));
            }

            allHands.add(String.join(" ", hand));
        }

        System.out.println(String.join("\n", allHands));
        System.out.printf("%d hands", allHands.size());
    }
}
