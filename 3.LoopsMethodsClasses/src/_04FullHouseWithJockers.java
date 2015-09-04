import java.util.Objects;

class _04FullHouseWithJockers {

    public static void main(String[] args) {
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int countFullHouses = 0;

        for (String face : faces) {
            for (String faceSecond : faces) {
                if (!Objects.equals(face, faceSecond)) {
                    for (int suit1 = 0; suit1 < suits.length - 2; suit1++) {
                        for (int suit2 = suit1 + 1; suit2 < suits.length - 1; suit2++) {
                            for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
                                for (int suitSecond1 = 0; suitSecond1 < suits.length - 1; suitSecond1++) {
                                    for (int suitSecond2 = suitSecond1 + 1; suitSecond2 < suits.length; suitSecond2++) {
                                        String firstCard = String.format("%2s%s", face, suits[suit1]);
                                        String secondCard = String.format("%2s%s", face, suits[suit2]);
                                        String thirdCard = String.format("%2s%s", face, suits[suit3]);
                                        String fourthCard = String.format("%2s%s", faceSecond, suits[suitSecond1]);
                                        String fifthCard = String.format("%2s%s", faceSecond, suits[suitSecond2]);
                                        String[] hand = {firstCard, secondCard, thirdCard, fourthCard, fifthCard};

                                        // all possible cobpibations: 2^5 =32
                                        int combinatins = (int) Math.pow(2, 5);
                                        for (int combination = 0; combination < combinatins; combination++) {
                                            String[] temporary = {" * ", " * ", " * ", " * ", " * "};
                                            FindCombination(hand, combination, temporary);
                                            System.out.println(String.join(" ", temporary));
                                            countFullHouses++;
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
    }

    private static void FindCombination(String[] hand, int combination, String[] temporary) {
        for (int jocker = 0; jocker < 5; jocker++) {
            int jockerPositon = 1 << jocker;
            if (jockerPositon > combination) {
                continue;
            }
            int mask = combination & jockerPositon;
//                                                String binaryJockerPositon = String.format("%12s", Integer.toBinaryString(jockerPositon)).replace(" ", "0");
//                                                String combinationBinary = String.format("%12s", Integer.toBinaryString(combination)).replace(" ", "0");
//                                                String maskBinary = String.format("%12s", Integer.toBinaryString(mask)).replace(" ", "0");
            if (mask != 0) {
                temporary[jocker] = hand[jocker];
            }
        }
    }
}
