import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _4LongestIncreasingSequence {

    public static void main(String[] args) {
        File tests = new File("_4LongestIncreasingSequence.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String numbersStr = input.nextLine();

                int[] numbers = Arrays.stream(numbersStr.split("[^0-9-]"))
                                      .filter(word -> !word.isEmpty())
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

                List<Integer> longest = new ArrayList<>();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < numbers.length - 1; i++) {
                    temp.clear();
                    temp.add(numbers[i]);
                    while ((i < numbers.length - 1) && (numbers[i + 1] > numbers[i])) {
                        temp.add(numbers[i + 1]);
                        i++;
                    }
                    System.out.println(String.join(" ", temp.stream().map(x -> x.toString()).collect(Collectors.toList())));
//                    temp.stream().forEach(number -> System.out.printf("%d ", number));
//                    System.out.println();
                    if (temp.size() > longest.size()) {
                        longest.clear();
                        longest.addAll(temp);
                    }
                }
                System.out.print("Longest: ");
                System.out.println(String.join(" ", longest.stream().map(x -> x.toString()).collect(Collectors.toList())));
//                longest.stream().forEach(number -> System.out.printf("%d ", number));
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
