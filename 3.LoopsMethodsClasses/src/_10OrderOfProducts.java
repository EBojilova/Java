import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _10OrderOfProducts {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        File products = new File("_10_Product1.txt");
        File orders = new File("__10_Order1.txt");
        //File products = new File("_10_Product2.txt");
        //File orders = new File("__10_Order2.txt");
        File output = new File("_10_OrderOfProductsOutput.txt");

        Map<String, Product> listProducts = new HashMap<>();

        BigDecimal totalOrderPrice = new BigDecimal(0);

        try {
            Scanner input = new Scanner(products);
            while (input.hasNextLine()) {
                //http://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values
                String[] inputLine = input.nextLine().split(" ", -1);
                String name = inputLine[0];
                BigDecimal price = new BigDecimal(inputLine[1]);
                Product currentProduct = new Product(name, price);
                listProducts.put(name, currentProduct);
            }
            input = new Scanner(orders);
            while (input.hasNextLine()) {
                //http://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values
                String[] inputLine = input.nextLine().split(" ", -1);
                BigDecimal orderedQuantity = new BigDecimal(inputLine[0]);
                String productName = inputLine[1];
                Product orderedProduct = listProducts.get(productName);
                BigDecimal currentBill = orderedQuantity.multiply(orderedProduct.getPrice());
                totalOrderPrice = totalOrderPrice.add(currentBill);
            }

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.printf("%.2f $", totalOrderPrice);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
