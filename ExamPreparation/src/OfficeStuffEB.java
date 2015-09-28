import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OfficeStuffEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<String, LinkedHashMap<String, Integer>> companyProductQuantity = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String inputStr = input.nextLine()
                                   .replace("|", "");
            String[] inputLine = inputStr.trim()
                                         .split("[\\s-]+");
            String company = inputLine[0];
            int quantity = Integer.parseInt(inputLine[1]);
            String product = inputLine[2];
            if (!companyProductQuantity.containsKey(company)) {
                companyProductQuantity.put(company, new LinkedHashMap<>());
            }
            if (!companyProductQuantity.get(company)
                                       .containsKey(product)) {
                companyProductQuantity.get(company)
                                      .put(product, 0);
            }
            int currentDuration = companyProductQuantity.get(company)
                                                        .get(product);
            companyProductQuantity.get(company)
                                  .put(product, currentDuration + quantity);
        }

        printResult(companyProductQuantity);
    }

    private static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> companyProductQuantity) {
        for (String company : companyProductQuantity.keySet()) {

            System.out.printf("%s: ", company);
            String result = companyProductQuantity.get(company)
                                                  .keySet()
                                                  .stream()
                                                  .map(product -> String.format("%s-%d", product, companyProductQuantity.get(company)
                                                                                                                        .get(product)))
                                                  .collect(Collectors.joining(", "));
            System.out.printf("%s", result)
                      .println();
        }
    }
}
