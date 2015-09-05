import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class _08SumNumbersFromTextFile {

    public static void main(String[] args) {
        try {

            FileReader tests = new FileReader("_08_input1.txt");
            //FileReader tests = new FileReader("_08_input2.txt");
            //FileReader tests = new FileReader("_08_input3.txt");

            long sum = 0;

            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                sum += input.nextInt();
            }

            System.out.println(sum);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
    }
}
