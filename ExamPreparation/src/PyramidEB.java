import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PyramidEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> growingSequence = new ArrayList<>();
        int currentNum = Integer.parseInt(scanner.nextLine()
                                                .trim());
        growingSequence.add(currentNum);
        for (int i = 1; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                                                  .trim()
                                                  .split("[^0-9-]+"))
                                   .mapToInt(Integer::parseInt)
                                   .sorted()
                                   .toArray();
            boolean hasLarger = false;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] > currentNum) {
                    hasLarger = true;
                    currentNum = numbers[j];
                    growingSequence.add(numbers[j]);
                    break;
                }
            }
            if (!hasLarger) {
                currentNum++;
            }
        }

        String result = growingSequence
                .stream()
                .map(num -> num.toString())
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
