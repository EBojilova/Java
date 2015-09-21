import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileWithFinally {

    private static String readTextFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        // inicializirame reader tuka, za da mojem da go zatvorim vav finally, ako e razlichen ot null, no e po-udobno da polzvame try with resorces, poneje avtomatichno try zatvaria resorces
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String newLine = System.getProperty("line.separator");
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(newLine);
            }
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String fileName = "src/ReadTextFile.Java";
        try {
            String fileContent = readTextFile(fileName);
            System.out.println(fileContent);
        }
        catch (IOException ioex) {
            System.out.println("Can not read file: " + fileName);
        }
    }
}
