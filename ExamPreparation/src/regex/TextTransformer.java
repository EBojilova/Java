package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String specials = "$%&'";
        int[] weights = {1, 2, 3, 4};
        String input;
        String text = "";
        while (!(input = scanner.nextLine()).equals("burp")) {
            text += input;
        }
        input = input.replace("\\s{2,}", " ");
        Matcher matcher = Pattern.compile("([$%&'])([^$%&']+)\\1")
                                 .matcher(text);
        String result = "";
        while (matcher.find()) {
            char character = matcher.group(1)
                                    .charAt(0);
            String word = matcher.group(2);
            int indexWeigth = specials.indexOf(character);
            int weight = weights[indexWeigth];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    character = (char) (word.charAt(i) + weight);
                }
                else {
                    character = (char) (word.charAt(i) - weight);
                }
                result += character;
            }
            result += " ";
        }
        System.out.println(result);

    }
}

