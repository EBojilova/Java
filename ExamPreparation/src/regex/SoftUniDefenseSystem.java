package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefenseSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int softuniLiters = 0;
        String input;
        Matcher matcher;
        while (!(input = scanner.nextLine()).equals("OK KoftiShans")) {
            matcher = Pattern.compile(".*?([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?([1-9]\\d*)L")
                              .matcher(input);
            while (matcher.find()) {
                String guestName = matcher.group(1);
                String alcoholName = matcher.group(2)
                                            .toLowerCase();
                int alcoholLiters = Integer.parseInt(matcher.group(3));
                System.out.printf("%s brought %d liters of %s!", guestName, alcoholLiters, alcoholName)
                          .println();
                softuniLiters += alcoholLiters;
            }
        }
        // 1 normal liter is 0.001 softuni litters.
        double totalLitersSoftuni = softuniLiters * 0.001;
        System.out.printf("%.3f softuni liters", totalLitersSoftuni);
    }
}
