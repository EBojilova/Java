import java.util.Objects;

public class _03FullHouse {

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

                                        String fullHouse = String.format("(%2s%s %2s%s %2s%s %2s%s %2s%s)",
                                                face, suits[suit1],
                                                face, suits[suit2],
                                                face, suits[suit3],
                                                faceSecond, suits[suitSecond1],
                                                faceSecond, suits[suitSecond2]);
                                        System.out.println(fullHouse);
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
