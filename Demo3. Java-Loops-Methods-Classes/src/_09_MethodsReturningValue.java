

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _09_MethodsReturningValue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter triangle width: ");
        double width = input.nextDouble();
        System.out.print("Enter triangle height: ");
        double height = input.nextDouble();
        System.out.println("Area = " + calcTriangleArea(width, height));

        // http://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));

        addTwo(nums);

        System.out.println(nums);

        ArrayList<ArrayList<ArrayList<Integer>>> numbers = new ArrayList<>();

        addNumbersToTrippleList(numbers);

        System.out.println(numbers);
    }

    static double calcTriangleArea(double width, double height) {
        return width * height / 2;
    }

    static void addTwo(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, nums.get(i) + 2);
        }
    }

    static void addNumbersToTrippleList(ArrayList<ArrayList<ArrayList<Integer>>> numbers) {
        int rows = 3, cols = 3, heights = 3;
        int counter=1;
        for (int row = 0; row < rows; row++) {
            numbers.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                numbers.get(row).add(new ArrayList<>());
                for (int height = 0; height < heights; height++) {
                    numbers.get(row).get(col).add(counter);
                    counter++;
                }
            }
        }
    }
}
