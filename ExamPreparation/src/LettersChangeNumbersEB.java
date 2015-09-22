import java.util.Scanner;

public class LettersChangeNumbersEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String numbersStr = input.nextLine();
        String[] chars = numbersStr
                .trim()
                .split("[^a-zA-z0-9]+");
        double sum = 0;
        for (int i = 0; i < chars.length; i++) {
            char inFront = chars[i].charAt(0);
            char atBack = chars[i].charAt(chars[i].length() - 1);
            String number = chars[i].substring(1, chars[i].length() - 1);
            double currentNumber = Double.parseDouble(number);

            currentNumber = executeFirstChar(inFront, currentNumber);
            currentNumber = executeSecondChar(atBack, currentNumber);
            sum += currentNumber;
        }
        System.out.printf("%.2f", sum);
    }

    private static double executeSecondChar(char atBack, double currentNumber) {
        if (Character.isUpperCase(atBack)) {
            int letterPosition = atBack - 'A' + 1;
            return currentNumber - letterPosition;
        }
        int letterPosition = atBack - 'a' + 1;
        return currentNumber + letterPosition;
    }

    private static double executeFirstChar(char inFront, double currentNumber) {
        if (Character.isUpperCase(inFront)) {
            int letterPosition = inFront - 'A' + 1;
            return currentNumber / letterPosition;
        }
        int letterPosition = inFront - 'a' + 1;
        return currentNumber * letterPosition;
    }
}
