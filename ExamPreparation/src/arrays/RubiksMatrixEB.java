package arrays;

import java.util.Scanner;

public class RubiksMatrixEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] initialMatrix = new int[rows][cols];
        int[][] shufflledMatrix = new int[rows][cols];
        scanner.nextLine();

        // fill the matrix
        int number = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                initialMatrix[row][col] = number;
                shufflledMatrix[row][col] = number;
                number++;
            }
        }

//        printMatrix(rows, cols, shufflledMatrix);

        // shufflle matrix
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine()
                                       .split("\\W+");
            int rowColumn = Integer.parseInt(commands[0]);
            String command = commands[1];
            int rotations = Integer.parseInt(commands[2]);
            if (command.equals("up") || command.equals("down")) {
                rotations = rotations % rows;
                int[] currentCol = new int[rows];
                for (int row = 0; row < rows; row++) {
                    currentCol[row] = shufflledMatrix[row][rowColumn];
                }

                for (int j = 0; j < rotations; j++) {
                    if (command.equals("up")) {
                        int first = currentCol[0];
                        for (int row = 0; row < rows - 1; row++) {
                            currentCol[row] = currentCol[row + 1];
                        }
                        currentCol[rows - 1] = first;
                    }
                    if (command.equals("down")) {
                        int last = currentCol[rows - 1];
                        for (int row = rows - 2; row >= 0; row--) {
                            currentCol[row + 1] = currentCol[row];
                        }
                        currentCol[0] = last;
                    }
                }
                for (int row = 0; row < rows; row++) {
                    shufflledMatrix[row][rowColumn] = currentCol[row];
                }
            }
            if (command.equals("left") || command.equals("right")) {
                rotations = rotations % cols;
                int[] currentRow = new int[cols];
                for (int col = 0; col < cols; col++) {
                    currentRow[col] = shufflledMatrix[rowColumn][col];
                }

                for (int j = 0; j < rotations; j++) {
                    if (command.equals("right")) {
                        int last = currentRow[cols - 1];
                        for (int col = cols - 2; col >= 0; col--) {
                            currentRow[col + 1] = currentRow[col];
                        }
                        currentRow[0] = last;

                    }
                    if (command.equals("left")) {
                        int first = currentRow[0];
                        for (int col = 0; col < cols - 1; col++) {
                            currentRow[col] = currentRow[col + 1];
                        }
                        currentRow[cols - 1] = first;
                    }
                }
                for (int col = 0; col < cols; col++) {
                    shufflledMatrix[rowColumn][col] = currentRow[col];
                }
            }
//            printMatrix(rows, cols, shufflledMatrix);
        }

        // rearrange back shuffled matrix as the initial
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int initialNumber = initialMatrix[row][col];
                int shuffledNumber = shufflledMatrix[row][col];
                if (initialNumber == shuffledNumber) {
                    System.out.println("No swap required");
                }
                else {
                    SwapCells(rows, cols, shufflledMatrix, row, col, initialNumber, shuffledNumber);
                }
            }
        }

//        printMatrix(rows, cols, shufflledMatrix);
    }

    private static void printMatrix(int rows, int cols, int[][] shufflledMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%3d ", shufflledMatrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void SwapCells(int rows, int cols, int[][] shufflledMatrix, int row, int col, int initialNumber, int shuffledNumber) {
        for (int wrongRow = 0; wrongRow < rows; wrongRow++) {
            for (int wrongCol = 0; wrongCol < cols; wrongCol++) {
                if (initialNumber == shufflledMatrix[wrongRow][wrongCol]) {
                    shufflledMatrix[row][col] = initialNumber;
                    shufflledMatrix[wrongRow][wrongCol] = shuffledNumber;
                    System.out.printf("Swap (%d, %d) with (%d, %d)", row, col, wrongRow, wrongCol)
                              .println();
                }
            }
        }
    }

}
