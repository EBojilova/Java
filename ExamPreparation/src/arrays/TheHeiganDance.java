package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class TheHeiganDance {

    private static final int MIN_WALL = 0;

    private static final int MAX_WALL = 14;

    private static final int CLOUD_DAMAGE = 3500;

    private static final int ERUPTION_DAMAGE = 6000;

    private static HashMap<String, Integer> damagePositions;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Heigan starts at 3,000,000 hit points
        double heiganPoints = 3000000d;
        boolean isHeiganDefeated = false;
        // The player always starts at 18500 hit points
        int playerPoints = 18500;
        boolean isPlayerDefeated = false;
        boolean hasCloud = false;
        String causeOfDeath = "";

        int[] playerPosition = {7, 7};
        // floating-point number D – the damage done to Heigan each turn
        double damageToHeigan = Double.parseDouble(scn.nextLine());
        // you receive input in format {spell} {row} {col} – {spell} is either Plague or Eruption
        while (true) {

            heiganPoints -= damageToHeigan;
            isHeiganDefeated = (heiganPoints <= 0);

            // Plague cloud does 3500 damage when it hits, and 3500 damage the next turn.
            if (hasCloud) {
                playerPoints -= CLOUD_DAMAGE;
                hasCloud = false;
                causeOfDeath = "Plague Cloud";
                isPlayerDefeated = (playerPoints <= 0);
            }
            // If Heigan is dead, the spell he would have casted is ignored.
            // The fight is over either when the player is killed, or Heigan is defeated.
            if (isHeiganDefeated || isPlayerDefeated) {
                break;
            }

            String[] attackArgs = scn.nextLine()
                                     .split(" ");
            int row = Integer.parseInt(attackArgs[1]);
            int col = Integer.parseInt(attackArgs[2]);
            // For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns
            getDamageArea(row, col);

            //If the player’s current position is within the area of damage, the player tries to move.
            // First he tries to move up, than right, then down, then left
            if (isPlayerInDamageZone(playerPosition)) {
                if (playerPosition[0] > MIN_WALL && playerPosition[0] == damagePositions.get("minRow")) {
                    playerPosition[0]--;
                }
                else if (playerPosition[0] < MAX_WALL && playerPosition[0] == damagePositions.get("maxRow")) {
                    playerPosition[0]++;
                }
                else if (playerPosition[1] > MIN_WALL && playerPosition[1] == damagePositions.get("minCol")) {
                    playerPosition[1]--;
                }
                else if (playerPosition[1] < MAX_WALL && playerPosition[1] == damagePositions.get("maxCol")) {
                    playerPosition[1]++;
                }
            }

            if (isPlayerInDamageZone(playerPosition)) {
                if (attackArgs[0].equals("Cloud")) {
                    playerPoints -= CLOUD_DAMAGE;
                    hasCloud = true;
                    causeOfDeath = "Plague Cloud";
                }
                else {
                    playerPoints -= ERUPTION_DAMAGE;
                    causeOfDeath = "Eruption";
                }
            }

            isPlayerDefeated = (playerPoints <= 0);

            if (isPlayerDefeated) {
                break;
            }
        }

        if (isHeiganDefeated) {
            System.out.println("Heigan: Defeated!");
        }
        else {
            System.out.printf("Heigan: %.2f\n", heiganPoints);
        }

        if (isPlayerDefeated) {
            System.out.println("Player: Killed by " + causeOfDeath);
        }
        else {
            System.out.println("Player: " + playerPoints);
        }

        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    private static void getDamageArea(int row, int col) {
        damagePositions = new HashMap<>();
        damagePositions.put("minRow", row - 1);
        damagePositions.put("maxRow", row + 1);
        damagePositions.put("minCol", col - 1);
        damagePositions.put("maxCol", col + 1);
    }

    private static boolean isPlayerInDamageZone(int[] playerPosition) {
        boolean isInHitRow = playerPosition[0] >= damagePositions.get("minRow") &&
                playerPosition[0] <= damagePositions.get("maxRow");
        boolean isInHitCol = playerPosition[1] >= damagePositions.get("minCol") &&
                playerPosition[1] <= damagePositions.get("maxCol");

        return isInHitRow && isInHitCol;
    }
}