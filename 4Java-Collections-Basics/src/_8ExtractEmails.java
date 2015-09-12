import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _8ExtractEmails {

    public static void main(String[] args) {
        File tests = new File("_8ExtractEmails.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String text = input.nextLine();

                String pat = "(?<=\\s|^)([a-z0-9]+(?:[_.-][a-z0-9]+)*@[a-z]+\\-?[a-z]+(?:\\.[a-z]+)+)\\b";
                Pattern pattern = Pattern.compile(pat);
                Matcher matcher = pattern.matcher(text);

                while (matcher.find()){
                    System.out.println(matcher.group());
                }
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
