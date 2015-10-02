import java.util.Scanner;

public class TargetPractise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        char[][] matrix = new char[rows][cols];
        scanner.nextLine();
        String word = scanner.nextLine();
        int wordLenght = word.length();
        int wordIndex = 0;
        boolean isGoingRigth = false;
        for (int row = rows - 1; row >= 0; row--) {

            if (!isGoingRigth) {
                for (int col = cols - 1; col >= 0; col--) {
                    matrix[row][col] = word.charAt(wordIndex % wordLenght);
                    wordIndex++;
                }
            }
            else {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = word.charAt(wordIndex % wordLenght);
                    wordIndex++;
                }
            }

            isGoingRigth = !isGoingRigth;
        }
        int shootRow = scanner.nextInt();
        int shootCol = scanner.nextInt();
        int shootRadius = scanner.nextInt();

        // printMatrix(rows, matrix);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean inCircle = ((row - shootRow) * (row - shootRow) + (col - shootCol) * (col - shootCol) <= shootRadius * shootRadius);
                if (inCircle) {
                    matrix[row][col] = ' ';
                }
            }
        }
        //printMatrix(rows, matrix);

        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                int rowNotEmptyChar = row;
                while (rowNotEmptyChar > 0 && matrix[rowNotEmptyChar][col] == ' ') {
                    rowNotEmptyChar--;
                }
                if (rowNotEmptyChar != row) {
                    matrix[row][col] = matrix[rowNotEmptyChar][col];
                    matrix[rowNotEmptyChar][col] = ' ';
                }
            }
        }

        printMatrix(rows, matrix);
    }

    private static void printMatrix(int rows, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            System.out.println(matrix[row]);
        }
    }

}
