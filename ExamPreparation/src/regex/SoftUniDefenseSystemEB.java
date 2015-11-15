package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefenseSystemEB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        StringBuilder sb= new StringBuilder();
        while (!(input = scanner.nextLine()).equals("OK KoftiShans")) {
            sb .append(input);
        }
        String text = sb.toString();
        Matcher matcher = Pattern.compile(".*?([A-Z][a-z]+).*?([A-Z][a-z]+[A-Z]).*?(\\d+)L")
                                 .matcher(text);
        int totalLiters=0;
        while (matcher.find()) {
           String name= matcher.group(1);
            String alchohol= matcher.group(2).toLowerCase();
            int liters= Integer.parseInt(matcher.group(3));
            System.out.printf("%s brought %d liters of %s!", name, liters, alchohol).println();
            totalLiters+=liters;
        }
        double totalLitersSoftuni=totalLiters*0.001;
        System.out.printf("%.3f softuni liters", totalLitersSoftuni);
    }
}
