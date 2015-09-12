import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _12CardsFrequencies {

    public static void main(String[] args) {
        File tests = new File("_12CardsFrequencies.txt");

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                String wordsStr = input.nextLine();

                // The split also removes the unicode characters of the suits.
                String[] faces = wordsStr.trim().split("\\W+");

// Map changes the order of the input, while LinkedHashMap keeps the order of the input.
                Map<String, Long> faceCount = Arrays.stream(faces)
                                                    .collect(Collectors.groupingBy(o -> o, LinkedHashMap::new, Collectors.counting()));
//                Map<String, Long> faceCount = Arrays.asList(faces)
//                                                                 .stream()
//                                                                 .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));

                for (String face : faceCount.keySet()) {
                    double percentage = (double) faceCount.get(face) / faces.length * 100;
                    System.out.printf("%s -> %.2f%%", face, percentage).println();
                }
                System.out.println();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
