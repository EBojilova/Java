import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class _07DaysBetweenTwoDates {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // If we give "dd-MM-yyyy" will throw exeption if a single number is entered for the day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

        String startInput = input.nextLine();
        String endInput = input.nextLine();

        LocalDate start = LocalDate.parse(startInput, formatter);
        LocalDate end = LocalDate.parse(endInput, formatter);

        long daysBetween = ChronoUnit.DAYS.between(start, end);

        System.out.println(daysBetween);
    }
}
