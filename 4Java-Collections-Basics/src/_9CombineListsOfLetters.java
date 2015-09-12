import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _9CombineListsOfLetters {

    public static void main(String[] args) {
        File tests = new File("_9CombineListsOfLetters.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                char[] firstChars = input.nextLine().replaceAll(" ", "").toCharArray();
                List<Character> firstList = new ArrayList<>();
                for (char firstChar : firstChars) {
                    firstList.add(firstChar);
                }

                char[] secondChars = input.nextLine().replaceAll(" ", "").toCharArray();
                List<Character> secondList = new ArrayList<>();
                for (char secondChar : secondChars) {
                    secondList.add(secondChar);
                }

                secondList.removeAll(firstList);
                firstList.addAll(secondList);

                firstList.forEach(n -> System.out.printf("%s ",n));
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
