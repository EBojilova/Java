import java.math.BigDecimal;
import java.util.Scanner;

public class SimpleExpressionEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().trim();
        //expression = expression.replace(" ", ""); moje da se izpolzva vmesto trim, no ima poveche vreme za izpalnenie
        String[] numbers = expression.split("[^0-9.]+");
        String[] operators = expression.split("[^+-]+");
        BigDecimal sum = new BigDecimal(numbers[0]);
        for (int i = 1; i < operators.length; i++) {
            BigDecimal number = new BigDecimal(numbers[i]);
            if (operators[i].equals("+")) {
                sum = sum.add(number);
            } else if (operators[i].equals("-")) {
                sum = sum.subtract(number);
            } else {
                throw new IllegalArgumentException(
                        "Invalid operator: " + operators[i]);
            }
        }
        // The toString() method may use scientific notation while toPlainString() never will
        System.out.println(sum.toPlainString());
    }
}
