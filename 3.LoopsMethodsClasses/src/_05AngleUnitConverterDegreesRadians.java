import java.util.Scanner;

public class _05AngleUnitConverterDegreesRadians {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of conversions:");
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            //http://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values
            String[] inputLine = input.nextLine().split(" ", -1);
            double number = Double.parseDouble(inputLine[0]);
            String measurement = inputLine[1];
            switch (measurement) {
                case "deg":
                    convertDegreesToRadians(number, "rad");
                    break;
                case "rad":
                    convertRadiansToDegrees(number, "deg");
                    break;
                default:
                    System.out.println("Please enter correct measurement.");
                    break;
            }
        }
    }

    private static void convertRadiansToDegrees(double numberInRadians, String deg) {
        double numberInDegrees = Math.toDegrees(numberInRadians);
        printResult(numberInDegrees, deg);
    }

    private static void convertDegreesToRadians(double numberInDegrees, String rad) {
        double numberInRadians = Math.toRadians(numberInDegrees);
        printResult(numberInRadians, rad);
    }

    private static void printResult(double numberInDegrees, String measurement) {
        System.out.printf("%10.6f %s", numberInDegrees, measurement).println();
    }
}
