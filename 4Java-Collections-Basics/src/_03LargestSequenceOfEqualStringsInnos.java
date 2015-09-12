import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class _03LargestSequenceOfEqualStringsInnos {

    public static void main(String[] args) {
        File tests = new File("_03LargestSequenceOfEqualStrings.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String wordsStr = input.nextLine();

                String[] words = wordsStr.split("\\W+");

                ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

                Comparator<List<String>> orderByDescendingBySize = new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> o1, List<String> o2) {
                        Integer o2Size = o2.size();
                        Integer o1Size = o1.size();
                        return o2Size.compareTo(o1Size);
                    }
                };

                List<String> result = wordsList
                        .stream()
                        .collect(Collectors.groupingBy(w -> w))
                        .values()
                        .stream()
                        .sorted(orderByDescendingBySize)
                        .findFirst()
                        .orElse(null);

                System.out.println(String.join(" ", result));
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }

}
