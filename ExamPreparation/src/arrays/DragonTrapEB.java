package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class DragonTrapEB {

    public static int rows = 0;

    public static int cols = 0;

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine()
                               .toCharArray();
        }
        cols = matrix[0].length;
        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] commandData = input.replace("(", "")
                                        .replace(")", "")
                                        .split("[^\\d-]+");
            int dragonRow = Integer.parseInt(commandData[0]);
            int dragonCol = Integer.parseInt(commandData[1]);
            int radius = Integer.parseInt(commandData[2]);
            int rotations = Integer.parseInt(commandData[3]);
//            "({row} {column}) {radius} {rotations}"
//            (1 1) 1 1
//            If the number of rotations is positive, rotate the characters clockwise, otherwise rotate them counterclockwise.

            int startRow = dragonRow - radius;
            int startCol = dragonCol - radius;
            int endRow = dragonRow + radius;
            int endCol = dragonCol + radius;

            ArrayList<Character> characters = getCharacters(matrix, startRow, startCol, endRow, endCol);

            if (characters.size() == 0 || rotations==0) {
                printResult(matrix);
                return;
            }

            if (rotations < 0) {
                rotations = Math.abs(rotations) % characters.size();
                ArrayList<Character> part = new ArrayList(characters.subList(0, characters.size() - rotations));
                characters = new ArrayList(characters.subList(characters.size() - rotations, characters.size()));
                characters.addAll(part);
            }
            else {
                rotations = rotations % characters.size();
                ArrayList<Character> part = new ArrayList(characters.subList(0, rotations));
                characters = new ArrayList(characters.subList(rotations, characters.size()));
                characters.addAll(part);
            }
            rotateMatrix(matrix, startRow, startCol, endRow, endCol, characters);
        }
        printResult(matrix);
    }

    private static void rotateMatrix(char[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Character> characters) {
        int row = startRow;
        int col = startCol;
        int i = 0;
        while (row < endRow) {
            if (isInMatrix(row, col)) {
                if (matrix[row][col] != characters.get(i)) {
                    count++;
                    matrix[row][col] = characters.get(i);
                }
                i++;
            }
            row++;
        }
        while (col < endCol) {
            if (isInMatrix(row, col)) {
                if (matrix[row][col] != characters.get(i)) {
                    count++;
                    matrix[row][col] = characters.get(i);
                }
                i++;
            }
            col++;
        }
        while (row > startRow) {
            if (isInMatrix(row, col)) {
                if (matrix[row][col] != characters.get(i)) {
                    count++;
                    matrix[row][col] = characters.get(i);
                }
                i++;
            }
            row--;
        }
        while (col > startCol) {
            if (isInMatrix(row, col)) {
                if (matrix[row][col] != characters.get(i)) {
                    count++;
                    matrix[row][col] = characters.get(i);
                }
                i++;
            }
            col--;
        }
    }

    private static ArrayList<Character> getCharacters(char[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int row = startRow;
        int col = startCol;
        ArrayList<Character> characters = new ArrayList<>();
        while (row < endRow) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
            }
            row++;
        }
        while (col < endCol) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
            }
            col++;
        }
        while (row > startRow) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
            }
            row--;
        }
        while (col > startCol) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
            }
            col--;
        }
        return characters;
    }

    private static void printResult(char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            System.out.println(matrix[row]);
        }
        System.out.printf("Symbols changed: %d", count)
                  .println();
    }

    private static boolean isInMatrix(int row, int col) {
        return 0 <= row && row < rows &&
                0 <= col && col < cols;
    }
}
