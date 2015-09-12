import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _5CountAllWords {

    public static void main(String[] args) {

        File tests = new File("_5CountAllWords.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String inputString=input.nextLine();
                if (inputString.equals("")){
                    System.out.println(0);
                    continue;
                }
                int count = inputString.trim().split("[^a-zA-Z]+").length;
                System.out.println(count);
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }

}
