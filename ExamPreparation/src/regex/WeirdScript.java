package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int keyNumber = Integer.parseInt(scn.nextLine());
        // because we will add to 'a', edn we will switch ot 'A' after 26 letters
        keyNumber = keyNumber - 1;
        // upper and lower case are changed evry 26 numbers
        int charCode = keyNumber % 26;

        // odd numbers are lower case, even numbers are upper case
        char keyLetter = (keyNumber / 26) % 2 == 0
                ? (char) ('a' + charCode)
                : Character.toUpperCase((char) ('a' + charCode));

        String key = "" + keyLetter + keyLetter;
        StringBuilder sb = new StringBuilder();

        String line = scn.nextLine();
        while (!line.equals("End")) {
            sb.append(line);
            line = scn.nextLine();
        }

        String message = sb.toString();
        String pattern = String.format("%1$s(.*?\\n*.*?)%1$s", key);
        //String pattern = key + "(.*?)" + key;
//        Pattern pat = Pattern.compile(pattern);
//        Matcher match = pat.matcher(message);
        Matcher matcher = Pattern.compile(pattern)
                                 .matcher(message);
        while (matcher.find()) {
            if (matcher.group(1)
                       .length() > 0) {
                System.out.println(matcher.group(1));
            }
        }
    }
}