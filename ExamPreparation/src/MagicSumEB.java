import java.util.ArrayList;
import java.util.Scanner;

public class MagicSumEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            numbers.add(Integer.parseInt(input));
        }
        boolean hasMagicSum = false;
        int maxSum = Integer.MIN_VALUE;
        Integer[] magicNumbers = new Integer[3];
        int numbersCount = numbers.size();
        for (int n1 = 0; n1 < numbersCount - 2; n1++) {
            for (int n2 = n1 + 1; n2 < numbersCount - 1; n2++) {
                for (int n3 = n2 + 1; n3 < numbersCount; n3++) {
                    int sum = numbers.get(n1) + numbers.get(n2) + numbers.get(n3);
                    if (sum % d == 0) {
                        hasMagicSum = true;
                        if (sum > maxSum) {
                            maxSum = sum;
                            magicNumbers[0] = numbers.get(n1);
                            magicNumbers[1] = numbers.get(n2);
                            magicNumbers[2] = numbers.get(n3);
                        }
                    }
                }

            }
        }
        if (hasMagicSum) {
            System.out.printf("(%d + %d + %d) %% %d = 0", magicNumbers[0], magicNumbers[1], magicNumbers[2], d)
                      .println();
        }
        else {
            System.out.println("No");
        }
    }

}
