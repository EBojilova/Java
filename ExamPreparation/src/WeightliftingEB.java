import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WeightliftingEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<String, TreeMap<String, BigInteger>> playerExerciseKilograms = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = input.nextLine()
                                      .trim()
                                      .split("\\W+");
            String playerName = inputLine[0];
            String exercise = inputLine[1];
            BigInteger kilograms = new BigInteger(inputLine[2]);
            if (!playerExerciseKilograms.containsKey(playerName)) {
                playerExerciseKilograms.put(playerName, new TreeMap<>());
            }
            if (!playerExerciseKilograms.get(playerName)
                                        .containsKey(exercise)) {
                playerExerciseKilograms.get(playerName)
                                       .put(exercise, new BigInteger("0"));
            }
            BigInteger currentKilograms = playerExerciseKilograms.get(playerName)
                                                                 .get(exercise);
            playerExerciseKilograms.get(playerName)
                                   .put(exercise, currentKilograms.add(kilograms));
        }

        printResult(playerExerciseKilograms);
    }

    private static void printResult(TreeMap<String, TreeMap<String, BigInteger>> playerExerciseKilograms) {
        for (String playerName : playerExerciseKilograms.keySet()) {

            System.out.printf("%s : ", playerName);
            String result = playerExerciseKilograms.get(playerName)
                                                   .keySet()
                                                   .stream()
                                                   .map(exercise -> String.format("%s - %d kg", exercise, playerExerciseKilograms.get(playerName)
                                                                                                                                 .get(exercise)))
                                                   .collect(Collectors.joining(", "));
            System.out.printf("%s", result)
                      .println();
        }
    }
}
