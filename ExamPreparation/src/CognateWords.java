import java.util.*;

public class CognateWords {

    static boolean solution = false;

    static List<String> list = new ArrayList<String>();

    static Map<String, String[]> uniqueSubsets = new HashMap<String, String[]>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = input.nextLine().split("[^a-zA-Z]+");
        list = Arrays.asList(words);

        makeSubsets();

        for (String key : uniqueSubsets.keySet()) {
            if (list.contains(key)) {
                String[] value = uniqueSubsets.get(key);
                System.out.printf("%s|%s=%s", value[0], value[1], key).println();
                solution = true;
            }
        }
        if (!solution) {
            System.out.println("No");
        }
    }

    public static void makeSubsets() {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                addKeyAndValue(i, j);

                addKeyAndValue(j, i);
            }
        }
    }

    private static void addKeyAndValue(int i, int j) {
        String key = String.format("%s%s", list.get(i), list.get(j));
        String[] value = {list.get(i), list.get(j)};
        uniqueSubsets.put(key, value);
    }
}
