import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class _11MostFrequentWord {

    public static void main(String[] args) {
        File tests = new File("_11MostFrequentWord.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String wordsStr = input.nextLine();

                String[] words = wordsStr.trim().toLowerCase().split("\\W+");

                Map<String, Long> counted = Arrays.stream(words)
                                                  .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

//                Map.Entry<String, Long> max = counted.entrySet().stream().max(Map.Entry.comparingByValue(Long::compareTo)).get();
//                long maxCount = max.getValue();
                long maxCount = (Collections.max(counted.values()));

                //http://stackoverflow.com/questions/25712591/java8-convert-one-map-to-an-another-using-stream
                TreeMap<String, Long> result = counted.entrySet().stream().filter(x -> x.getValue() == maxCount).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));

                for (String key : result.keySet()) {
                    System.out.printf("%s -> %d times", key, maxCount).println();
                }
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
