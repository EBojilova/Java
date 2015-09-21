import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class _02SequencesOfEqualStrings {

    public static void main(String[] args) {
        File tests = new File("_03LargestSequenceOfEqualStrings.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String wordsStr = input.nextLine();

                String[] words = wordsStr.split("\\W+");

                ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
                LinkedHashMap<String,List<String>> counted = wordsList
                        .stream()
                        .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.toCollection(ArrayList::new)));

                for (String key : counted.keySet()) {
                    System.out.println(String.join(" ", counted.get(key)));
                }
                System.out.println();
//                String[] array = input.nextLine().split(" ");
//
//                Arrays.stream(array)
//                      .collect(Collectors.groupingBy(s -> s))
//                      .values()
//                      .stream()
//                      .forEach(s -> System.out.printf("%s\n", String.join(" ", s)));
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
