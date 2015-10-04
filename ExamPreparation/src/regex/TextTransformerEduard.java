package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformerEduard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        String line = scn.nextLine();

        while (!line.equals("burp")) {
            sb.append(line);
            line = scn.nextLine();
        }
        String finalString = sb.toString();
        finalString = finalString.replaceAll("\\s+", " ");

        Pattern thePattern = Pattern.compile("([$'%&])([^$'%&]+)\\1");
        Matcher theMatch = thePattern.matcher(finalString);

        while (theMatch.find()) {
            char specialChar = theMatch.group(1).charAt(0);
            int weight = getWeight(specialChar);
            String captured = theMatch.group(2);

            StringBuilder outputString = new StringBuilder();
            for (int index = 0; index < captured.length(); index++) {
                char nextChar = captured.charAt(index);
                char newChar;
                if (index % 2 == 0) {
                    newChar = (char)(weight + nextChar);
                } else {
                    newChar = (char)(nextChar - weight);
                }
                outputString.append(newChar);
            }

            System.out.print(outputString + " ");
        }

        //System.out.println(finalString);
    }

    private static int getWeight(char specialChar) {
        switch (specialChar) {
            case '$': return 1;
            case '%': return 2;
            case '&': return 3;
        }

        return 4;
    }
}