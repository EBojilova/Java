import java.util.*;
import java.util.stream.Collectors;

public class _08_CountingWordsWithHashMap {

    public static void main(String[] args) {
        String[] words = {
                "yes", "hi", "hello", "hi", "welcome", "yes", "yes",
                "welcome", "hi", "yes", "hello", "yes"
        };
// Vsichki vidove HashMap,TreeMap,LinkedHashMap mogat da se sazdavat s interface Map

        // Linked Has Map orders the items in the way they are entered, while Hash Map orders them on random principle.
        Map<String, Integer> wordsCountLinked =
                new LinkedHashMap<String, Integer>();

        for (String word : words) {

            if (!wordsCountLinked.containsKey(word)) {
                wordsCountLinked.put(word,0);
            }
            wordsCountLinked.put(word, wordsCountLinked.get(word)+1);
        }
        System.out.println("LinkedHashMap");
        System.out.println(wordsCountLinked);


        Map<String, Integer> wordsCount =
                new HashMap<String, Integer>();

        for (String word : words) {
            Integer count = wordsCount.get(word);
            if (count == null) {
                count = 0;
            }
            wordsCount.put(word, count + 1);
        }
        System.out.println("HashMap");
        System.out.println(wordsCount);

        // iter- avtomatichno INTELLIJ znae che stava vapros za Key Seta
        for (String word : wordsCount.keySet()) {
            int count = wordsCount.get(word);
            System.out.printf("%s -> %d times\n", word, count);
        }

        Map<String, ArrayList<Double>> namesGrades =
               new TreeMap<>();

        namesGrades.put("Pesho", new ArrayList<>( Arrays.asList(2.0, 4.0, 6.0)));
        namesGrades.put("Gosho", new ArrayList<>( Arrays.asList(4.0, 4.0, 6.0)));
        namesGrades.put("Tosho", new ArrayList<>( Arrays.asList(2.0, 6.0, 6.0)));

        System.out.println(namesGrades);

        namesGrades.get("Pesho").remove(2.0);
        System.out.println(namesGrades);

        for (String name : namesGrades.keySet()) {
            double averageGrade=namesGrades.get(name).stream().collect(Collectors.averagingDouble(grade -> grade.doubleValue()));
            System.out.printf("%s -> %.2f average grade", name, averageGrade).println();
        }
    }
}
