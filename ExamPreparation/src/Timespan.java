import java.util.Scanner;

public class Timespan {

    static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        long beginSeconds = makeTimeToSeconds();
        long endSeconds = makeTimeToSeconds();
        long secondsBetween = beginSeconds - endSeconds;
        long hours = (secondsBetween / 3600);
        long minutes = ((secondsBetween - hours * 3600) / 60);
        long seconds = (secondsBetween % 60);

        System.out.printf("%d:%02d:%02d", hours, minutes, seconds);
    }

    public static long makeTimeToSeconds() {
        String[] splitedString = input.nextLine()
                                      .split(":");
        return Long.parseLong(splitedString[2]) +
                (Long.parseLong(splitedString[1]) * 60) +
                (Long.parseLong(splitedString[0]) * 3600);
    }
}
