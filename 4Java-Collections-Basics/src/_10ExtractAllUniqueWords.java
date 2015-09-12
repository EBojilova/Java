import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class _10ExtractAllUniqueWords {

    public static void main(String[] args) {
        File tests = new File("_10ExtractAllUniqueWords.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String inputString=input.nextLine();

                String[] words = inputString.trim().toLowerCase().split("\\W+");
                Set<String> uniqueWords= new TreeSet<>(Arrays.asList(words));

                System.out.println(String.join(" ", uniqueWords));
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
