import java.util.ArrayList;
import java.util.Scanner;

public class ReadingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int firstNum = input.nextInt();
//        System.out.println(firstNum);
//        int secondNum = input.nextInt();
//        System.out.println(secondNum);
        ArrayList<Integer> nums = new ArrayList<Integer>();
//        while (input.hasNextInt()) {
//            nums.add(input.nextInt());
//        }
//        System.out.println(nums);
//        nums.clear();
//        input.nextLine();
//        input.nextLine();
        while (!input.hasNext("END")) {
            if (input.hasNextInt()) {
                nums.add(input.nextInt());
            }
            else {
                // ako ne dademe else zaciklia mejdu while i if
                input.next();
            }
        }
        System.out.println(nums);
    }
}
