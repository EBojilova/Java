package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class DragonTrapEB2 {

    public static int rows = 0;

    public static int cols = 0;

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        char[][] notRotatedMatrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();
            notRotatedMatrix[i] = input.toCharArray();
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

            ArrayList<Integer[]> charactersPostions = new ArrayList<>();
            ArrayList<Character> characters = getCharacters(matrix, startRow, startCol, endRow, endCol, charactersPostions);

            if (characters.size() == 0 || rotations == 0) {
                continue;
            }

            characters = rotateCharacters(rotations, characters);
            rotateMatrix(matrix, characters, charactersPostions);
        }
        findCountOfChangedCells(matrix, notRotatedMatrix);
        printResult(matrix);
    }

    private static void findCountOfChangedCells(char[][] matrix, char[][] notRotatedMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != notRotatedMatrix[row][col]) {
                    count++;
                }
            }
        }
    }

    private static ArrayList<Character> rotateCharacters(int rotations, ArrayList<Character> characters) {
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
        return characters;
    }

    private static void rotateMatrix(char[][] matrix, ArrayList<Character> characters, ArrayList<Integer[]> charactersPostions) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < charactersPostions.size(); i++) {
            row = charactersPostions.get(i)[0];
            col = charactersPostions.get(i)[1];
            matrix[row][col] = characters.get(i);
        }
    }

    private static ArrayList<Character> getCharacters(char[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer[]> charactersPostions) {
        int row = startRow;
        int col = startCol;
        ArrayList<Character> characters = new ArrayList<>();
        while (row < endRow) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
                charactersPostions.add(new Integer[]{row, col});
            }
            row++;
        }
        while (col < endCol) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
                charactersPostions.add(new Integer[]{row, col});
            }
            col++;
        }
        while (row > startRow) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
                charactersPostions.add(new Integer[]{row, col});
            }
            row--;
        }
        while (col > startCol) {
            if (isInMatrix(row, col)) {
                characters.add(matrix[row][col]);
                charactersPostions.add(new Integer[]{row, col});
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
