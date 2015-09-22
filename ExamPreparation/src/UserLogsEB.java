import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserLogsEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> userIPcount = new TreeMap<>();
        Pattern pattern = Pattern.compile("IP=(.+) message='.*' user=(.+)");

        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            Matcher matcher = pattern.matcher(input);
            matcher.find();
            String IPaddress = matcher.group(1)
                                      .trim();
            String userName = matcher.group(2)
                                     .trim();
            if (!userIPcount.containsKey(userName)) {
                userIPcount.put(userName, new LinkedHashMap<>());
            }
            if (!userIPcount.get(userName)
                            .containsKey(IPaddress)) {
                userIPcount.get(userName)
                           .put(IPaddress, 0);
            }
            int currentDuration = userIPcount.get(userName)
                                             .get(IPaddress);
            userIPcount.get(userName)
                       .put(IPaddress, currentDuration + 1);
        }
        //Printig result with stream and Collection.join is more than 2 times slower
//        printResultStream(userIPcount);
        printResultConcatenation(userIPcount);
    }

    private static void printResultStream(TreeMap<String, LinkedHashMap<String, Integer>> userIPcount) {
        for (String userName : userIPcount.keySet()) {
            System.out.printf("%s:", userName)
                      .println();
            String result = userIPcount.get(userName)
                                       .keySet()
                                       .stream()
                                       .map(ip -> String.format("%s => %d", ip, userIPcount.get(userName)
                                                                                           .get(ip)))
                                       .collect(Collectors.joining(", "));
            System.out.printf("%s.", result)
                      .println();
        }
    }

    private static void printResultConcatenation(TreeMap<String, LinkedHashMap<String, Integer>> userIPcount) {
        for (String userName : userIPcount.keySet()) {
            System.out.println(userName + ":");
            String ipOutput = "";
            for (String ip : userIPcount.get(userName).keySet()) {
                ipOutput += String.format("%s => %d, ", ip, userIPcount.get(userName).get(ip));
            }
            ipOutput = ipOutput.substring(0, ipOutput.length()-2)+'.';
            System.out.println(ipOutput);
        }
    }
}
