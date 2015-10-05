import java.util.ArrayList;
import java.util.Scanner;

public class DragonTrap {
    private static ArrayList<int[]> charPositions;
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        char [][] initial = new char[n][];

        matrix = new char[n][];

        for (int i = 0; i < matrix.length; i++) {
            String input = scn.nextLine();
            matrix[i] = input.toCharArray();
            initial[i] = input.toCharArray();
        }

        String command = scn.nextLine();

        while (!command.equals("End")) {
            String[] commandArgs = command.split("[^\\d-]+");
            int row = Integer.parseInt(commandArgs[1]);
            int col = Integer.parseInt(commandArgs[2]);
            int radius = Integer.parseInt(commandArgs[3]);
            int rotations = Integer.parseInt(commandArgs[4]);

            int upperSide = row - radius;
            int lowerSide =  row + radius;
            int rightSide = col + radius;
            int leftSide = col - radius;

            String perimeter = getPerimeter(upperSide, lowerSide, rightSide, leftSide);
            if (perimeter.length() > 0 && rotations != 0) {
                perimeter = rotatePerimeter(perimeter, rotations);
                for (int i = 0; i < perimeter.length(); i++) {
                    char currentChar = perimeter.charAt(i);
                    int currentRow = charPositions.get(i)[0];
                    int currentCol = charPositions.get(i)[1];
                    matrix[currentRow][currentCol] = currentChar;
                }
            }

            command = scn.nextLine();
        }

        int changed = 0;

        for (int i = 0; i < initial.length; i++) {
            for (int j = 0; j < initial[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (initial[i][j] != matrix[i][j])
                    changed++;
            }
            System.out.println();
        }
        System.out.println("Symbols changed: " + changed);
    }

    private static String getPerimeter(int upperSide, int lowerSide, int rightSide, int leftSide) {
        charPositions = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (upperSide >= 0 && upperSide < matrix.length) {
            int minCol = Math.max(0, leftSide);
            int maxCol = Math.min(matrix[0].length - 1, rightSide);
            for (int i = minCol; i <= maxCol; i++) {
                sb.append(matrix[upperSide][i]);
                charPositions.add(new int[] {upperSide, i});
            }

            upperSide++;
        }

        if (rightSide < matrix[0].length && rightSide >= 0) {
            int minRow = Math.max(0, upperSide);
            int maxRow = Math.min(matrix.length - 1, lowerSide);
            for (int i = minRow; i <= maxRow; i++) {
                sb.append(matrix[i][rightSide]);
                charPositions.add(new int[] {i, rightSide});
            }

            rightSide--;
        }

        if (lowerSide >= 0 && lowerSide < matrix.length) {
            int maxCol = Math.min(matrix[0].length - 1, rightSide);
            int minCol = Math.max(0, leftSide);
            for (int i = maxCol; i >= minCol; i--) {
                sb.append(matrix[lowerSide][i]);
                charPositions.add(new int[] {lowerSide, i});
            }

            lowerSide--;
        }

        if (leftSide >= 0 && leftSide < matrix[0].length) {
            int maxRow = Math.min(matrix.length - 1, lowerSide);
            int minRow = Math.max(0, upperSide);
            for (int i = maxRow; i >= minRow; i--) {
                sb.append(matrix[i][leftSide]);
                charPositions.add(new int[] {i, leftSide});
            }
        }

        return sb.toString();
    }

    private static String rotatePerimeter(String str, int rotations) {
        if (rotations < 0) {
            rotations =  Math.abs(rotations) % str.length();
            return str.substring(rotations) + str.substring(0, rotations);
        }

        rotations %= str.length();
        int endIndex = str.length() - rotations;
        return str.substring(endIndex) + str.substring(0, endIndex);
    }
}