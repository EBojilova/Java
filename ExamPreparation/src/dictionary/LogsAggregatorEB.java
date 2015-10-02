package dictionary;

import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregatorEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfLogs= Integer.parseInt(input.nextLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        TreeMap<String, TreeMap<String, Integer>> userIPduration = new TreeMap<>();
        for (int i = 0; i < numberOfLogs ; i++) {
            String[] inputLine = input.nextLine().trim().split(" ");
            String IPaddress = inputLine[0];
            String userName = inputLine[1];
            int duration = Integer.parseInt(inputLine[2]);
            if (!userIPduration.containsKey(userName)) {
                userIPduration.put(userName, new TreeMap<>());
            }
            if (!userIPduration.get(userName).containsKey(IPaddress)) {
                userIPduration.get(userName).put(IPaddress, 0);
            }
            int currentDuration= userIPduration.get(userName).get(IPaddress);
            userIPduration.get(userName).put(IPaddress, currentDuration + duration);
        }

        for (String userName : userIPduration.keySet()) {

            int dirationSum = userIPduration.get(userName).values().stream().mapToInt(Number::intValue).sum();
//            alex: 62 [10.10.17.33, 212.50.118.81]
            System.out.printf("%s: %d %s", userName, dirationSum, userIPduration.get(userName).keySet()).println();

        }
    }
}
