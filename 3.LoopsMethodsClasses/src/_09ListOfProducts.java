import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class _09ListOfProducts {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        //File tests = new File("_09ListOfProductsInput1.txt");
        File tests = new File("_09ListOfProductsInput2.txt");
        File output = new File("_09ListOfProductsOutput.txt");

        List<Product> productList = new ArrayList<>();

        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                //http://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values
                String[] inputLine = input.nextLine().split(" ", -1);
                String name = inputLine[0];
                BigDecimal price = new BigDecimal(inputLine[1]);
                Product currentProduct = new Product(name, price);
                productList.add(currentProduct);
            }

            Collections.sort(productList);

            String joinedProducts = productList.stream()
                                              .map(Product::toString)
                                          .collect(Collectors.joining("\n"));

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.println(joinedProducts);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
