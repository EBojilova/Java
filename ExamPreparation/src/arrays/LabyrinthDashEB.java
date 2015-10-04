package arrays;

import java.util.Scanner;

public class LabyrinthDashEB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        String walls = "_|";
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine()
                               .toCharArray();
        }
        String moves = scanner.nextLine();

        int row = 0;
        int col = 0;
        int lives = 3;
        int movements = 0;

        for (int i = 0; i < moves.length(); i++) {
            movements++;
            char currenChar = moves.charAt(i);

            int rowChange = 0;
            int colChange = 0;
            if (currenChar == '<') {
                colChange = -1;
            }
            else if (currenChar == '>') {
                colChange = 1;
            }
            else if (currenChar == '^') {
                rowChange = -1;
            }
            else if (currenChar == 'v') {
                rowChange = 1;
            }
            row += rowChange;
            col += colChange;

            boolean validRow = row >= 0 && row < rows;
            boolean validCol = col >= 0 && col < matrix[row].length;
            if (!validRow || !validCol || matrix[row][col] == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                break;
            }

            char currentCell=matrix[row][col];
            if (currentCell== '@' || currentCell=='#' || currentCell== '*') {
                lives--;
                System.out.printf("Ouch! That hurt! Lives left: %d", lives)
                          .println();
                if (lives == 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }
            }
            else if (currentCell== '_' || currentCell=='|') {
                row -= rowChange;
                col -= colChange;
                movements--;
                System.out.println("Bumped a wall.");
            }
            else if (currentCell == '$') {
                lives++;
                matrix[row][col] = '.';
                System.out.printf("Awesome! Lives left: %d", lives)
                          .println();
            }
            else if (matrix[row][col] == '.') {
                System.out.println("Made a move!");
            }

        }
        System.out.printf("Total moves made: %d", movements)
                  .println();

    }

}
