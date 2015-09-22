import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LegoBlocks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] leftPart = new String[n][];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            leftPart[i] = scanner.nextLine().split("\\W+");
            count += leftPart[i].length;
        }

        int length = 0;
        boolean fit = true;
        String[][] rightPart = new String[n][];
        for (int i = 0; i < n; i++) {
            rightPart[i] = scanner.nextLine().split("\\W+");
            int checkLenght = leftPart[0].length + rightPart[0].length;
            if (leftPart[i].length + rightPart[i].length != checkLenght) {
                fit = false;
            }
        }

        if (fit){
            for (int i = 0; i <n ; i++) {
                String left= String.join(", ", leftPart[i]);
                String right= String.join(", "), Collections.reverse(Arrays.asList(rightPart[i]))
            }
        }
    }
}
