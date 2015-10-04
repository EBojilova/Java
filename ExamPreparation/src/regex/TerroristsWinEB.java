package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWinEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Matcher matcher = Pattern.compile("\\|(.*?)\\|")
                                 .matcher(text);
        char[] result = text.toCharArray();
        int matchIndex=0;
        while (matcher.find()) {
            String bomb = matcher.group(1);
            int bombPower = getBombPower(bomb);
            matchIndex=text.indexOf(matcher.group(), matchIndex);
            int startIndexOfDestoys = matchIndex - bombPower;
            int endIndexOfDestoys = startIndexOfDestoys + bombPower + matcher.group()
                                                                             .length() + bombPower;
            startIndexOfDestoys = startIndexOfDestoys >= 0 ? startIndexOfDestoys : 0;
            endIndexOfDestoys = endIndexOfDestoys < text.length() ? endIndexOfDestoys : text.length();
            for (int i = startIndexOfDestoys; i < endIndexOfDestoys; i++) {
                result[i] = '.';
            }
            matchIndex=endIndexOfDestoys;

        }
        System.out.println(result);

    }

    private static int getBombPower(String bomb) {
        int bombPower = 0;
        for (int i = 0; i < bomb.length(); i++) {
            bombPower += bomb.charAt(i);
        }
        bombPower = bombPower % 10;
        return bombPower;
    }
}
