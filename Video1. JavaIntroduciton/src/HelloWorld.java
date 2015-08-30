import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Elena on 26.8.2015 ã..
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner scanner= new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        System.out.println(a+b);

        ArrayList<Integer> numbers= new ArrayList<Integer>();

        ///Niama da raboti, tai kato v Java e ostarial nachina na inicializacia i triabva da e s pointeri(vij otgore), nedostataka e che zaema oste 32 bita otgore
        ///ArrayList<int> numbers= new ArrayList<int>();
    }
}
