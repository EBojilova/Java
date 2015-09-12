import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _4LongestIncreasingSequenceWithoutLists {

    public static void main(String[] args) {
        File tests = new File("_4LongestIncreasingSequence.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String numbersStr = input.nextLine();

//                List<Integer> numbers = Arrays.asList(numbersStr.split("[^0-9-]"))
//                                              .stream()
//                                              .map(x -> Integer.parseInt(x))
//                                              .collect(Collectors.toList());

                int[] numbers = Arrays.stream(numbersStr.split("[^0-9-]"))
                                      .filter(word -> !word.isEmpty())
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

                int maxCounter = 1;
                int currentCounter = 1;
                int endLongestSequenceIndex = 0;
                System.out.print(numbers[0] + " ");
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] > numbers[i - 1]) {
                        System.out.print(numbers[i] + " ");
                        currentCounter++;
                    }
                    else {
                        System.out.println();
                        System.out.print(numbers[i] + " ");
                        currentCounter = 1;
                    }

                    if (currentCounter > maxCounter) {
                        maxCounter = currentCounter;
                        endLongestSequenceIndex = i;
                    }
                }
                System.out.println();
                System.out.print("Longest: ");
                int index = (endLongestSequenceIndex - (maxCounter - 1));
                for (int y = 0; y < maxCounter; y++) {
                    System.out.print(numbers[index] + " ");
                    index++;
                }
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
