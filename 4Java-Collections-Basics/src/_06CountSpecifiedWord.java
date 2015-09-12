import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _06CountSpecifiedWord {

    public static void main(String[] args) {
        File tests = new File("_06CountSpecifiedWord.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String inputString = input.nextLine().toLowerCase();
                String findStr = input.nextLine().toLowerCase();
                // \b assert position at a word boundary (^\w|\w$|\W\w|\w\W)
                String pattern = String.format("\\b%s\\b", findStr);
                System.out.println(inputString.split(pattern, -1).length - 1);
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
