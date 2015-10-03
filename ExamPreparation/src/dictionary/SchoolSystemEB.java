package dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SchoolSystemEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<String, TreeMap<String, List<Double>>> scoresNamesGrades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine()
                                        .split("\\W+");
            String studentName = inputLine[0] + " " + inputLine[1];
            String subject = inputLine[2];
            double grade = Double.parseDouble(inputLine[3]);
            if (!scoresNamesGrades.containsKey(studentName)) {
                scoresNamesGrades.put(studentName, new TreeMap<>());
            }
            if (!scoresNamesGrades.get(studentName)
                                  .containsKey(subject)) {
                scoresNamesGrades.get(studentName)
                                 .put(subject, new ArrayList<>());
            }

            scoresNamesGrades.get(studentName)
                             .get(subject)
                             .add(grade);

        }

        printResult(scoresNamesGrades);
    }

    private static void printResult(TreeMap<String, TreeMap<String, List<Double>>> scoresNamesGrades) {
        for (String studentName : scoresNamesGrades.keySet()) {

            System.out.printf("%s: ", studentName);
            String result = scoresNamesGrades.get(studentName)
                                             .keySet()
                                             .stream()
                                             .map(subject -> String.format("%s - %.2f", subject, scoresNamesGrades.get(studentName)
                                                                                                                  .get(subject)
                                                                                                                  .stream()
                                                                                                                  .mapToDouble(a -> a)
                                                                                                                  .average()
                                                                                                                  .getAsDouble()))
                                             .collect(Collectors.joining(", "));
            System.out.printf("[%s]", result)
                      .println();

        }
    }
}
