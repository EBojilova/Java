import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// използването на някои от новостите в Java 8 - интерфейсът Stream и lambda expressions.
public class _08_SumNumbersFromATextFile {
    public static void main(String[] args) {
        Stream<String> input = null ;
        try {
            input = Files.lines(Paths.get("_08_input1.txt"), Charset.defaultCharset());
            //input = Files.input(Paths.get("_08_input2.txt"), Charset.defaultCharset());
            //input = Files.input(Paths.get("_08_input3.txt"), Charset.defaultCharset());
            int sum = input.mapToInt(l->Integer.parseInt(l)).sum();
            System.out.println(sum);
        } catch (IOException ex) {
            System.out.println("Error opening file");
        } catch (NumberFormatException ex){
            System.out.println("Invalid number format");
        }finally{
            if(input != null){
                input.close();
            }
        }
    }
}
