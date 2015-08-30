import java.util.Scanner;
import java.util.Arrays;

public class SortArrayOfStrings {
    public static void main(String[] args) {
        String[] stringsToBeSorted = inputTheListOfStringsToBeSorted();
        selectionSort(stringsToBeSorted);
        System.out.println(Arrays.toString(stringsToBeSorted));
        String newLine= System.getProperty("line.separator"); // Equal to Environment.Newline in C#
        System.out.println(String.join(newLine, stringsToBeSorted));
    }

    private static String[] inputTheListOfStringsToBeSorted() {
        System.out.print("Enter the number of the strings to be sorted: ");
        Scanner input = new Scanner(System.in);
        //scanner.nextInt() will only take integer value entered and not the \n(When we hit enter after entering the integer). So this \n is still in the buffer, so when we use scanner.nextLine() after sacn.nextInt() it takes or stores \n.That's why nextLine() was returning empty line.
        //int numberOfStrings = input.nextInt();
        //input.nextLine();
        int numberOfStrings = Integer.parseInt(input.nextLine());
        String[] stringsToBeSorted = new String[numberOfStrings];
        for (int i = 0;
             i < numberOfStrings;
             i++) {
            stringsToBeSorted[i] = input.nextLine();
        }
        return stringsToBeSorted;
    }

    private static void selectionSort(String[] stringToBeSorted) {
        int i, j, minIndex;
        String temporary;
        int n = stringToBeSorted.length;
        for (i = 0;
             i < n - 1;
             i++) {
            minIndex = i;
            for (j = i + 1;
                 j < n;
                 j++) {
                if (stringToBeSorted[j].compareTo(stringToBeSorted[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temporary = stringToBeSorted[i];
                stringToBeSorted[i] = stringToBeSorted[minIndex];
                stringToBeSorted[minIndex] = temporary;
            }
        }
    }
}
