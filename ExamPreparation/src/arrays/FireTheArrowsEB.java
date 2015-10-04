package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FireTheArrowsEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        // to make it with chars- see FireTheArrow
        String[][] matrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine()
                               .split("");
        }
        int cols = matrix[0].length;
        boolean hasMoved = true;
        while (hasMoved) {
            hasMoved=false;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (!matrix[row][col].equals("o")) {
                        int rowChange = 0;
                        int colChange = 0;
                        if (matrix[row][col].equals("<")) {
                            colChange = -1;
                        }
                        else if (matrix[row][col].equals(">")) {
                            colChange = 1;
                        }
                        else if (matrix[row][col].equals("^")) {
                            rowChange = -1;
                        }
                        else if (matrix[row][col].equals("v")) {
                            rowChange = 1;
                        }
                        hasMoved = isArrowMoved(matrix, rows, cols, hasMoved, row, col, rowChange, colChange);
                    }
                }
            }
        }
        printMatrix(matrix, rows);
    }

    private static void printMatrix(String[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            Arrays.stream(matrix[row])
                  .forEach(element -> System.out.print(element));
            System.out.println();
        }
    }

    private static boolean isArrowMoved(String[][] matrix, int rows, int cols, boolean hasMoved, int row, int col, int rowChange, int colChange) {
        boolean inMatrixRow = (row + rowChange) >= 0 && (row + rowChange) < rows;
        boolean inMatrixCol = (col + colChange) >= 0 && (col + colChange) < cols;
        if (inMatrixCol && inMatrixRow) {
            boolean isNextCellFree = matrix[row + rowChange][col + colChange].equals("o");
            if (isNextCellFree) {
                matrix[row + rowChange][col + colChange] = matrix[row][col];
                matrix[row][col] = "o";
                hasMoved = true;
            }
        }
        return hasMoved;
    }
}
