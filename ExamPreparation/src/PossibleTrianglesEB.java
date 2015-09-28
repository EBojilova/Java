import java.util.Arrays;
import java.util.Scanner;

public class PossibleTrianglesEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean possibleTriangle = false;
        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            double[] numbers = Arrays.stream(input.split(" "))
                                     .mapToDouble(Double::parseDouble)
                                     .sorted()
                                     .toArray();

            double a = numbers[0];
            double b = numbers[1];
            double c = numbers[2];

            if (a + b > c) {
                System.out.printf("%.2f+%.2f>%.2f", a, b, c)
                          .println();
                possibleTriangle = true;
            }

        }

        if (!possibleTriangle) {
            System.out.println("No");
        }

    }
}
