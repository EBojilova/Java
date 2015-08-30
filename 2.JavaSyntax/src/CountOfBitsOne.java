import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class CountOfBitsOne {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        File tests = new File("testsCoutOfBitsOne.txt");
        File output = new File("outputCoutOfBitsOne.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                int a = input.nextInt();
                int countBits = Integer.bitCount(a);
                System.out.println(countBits);
                sb.append(countBits).append(System.getProperty("line.separator"));
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
