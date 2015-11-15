package arrays;

import java.util.Scanner;

public class TinySporebatEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int health = 5800;
        int glowcaps = 0;

        // game ends in two cases – you reach Sporeggar, or your health drops to zero or below
        while (!command.equals("Sporeggar")) {

            for (int i = 0; i < command.length() - 1; i++) {
                char currentChar = command.charAt(i);
                if (currentChar == 'L') {
                    health += 200;
                }
                else {
                    health -= currentChar;
                }
                if (health <= 0) {
                    System.out.printf("Died. Glowcaps: %d", glowcaps)
                              .println();
                    return;
                }
            }
            char lastChar = command.charAt(command.length() - 1);
            glowcaps += lastChar - '0';
            command = scanner.nextLine();
        }

//       •	If you are well and alive in Sporeggar:
//         o	Print the remaining health: “Health left: {h}”, where h is the remaining health
//         o	If you can buy the sporebat: “Bought the sporebat. Glowcaps left: {n}”, where n is the number of remaining glowcaps
//         o	If you cannot buy it: “Safe in Sporeggar, but another {n} Glowcaps needed.”, n is the number of additional glowcaps required
//       •	If you die: “Died. Glowcaps: {n}”, n is the number of glowcaps collected.
        System.out.printf("Health left: %d", health)
                  .println();
        if (glowcaps >= 30) {
            System.out.printf("Bought the sporebat. Glowcaps left: %d", glowcaps - 30)
                      .println();
        }
        else {
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcaps)
                      .println();
        }
    }
}
