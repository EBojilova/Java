import java.util.Arrays;
import java.util.Scanner;

public class StuckNumbersEB {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        input.nextLine();
        String numbersStr = input.nextLine();

        // functional programing is more slow than iteration
        String[] nums = numbersStr.split("[^0-9-]+");

        int count = 0;
        int countLoops = 0;
        int numsLength = nums.length;

        for (int num1 = 0; num1 < numsLength; num1++) {
            for (int num2 = 0; num2 < numsLength; num2++) {
                if (num1 == num2) {
                    continue;
                }
                for (int num3 = 0; num3 < numsLength; num3++) {
                    if (num3 == num1 || num3 == num2) {
                        continue;
                    }
                    for (int num4 = 0; num4 < numsLength; num4++) {
                        String a = nums[num1];
                        String b = nums[num2];
                        String c = nums[num3];
                        String d = nums[num4];
                        if (a.equals(b) || a.equals(c) || a.equals(d) ||
                                b.equals(c) || b.equals(d) || c.equals(d)) {
                            continue;
                        }
                        // 4 tests do not pass in Judge, because of time limit- String.format is too slow
//                        String first = String.format("%s%s", a, b);
//                        String second = String.format("%s%s", c, d);
                        String first = a + b;
                        String second = c + d;
                        if (first.equals(second)) {
                            System.out.printf("%s|%s==%s|%s",
                                    a, b, c, d).println();
                            count++;
                        }
                        countLoops++;
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("No");
        }
//        System.out.println(countLoops);
    }
}
