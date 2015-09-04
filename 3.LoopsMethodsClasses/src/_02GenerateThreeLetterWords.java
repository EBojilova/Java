import java.util.Scanner;

public class _02GenerateThreeLetterWords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter letters: ");
        String inputString = input.nextLine().trim().toLowerCase();

        char[] letters = inputString.toCharArray();

        System.out.println("All possible 3-letters combinations are:");
        for (char letter1 : letters) {
            for (char letter2 : letters) {
                for (char letter3 : letters) {
                    System.out.printf("%s%s%s ", letter1, letter2, letter3);
                }
            }
        }
    }
}
