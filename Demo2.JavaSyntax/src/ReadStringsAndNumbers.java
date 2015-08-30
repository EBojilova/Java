import java.util.Scanner;

public class ReadStringsAndNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstWord = input.next("\\w+");
        System.out.println("firstWord = " + firstWord);
        String secondWord = input.next("[0-9]?\\w+");
        System.out.println("secondWord = " + secondWord);
        int numInt = input.nextInt();
        System.out.println("numInt = " + numInt);
        double numDouble1 = input.nextDouble();
        System.out.println("numDouble1 = " + numDouble1);
        double numDouble2 = input.nextDouble();
        System.out.println("numDouble2 = " + numDouble2);
        input.nextLine(); // Skip to the line end
        String str = input.nextLine();
        System.out.println("str = " + str);
    }
}
