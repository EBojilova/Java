import java.util.ArrayList;
import java.util.Scanner;

public class MirrorNumbersEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] inputs = scanner.nextLine()
                                 .split("\\W+");
        ArrayList<String> mirros = new ArrayList<>();
        int count = 0;
        int n = inputs.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String first = inputs[i];
                String secondReversed = new StringBuilder(inputs[j]).reverse()
                                                            .toString();
                String second= inputs[j];
                if (first.equals(secondReversed)) {
                    mirros.add(String.format("%s<!>%s", first, second));
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("No");
        }
        else {
            System.out.printf(String.join(System.lineSeparator(), mirros))
                      .println();
        }
    }
}
