import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class TheSmallestOfThreeNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        File tests = new File("testsSmallest.txt");
        File output = new File("outputSmallest.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                double a = input.nextDouble();
                double b = input.nextDouble();
                double c = input.nextDouble();
                double min = min(a, b, c);
                DecimalFormat format = new DecimalFormat("0.#");
                System.out.println(format.format(min));
                sb.append(format.format(min)).append(System.getProperty("line.separator"));
            }

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.println(sb);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private static double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }
}
