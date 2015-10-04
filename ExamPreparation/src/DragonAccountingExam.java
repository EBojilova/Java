import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragonAccountingExam {

    public static BigDecimal incerase = new BigDecimal(1.006);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal capital = new BigDecimal(scanner.nextLine());
        List<BigDecimal> salaries = new ArrayList<>();
        List<Integer> hiredWorkers = new ArrayList<>();
        String input;
        int days = 0;
        while (!(input = scanner.nextLine()).equals("END")) {
//            {hired};{fired};{salary};{additional events: money},
//            10;0;40;Machines:120.4
//            7;6;44;Product development:8.8;Taxes:12
            String[] inputData = input.split(";");
            int hired = Integer.parseInt(inputData[0]);
            int fired = Integer.parseInt(inputData[1]);
            BigDecimal salary = new BigDecimal(30);
            BigDecimal dailySlary = new BigDecimal(inputData[2]).divide(salary, 9, RoundingMode.FLOOR).setScale(7, BigDecimal.ROUND_DOWN);

            // hire employees ->
            salaries.add(dailySlary);
            hiredWorkers.add(hired);

            // check for raise ->
            for (int day = 365; day < salaries.size(); day++) {
                if (day % 365 == 0 && !salaries.get(day)
                                               .equals(BigDecimal.ZERO)) {
                    BigDecimal incerase = new BigDecimal(1.006);
                    BigDecimal increasedDailySalary = salaries.get(day)
                                                              .multiply(incerase);
                    salaries.set(day, increasedDailySalary);
                }
            }
            // give salaries ->
            if (days % 30 == 0) {
                for (int i = 0; i < days; i++) {
                    int workingDaysMonth = (i) % 30 + 1;

                    BigDecimal paiedSalaries = salaries.get(i)
                                                       .multiply(new BigDecimal(workingDaysMonth))
                                                       .multiply(new BigDecimal(hiredWorkers.get(i)));
                    capital = capital.subtract(paiedSalaries);
                }
            }
            // fire employees ->
            int day = 0;
            while (fired > 0 && day < days) {
                int firedDay = Math.min(fired, hiredWorkers.get(day));
//                BigDecimal paiedSalaries = salaries.get(day)
//                                                   .multiply(new BigDecimal(days % 30))
//                                                   .multiply(new BigDecimal(fired));
//                capital = capital.subtract(paiedSalaries);

                int leftWorkersDay = hiredWorkers.get(day) - firedDay;
                hiredWorkers.set(day, leftWorkersDay);
                day++;
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
                System.out.printf("BANKRUPTCY: %.4f", capital.abs().setScale(4, BigDecimal.ROUND_DOWN))
                          .println();
                return;
            }

            days++;
        }
        System.out.printf("%d %.4f", hiredWorkers.stream()
                                                 .mapToInt(x -> x)
                                                 .sum(), capital.setScale(4, BigDecimal.ROUND_DOWN))
                  .println();
    }
}
