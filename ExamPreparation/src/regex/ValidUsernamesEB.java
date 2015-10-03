package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernamesEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> allMatches = new ArrayList<String>();
        Matcher matcher = Pattern.compile("\\b[a-zA-Z]\\w{2,24}\\b")
                                 .matcher(text);
        int max = 0;
        int i = 0;
        int iMax = 0;
        matcher.find();
        String temporary = matcher.group();
        allMatches.add(temporary);
        while (matcher.find()) {

            allMatches.add(matcher.group());
            i++;
            int currentSumLength = temporary.length() + allMatches.get(i)
                                                                  .length();
            if (currentSumLength > max) {
                iMax = i;
                max = currentSumLength;
            }
            temporary = allMatches.get(i);
        }
        System.out.println(allMatches.get(iMax-1));
        System.out.println(allMatches.get(iMax));
    }
}
