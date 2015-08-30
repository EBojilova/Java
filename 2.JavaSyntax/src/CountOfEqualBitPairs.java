import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class CountOfEqualBitPairs {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        File tests = new File("testsCoutOfBitsOne.txt");
        File output = new File("outputCoutOfBitPairs.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                int number = input.nextInt();
                int countPairs = getCountPairs(number);
                System.out.println(countPairs);
                sb.append(countPairs).append(System.getProperty("line.separator"));
            }

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.println(sb);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private static int getCountPairs(int number) {
        int mask = 3;
        int countPairs = 0;

        while (number > 2) {
            if ((number & mask) == 3 || (number & mask) == 0) {
                countPairs++;
            }

            number >>= 1;
        }
        return countPairs;
    }
}
