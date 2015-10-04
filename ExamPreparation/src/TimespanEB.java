import java.text.ParseException;
import java.util.Scanner;

public class TimespanEB {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        String[] time = input.nextLine()
                             .split(":");
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        time = input.nextLine()
                    .split(":");
        hour -= Integer.parseInt(time[0]);
        minutes -= Integer.parseInt(time[1]);
        seconds -= Integer.parseInt(time[2]);

        if (seconds < 0) {
            minutes--;
            seconds += 60;
        }
        if (minutes < 0) {
            hour--;
            minutes += 60;
        }
        System.out.printf("%d:%02d:%02d", hour, minutes, seconds);
    }
}
