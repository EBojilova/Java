import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragonAccountingExam {

    public static BigDecimal Increase = new BigDecimal(1.006);

    public static BigDecimal Month = new BigDecimal(30);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal capital = new BigDecimal(scanner.nextLine());
        List<BigDecimal> salaries = new ArrayList<>();
        List<Long> hiredWorkersDay = new ArrayList<>();
        String input;
        int days = 1;
        while (!(input = scanner.nextLine()).equals("END")) {
//            {hired};{fired};{salary};{additional events: money},
            String[] inputData = input.split(";");
            long hired = Long.parseLong(inputData[0]);
            long fired = Long.parseLong(inputData[1]);
            BigDecimal salary = new BigDecimal(inputData[2]);

            // hire employees -> working days= days-index;
            salaries.add(salary);
            hiredWorkersDay.add(hired);

            // check for raise ->
            for (int day = 0; day < salaries.size(); day++) {
                int workingDays = days - day;
                if (workingDays % 365 == 0 && !hiredWorkersDay.get(day)
                                                              .equals(BigDecimal.ZERO)) {
                    BigDecimal increasedSalary = salaries.get(day)
                                                         .multiply(Increase);
                    salaries.set(day, increasedSalary);
                }
            }

            // give salaries ->
            if (days % 30 == 0) {
                for (int day = 0; day < days; day++) {
                    if (!hiredWorkersDay.get(day)
                                        .equals(BigDecimal.ZERO)) {
                        int workingDays = days - day;
                        if (workingDays > 30) {
                            workingDays = 30;
                        }

                        BigDecimal paiedSalaries = salaries.get(day)
                                                           .divide(Month, 9, RoundingMode.UP)
                                                           .setScale(7, BigDecimal.ROUND_DOWN)
                                                           .multiply(new BigDecimal(workingDays))
                                                           .multiply(new BigDecimal(hiredWorkersDay.get(day)));
                        capital = capital.subtract(paiedSalaries);
                    }
                }
            }
            // fire employees ->
            int day = 0;
            while (fired > 0 && day < days) {
                if (!hiredWorkersDay.get(day)
                                    .equals(BigDecimal.ZERO)) {
                    long firedDay = Math.min(fired, hiredWorkersDay.get(day));
                    long leftWorkersDay = hiredWorkersDay.get(day) - firedDay;
                    hiredWorkersDay.set(day, leftWorkersDay);
                    fired -= firedDay;
                    day++;
                }
            }
            // check for additional income/expense ->
            for (int i = 3; i < inputData.length; i++) {
                String[] eventInfo = inputData[i].split(":");
                String event = eventInfo[0];
                BigDecimal eventCost = new BigDecimal(eventInfo[1]);
                if (event.equals("Previous years deficit") || event.equals("Machines") || event.equals("Taxes")) {
                    capital = capital.subtract(eventCost);
                }
                else if (event.equals("Product development") || event.equals("Unconditional funding")) {
                    capital = capital.add(eventCost);
                }
            }
            // check for bankruptcy.
            if (capital.compareTo(new BigDecimal(0)) <= 0) {
                System.out.printf("BANKRUPTCY: %.4f", capital.abs()
                                                             .setScale(4, BigDecimal.ROUND_DOWN))
                          .println();
                return;
            }

            days++;
        }
        System.out.printf("%d %.4f", hiredWorkersDay.stream()
                                                    .mapToLong(x -> x)
                                                    .sum(), capital.setScale(4, BigDecimal.ROUND_DOWN))
                  .println();
    }
}