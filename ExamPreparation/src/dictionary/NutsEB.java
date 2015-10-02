package dictionary;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NutsEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<String, LinkedHashMap<String, Integer>> companyProductQuantity = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = input.nextLine()
                                      .trim()
                                      .split("\\W+");
            String company = inputLine[0];
            String product = inputLine[1];
            int quantity = Integer.parseInt(inputLine[2].replace("kg", ""));
            if (!companyProductQuantity.containsKey(company)) {
                companyProductQuantity.put(company, new LinkedHashMap<>());
            }
            if (!companyProductQuantity.get(company)
                                       .containsKey(product)) {
                companyProductQuantity.get(company)
                                      .put(product, 0);
            }
            int currentQuantity = companyProductQuantity.get(company)
                                                        .get(product);
            companyProductQuantity.get(company)
                                  .put(product, currentQuantity + quantity);
        }

        printResult(companyProductQuantity);
    }

    private static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> companyProductQuantity) {
        for (String company : companyProductQuantity.keySet()) {

            System.out.printf("%s: ", company);
            String result = companyProductQuantity.get(company)
                                                  .keySet()
                                                  .stream()
                                                  .map(product -> String.format("%s-%dkg", product, companyProductQuantity.get(company)
                                                                                                                        .get(product)))
                                                  .collect(Collectors.joining(", "));
            System.out.printf("%s", result)
                      .println();
        }
    }
}
