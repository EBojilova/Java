package regex;

import java.util.Scanner;

public class EnigmaEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String withoutWhitespacesAndNumbers = input.trim()
                                                       .replaceAll("[\\s\\d]+", "");
            int halfLength = withoutWhitespacesAndNumbers.length() / 2;
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)) {
                    currentChar = (char) ((int) currentChar + halfLength);
                }

                System.out.print(currentChar);
            }
            System.out.println();
        }
    }
}
