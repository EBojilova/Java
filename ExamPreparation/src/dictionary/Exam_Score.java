package dictionary;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exam_Score {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Skip the first 3 lines
        input.nextLine();
        input.nextLine();
        input.nextLine();
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<Integer, TreeMap<String, Double>> scoresNamesGrades = new TreeMap<>();
        while (true) {
            String[] inputLine = input.nextLine().split("\\s*\\|\\s*");
            if (inputLine.length < 4) {
                // The footer line is reached
                break;
            }
            String studentName = inputLine[1];
            int score = Integer.parseInt(inputLine[2]);
            double grade = Double.parseDouble(inputLine[3]);
            if (!scoresNamesGrades.containsKey(score)) {
                scoresNamesGrades.put(score, new TreeMap<>());
            }
            scoresNamesGrades.get(score).put(studentName, grade);
        }

        for (Integer score : scoresNamesGrades.keySet()) {

            int average = scoresNamesGrades.get(score).values().stream().mapToInt(Number::intValue).sum();
//            alex: 62 [10.10.17.33, 212.50.118.81]
            System.out.printf("%s: %d %s", score, scoresNamesGrades.get(score).keySet(), average).println();

        }
    }

}
