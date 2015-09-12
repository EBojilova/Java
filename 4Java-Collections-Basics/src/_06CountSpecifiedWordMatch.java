import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06CountSpecifiedWordMatch {

    public static void main(String[] args) {
        File tests = new File("_06CountSpecifiedWord.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String inputString = input.nextLine();
                String findStr = input.nextLine();
                String pat = String.format("(?<=\\W|^)%s(?=\\W|$)",findStr);
                Pattern pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(inputString);

                int count = 0;
                while(matcher.find()){
                    count++;
                }
                System.out.println(count);
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
