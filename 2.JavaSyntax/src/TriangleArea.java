import java.util.Scanner;

public class TriangleArea {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner input = new Scanner(System.in);
        Integer[] coordinates = new Integer[6];
        for (int i = 0; i < 6; i++) {
            coordinates[i] = input.nextInt();
        }
        triangle.setCoordinates(coordinates);
        triangle.printArea();
    }
}
