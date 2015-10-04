package dictionary;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OfficeStuffKatya {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, LinkedHashMap<String, Integer>> companyProductQuantity = new TreeMap<String, LinkedHashMap<String, Integer>>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] imputLine = line.substring(1, line.length() - 1)
                                     .split("\\W+");

            String company = imputLine[0];
            String product = imputLine[2];
            Integer amount = Integer.parseInt(imputLine[1]);

            // only in Java, not availble . putIfAbsent in C#
            companyProductQuantity.putIfAbsent(company, new LinkedHashMap<String, Integer>());
            companyProductQuantity.get(company)
                                  .putIfAbsent(product, 0);
            int currentTotal = companyProductQuantity.get(company)
                                                     .get(product) + amount;
            companyProductQuantity.get(company)
                                  .put(product, currentTotal);
        }

        printResult(companyProductQuantity);
    }

    private static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> orders) {
        for (String company : orders.keySet()) {

            System.out.printf("%s: ", company);
            String result = orders.get(company)
                                  .keySet()
                                  .stream()
                                  .map(product -> String.format("%s-%d", product, orders.get(company)
                                                                                        .get(product)))
                                  .collect(Collectors.joining(", "));
            System.out.printf("%s", result)
                      .println();

        }
    }
}
