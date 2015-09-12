import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class PointsInsideFigurePolygon {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT); // Savpada s InvariantCulture ot C#

        Path2D.Double poligon = new Path2D.Double();
        poligon.moveTo(12.5, 6);
        poligon.lineTo(22.5, 6);
        poligon.lineTo(22.5, 13.5);
        poligon.lineTo(20, 13.5);
        poligon.lineTo(20, 8.5);
        poligon.lineTo(17.5, 8.5);
        poligon.lineTo(17.5, 13.5);
        poligon.lineTo(12.5, 13.5);
        poligon.lineTo(12.5, 6);
        poligon.closePath();

        File tests = new File("testsPointsInsideFigure.txt");
        //File tests = new File("testsPointsInsideFigure2.txt");
        File output = new File("outputInFigurePolygon.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner input = new Scanner(tests);
            while (input.hasNextLine()) {
                double X = input.nextDouble();
                double Y = input.nextDouble();

                // mnogo hitar nachin, no ne deistva za tochkite na krainia rab na poligona, i te triabva da sa Inside
//                {21.00, 13.50} Outside
//                {22.50,  8.50} Outside
//                {17.50, 13.50} Outside
//                {17.60,  8.50} Outside

                boolean inside = poligon.contains(X, Y);

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
}
