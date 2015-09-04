import java.util.ArrayList;
import java.util.Scanner;

public class _01SymmetricNumbersInRange {

    private static final int START = 0;

    private static final int END = 999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter start >= %d and end <= %d number to find all symmetrical numbers between them:", START, END).println();
        int start = Integer.parseInt(scanner.next());
        int end = Integer.parseInt(scanner.next());

        if (start < START || start > end || end > END) {
            System.out.printf("Range should be [%d...%d]. Please enter again start and end number. ", START, END);
            return;
        }

        ArrayList<Integer> symetricalNumbers = new ArrayList<Integer>();

        for (int i = start; i <= end; i++) {
            if (i / 10 == 0) {
                symetricalNumbers.add(i);
            }
            if (i / 100 == 0) {
                if (i % 10 == i / 10) {
                    symetricalNumbers.add(i);
                }
            }
            if (i % 10 == i / 100) {
                symetricalNumbers.add(i);
            }
        }

        if (symetricalNumbers.size() > 0) {
            System.out.println(symetricalNumbers);
        }
        else {
            System.out.printf("There are no symmetric numbers in the range [%d...%d].", start, end).println();
        }
    }
}
