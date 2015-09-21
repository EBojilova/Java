import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

    private static String readTextFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        // vidovete exeptions mogat da se vidiat v http://docs.oracle.com/javase/7/docs/api/java/lang/package-tree.html

        // try with resources, po-udobno, tai kato try avtomatichno dava close na resourses sled izpalnenie- po-praktichno e ot finally-vij otdelen klas
        try (
                BufferedReader reader =
                        new BufferedReader(new FileReader(fileName))
        ) {
            String newLine = System.getProperty("line.separator");
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(newLine);
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
