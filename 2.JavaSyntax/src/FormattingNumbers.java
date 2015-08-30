import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        File tests = new File("testFormatingNumbers.txt");
        File output = new File("outputFormatingNumbers.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                int a = input.nextInt();
                double b = input.nextDouble();
                double c = input.nextDouble();

                String binaryA=String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");
                System.out.printf("|%-10X|%s|%10.2f|%-10.3f|", a, binaryA, b, c).println();
                sb.append(String.format("|%-10X|%s|%10.2f|%-10.3f|", a, binaryA, b, c)).append(System.getProperty("line.separator"));
            }

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.println(sb);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
