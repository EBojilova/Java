import java.util.ArrayList;
import java.util.Objects;

public class _04FullHouseWithJockersRecursion {

    static int countFullHouses = 0;

    static String format= "%2s%s";

    static String jockerString = String.format("%4s", "*");

    public static void main(String[] args) {
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String face : faces) {
            for (String faceSecond : faces) {
                if (!Objects.equals(face, faceSecond)) {
                    for (int suit1 = 0; suit1 < suits.length - 2; suit1++) {
                        for (int suit2 = suit1 + 1; suit2 < suits.length - 1; suit2++) {
                            for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
                                for (int suitSecond1 = 0; suitSecond1 < suits.length - 1; suitSecond1++) {
                                    for (int suitSecond2 = suitSecond1 + 1; suitSecond2 < suits.length; suitSecond2++) {
                                        String firstCard = String.format(format, face, suits[suit1]);
                                        String secondCard = String.format(format, face, suits[suit2]);
                                        String thirdCard = String.format(format, face, suits[suit3]);
                                        String fourthCard = String.format(format, faceSecond, suits[suitSecond1]);
                                        String fifthCard = String.format(format, faceSecond, suits[suitSecond2]);
                                        String[] hand = {firstCard, secondCard, thirdCard, fourthCard, fifthCard};

                                        ArrayList<String> temporary = new ArrayList<>();
                                        findCombinations(0, hand, temporary);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(countFullHouses);
    }

    private static void findCombinations(int index, String[] hand, ArrayList<String> temporary) {

        printFullHouseHand(temporary);
        countFullHouses++;

        for (int i = index; i < 5; i++) {
            temporary.add(hand[i]);
            findCombinations(i + 1, hand, temporary); // call recursively
            temporary.remove(temporary.size() - 1);
        }
    }

    private static void printFullHouseHand(ArrayList<String> temporary) {
        System.out.print(String.join(" ", temporary));
        int jockers = 5 - temporary.size();
        for (int jocker = 0; jocker < jockers; jocker++) {
            System.out.print(jockerString);
        }
        System.out.println();
    }
}
