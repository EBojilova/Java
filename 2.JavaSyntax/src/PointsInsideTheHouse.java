import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class PointsInsideTheHouse {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT); // Savpada s InvariantCulture ot C#
        File tests = new File("testsPointsInsideTheHouse2.txt");
        //File tests = new File("testsPointsInsideTheHouse.txt");
        File output = new File("outputInTheHouse.txt");
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

        boolean inRoof = isInRoof(x, y);
        boolean inLeftWall = (y >= 8.5 && y <= 13.5) && (x >= 12.5 && x <= 17.5);
        boolean inRightWall = (y >= 8.5 && y <= 13.5) && (x >= 20 && x <= 22.5);

        return inRoof || inLeftWall || inRightWall;
    }

    private static boolean isInRoof(double x, double y) {
        double aX = 12.5;
        double aY = 8.5;
        double topX = 17.5;
        double topY = 3.5;
        double cX = 22.5;
        double cY = 8.5;

        //http://stackoverflow.com/questions/2049582/how-to-determine-a-point-in-a-triangle
        boolean isUnderLeftSlope = (sign(x, y, aX, aY, topX, topY) < 0);
        boolean isUnderRigthSlope = (sign(x, y, topX, topY, cX, cY) < 0);
        boolean isAboveHorizontalSlope = (sign(x, y, cX, cY, aX, aY) < 0);

        return ((isUnderLeftSlope == isUnderRigthSlope) && (isUnderRigthSlope == isAboveHorizontalSlope));
    }

    private static double sign(double x, double y, double p2X, double p2Y, double p3X, double p3Y) {
        return (x - p3X) * (p2Y - p3Y) - (p2X - p3X) * (y - p3Y);
    }
}
