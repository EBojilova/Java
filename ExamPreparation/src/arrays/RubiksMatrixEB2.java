package arrays;

import java.util.Scanner;

public class RubiksMatrixEB2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        scanner.nextLine();

        // fill
        fillTheMatrix(rows, cols, matrix);
//        printMatrix(rows, cols, matrix);

        // shufflle
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = scanner.nextLine()
                                       .split("\\W+");
            int rowColumn = Integer.parseInt(commands[0]);
            String command = commands[1];
            int rotations = Integer.parseInt(commands[2]);
            shuffleMatrix(rows, cols, matrix, rowColumn, command, rotations);
//            printMatrix(rows, cols, matrix);
        }

        //rearrange
        rearrangeShuffleMatrixAsIntial(rows, cols, matrix);
//        printMatrix(rows, cols, matrix);
    }

    private static void fillTheMatrix(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = row * rows + col + 1;
            }
        }
    }

    private static void shuffleMatrix(int rows, int cols, int[][] matrix, int rowColumn, String command, int rotations) {
        if (command.equals("up") || command.equals("down")) {
            int[] currentCol = new int[rows];
            for (int row = 0; row < rows; row++) {
                currentCol[row] = matrix[row][rowColumn];
            }
            if (command.equals("up")) {
                rotateArrayLeftOrUp(rotations, currentCol);
            }
            if (command.equals("down")) {
                rotateArrayRigthOrDown(rotations, currentCol);
            }
            for (int row = 0; row < rows; row++) {
                matrix[row][rowColumn] = currentCol[row];
            }
        }
        if (command.equals("left") || command.equals("right")) {
            int[] currentRow = new int[cols];
            for (int col = 0; col < cols; col++) {
                currentRow[col] = matrix[rowColumn][col];
            }
            if (command.equals("right")) {
                rotateArrayRigthOrDown(rotations, currentRow);

            }
            if (command.equals("left")) {
                rotateArrayLeftOrUp(rotations, currentRow);
            }
            for (int col = 0; col < cols; col++) {
                matrix[rowColumn][col] = currentRow[col];
            }
        }
    }

    private static void rotateArrayRigthOrDown(int rotations, int[] numbers) {
        int numbersLength = numbers.length;
        rotations = rotations % numbersLength;
        for (int j = 0; j < rotations; j++) {
            int last = numbers[numbersLength - 1];
            for (int i = numbersLength - 1; i > 0; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = last;
        }
    }

    private static void rotateArrayLeftOrUp(int rotations, int[] numbers) {
        int numbersLength = numbers.length;
        rotations = rotations % numbersLength;
        for (int j = 0; j < rotations; j++) {
            int first = numbers[0];
            for (int i = 0; i < numbersLength - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[numbersLength - 1] = first;
        }
    }

    private static void rearrangeShuffleMatrixAsIntial(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int initialNumber = row * rows + col + 1;
                int shuffledNumber = matrix[row][col];
                if (initialNumber == shuffledNumber) {
                    System.out.println("No swap required");
                }
                else {
                    swapCells(rows, cols, matrix, row, col, initialNumber, shuffledNumber);
                }
            }
        }
    }

    private static void swapCells(int rows, int cols, int[][] matrix, int row, int col, int initialNumber, int shuffledNumber) {
        for (int shuffledRow = 0; shuffledRow < rows; shuffledRow++) {
            for (int shuffledCol = 0; shuffledCol < cols; shuffledCol++) {
                if (initialNumber == matrix[shuffledRow][shuffledCol]) {
                    matrix[row][col] = initialNumber;
                    matrix[shuffledRow][shuffledCol] = shuffledNumber;
                    System.out.printf("Swap (%d, %d) with (%d, %d)", row, col, shuffledRow, shuffledCol)
                              .println();
                    return;
                }
            }
        }
    }

    private static void printMatrix(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%3d ", matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

