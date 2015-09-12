import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _09_TreeMapStudentsAndGrades {

    public static void main(String[] args) {
        // Moje da se se indentificira s Map(interface)za vsichki vidove mapove
        Map<String, ArrayList<Integer>> namesGrades = new HashMap<>();
        namesGrades.put("Peter", new ArrayList<>(Arrays.asList(5)));
        namesGrades.put("George", new ArrayList<>(Arrays.asList(5, 5, 6)));
        namesGrades.put("Maria", new ArrayList<>(Arrays.asList(5, 4, 4)));
        namesGrades.get("Peter").add(6);
        namesGrades.get("George").add(6);

        System.out.println(namesGrades);
        for (String key : namesGrades.keySet()) {
            System.out.println("" + key + " -> " + namesGrades.get(key));
        }

        for (String name : namesGrades.keySet()) {
            double averageGrade=namesGrades.get(name).stream().collect(Collectors.averagingDouble(grade -> grade.doubleValue()));
            System.out.printf("%s -> %.2f average grade", name, averageGrade).println();
        }
    }
}
