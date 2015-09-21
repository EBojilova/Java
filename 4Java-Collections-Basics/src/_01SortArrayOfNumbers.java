import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _01SortArrayOfNumbers {

    public static void main(String[] args) {

        File tests = new File("_01SortArrayOfNumbers.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                input.nextLine();
                String numbersStr= input.nextLine();

                int[] numbers = Arrays.stream(numbersStr.split("[^0-9-]"))
                                      .filter(word -> !word.isEmpty())
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

                Arrays.sort(numbers);


                Arrays.stream(numbers).forEach(number -> System.out.printf("%d ", number));
                System.out.println();

//                Arrays.stream(
//                        input.nextLine().split(" "))
//                      .mapToInt(Integer::parseInt)
//                      .sorted()
//                      .forEach(s -> System.out.printf("%s ", s));
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
