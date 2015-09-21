import java.util.Scanner;

public class SumCardsEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputFces = input.nextLine().trim().split("[\\WSHDC]+");

        int sumCards = 0;
        for (int i = 0; i < inputFces.length; i++) {
            int count = 1;
            while ((i + 1 < inputFces.length) && (inputFces[i + 1].equals(inputFces[i]))) {
                count++;
                i++;
            }

            int faceValue = getCardValue(inputFces[i]);
            if (count == 1) {
                sumCards += faceValue;
            }
            else {
                sumCards += faceValue * count * 2;
            }
        }
        System.out.println(sumCards);
    }

    private static int getCardValue(String card) {
        switch (card) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
            default:
                throw new IllegalArgumentException("Invalid card: " + card);
        }
    }

}
