import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03LargestSequenceOfEqualStrings {

    public static void main(String[] args) {
        File tests = new File("_03LargestSequenceOfEqualStrings.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String wordsStr = input.nextLine();

                String[] words = wordsStr.split("\\W+");

                Map<String, Long> counted = Arrays.stream(words)
                                                  .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

                long maxCount = 0;
                String wordMaxCount = "";
                for (String key : counted.keySet()) {
                    long n = counted.get(key);
                    if (n > maxCount) {
                        maxCount = n;
                        wordMaxCount = key;
                    }
                }
                for (long i = 0; i < maxCount; i++) {

                    System.out.printf("%s ", wordMaxCount);
                }

//                String sequence = Arrays.stream(words)
//                                        .collect(Collectors.groupingBy(s -> s))
//                                        .entrySet()
//                                        .stream()
//                                        .max((entry1, entry2) -> entry1.getValue().size() > entry2.getValue().size() ? 1 : -1)
//                                        .get()
//                                        .getValue()
//                                        .stream()
//                                        .map(i -> i.toString())
//                                        .collect(Collectors.joining(" "));
                System.out.println();

            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }
}
