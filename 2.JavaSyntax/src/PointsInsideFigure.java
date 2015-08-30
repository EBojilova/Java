import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class PointsInsideFigure {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT); // Savpada s InvariantCulture ot C#
        //File tests = new File("testsPointsInsideFigure.txt");
        File tests = new File("testsPointsInsideFigure2.txt");
        File output = new File("outputInFigure.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                double X = input.nextDouble();
                double Y = input.nextDouble();

                boolean inside = isInside(X, Y);

                String result = inside ? "Inside" : "Outside";

                System.out.printf("{%5.2f, %5.2f} %s", X, Y, result).println();
                sb.append(String.format("{%5.2f, %5.2f} %s%n", X, Y, result));
            }

            PrintWriter fileOutput = new PrintWriter(output);
            fileOutput.println(sb);
            fileOutput.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private static boolean isInside(double x, double y) {

        boolean inRoof = (y >= 6.0 && y <= 8.5) && (x >= 12.5 && x <= 22.5);
        boolean inLeftWall = (y >= 8.5 && y <= 13.5) && (x >= 12.5 && x <= 17.5);
        boolean inRightWall = (y >= 8.5 && y <= 13.5) && (x >= 20 && x <= 22.5);

        return inRoof || inLeftWall || inRightWall;
    }
}
