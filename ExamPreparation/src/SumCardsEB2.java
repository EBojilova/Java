import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumCardsEB2 {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>(Arrays.asList("*", "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "*", "J", "Q", "K", "A"));
        Scanner input = new Scanner(System.in);
        String[] inputFces = input.nextLine().trim().split("[\\WSHDC]+");

        int sumCards = 0;
        for (int i = 0; i < inputFces.length; i++) {
            int count = 1;
            while ((i + 1 < inputFces.length) && (inputFces[i + 1].equals(inputFces[i]))) {
                count++;
                i++;
            }

            int faceValue = values.indexOf(inputFces[i]);
            if (count == 1) {
                sumCards += faceValue;
            }
            else {
                sumCards += faceValue * count * 2;
            }
        }
        System.out.println(sumCards);
    }
}
