import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07CountSubstringOccurrences {

    public static void main(String[] args) {
        File tests = new File("_07CountSubstringOccurrences.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String text = input.nextLine().toLowerCase();
                String stringToSearch = input.nextLine();

                Pattern pattern = Pattern.compile(stringToSearch);
                Matcher matcher = pattern.matcher(text);

                int count = 0;
                int start=0;
                while (matcher.find(start)) {
                    count++;
//                    int firstIndex = matcher.start();
//                    matcher.region(firstIndex + 1, text.length());
                    start=matcher.start()+1;
                }

                System.out.println(count);
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
