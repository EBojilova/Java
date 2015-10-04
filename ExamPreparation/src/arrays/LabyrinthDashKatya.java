package arrays;

import java.util.Scanner;

public class LabyrinthDashKatya {

    private static int lives = 3;

    private static int movesMade = 0;

    private static int row = 0;

    private static int col = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        char[][] labyrinth = new char[N][];

        for (int i = 0; i < N; i++) {
            labyrinth[i] = scanner.nextLine()
                                  .toCharArray();
        }

        char[] commands = scanner.nextLine()
                                 .toCharArray();

        for (Character direction : commands) {

            int previousRow = row;
            int previousCol = col;
            switch (direction) {
                case '<':
                    col--;
                    break;
                case '>':
                    col++;
                    break;
                case 'v':
                    row++;
                    break;
                case '^':
                    row--;
                    break;
            }
            if (!checkIfCellIsInsideMatrix(row, col, labyrinth) || labyrinth[row][col] == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                movesMade++;
                break;
            }
            else {
                Character currentCell = labyrinth[row][col];
                switch (currentCell) {
                    case '_':
                    case '|':
                        System.out.println("Bumped a wall.");
                        row = previousRow;
                        col = previousCol;
                        break;
                    case '@':
                    case '#':
                    case '*':
                        System.out.printf("Ouch! That hurt! Lives left: %d\n", --lives);
                        movesMade++;
                        if (lives <= 0) {
                            System.out.println("No lives left! Game Over!");
                        }
                        break;
                    case '$':
                        lives++;
                        movesMade++;
                        labyrinth[row][col] = '.';
                        System.out.printf("Awesome! Lives left: %d\n", lives);
                        break;
                    default:
                        movesMade++;
                        System.out.println("Made a move!");
                        break;
                }

                if (lives <= 0) {
                    break;
                }
            }
        }
        System.out.printf("Total moves made: %d\n", movesMade);
    }

    private static boolean checkIfCellIsInsideMatrix(int row, int col, char[][] matrix) {
        boolean isInsideMatrix =
                0 <= row
                        && row < matrix.length
                        && 0 <= col
                        && col < matrix[row].length;

        return isInsideMatrix;
    }
}
