package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LegoBlocksEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] leftPart = new String[n][];
        int count = 0;
        for (int i = 0; i < n; i++) {
            leftPart[i] = scanner.nextLine()
                                 .trim()
                                 .split("\\W+");
            count += leftPart[i].length;
        }

        boolean fit = true;
        String[][] rightPart = new String[n][];
        for (int i = 0; i < n; i++) {
            rightPart[i] = scanner.nextLine()
                                  .trim()
                                  .split("\\W+");
            int checkLenght = leftPart[0].length + rightPart[0].length;
            if (leftPart[i].length + rightPart[i].length != checkLenght) {
                fit = false;
            }
            count += rightPart[i].length;
        }

        printResult(n, leftPart, count, fit, rightPart);
    }

    private static void printResult(int n, String[][] leftPart, int count, boolean fit, String[][] rightPart) {
        if (fit) {
            for (int i = 0; i < n; i++) {
                ArrayList<String> leftArray = new ArrayList<>(Arrays.asList(leftPart[i]));
                ArrayList<String> rightArray = new ArrayList<>(Arrays.asList(rightPart[i]));
                Collections.reverse(rightArray);
                leftArray.addAll(rightArray);
                System.out.println(leftArray);
            }
        }
        else {
            System.out.printf("The total number of cells is: %d", count)
                      .println();
        }
    }
}
