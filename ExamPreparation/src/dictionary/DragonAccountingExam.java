package dictionary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragonAccountingExam {

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
            BigDecimal slary = new BigDecimal(30);
            BigDecimal dailySlary= new BigDecimal(inputData[2]);
            salaries.add(dailySlary);
            hiredWorkers.add(hired);
            int day = 0;
            while (fired > 0 && day < days) {
                fired -= Math.min(fired, hiredWorkers.get(day));
//                BigDecimal paiedSalaries = salaries.get(day)
//                                                   .multiply(new BigDecimal(days % 30))
//                                                   .multiply(new BigDecimal(fired));
//                capital = capital.subtract(paiedSalaries);

                int leftWorkersDay = hiredWorkers.get(day) - fired;
                if (leftWorkersDay == 0) {
                    hiredWorkers.set(day, 0);
                    salaries.set(day, new BigDecimal(0));
                }
                else {
                    hiredWorkers.set(day, leftWorkersDay);
                }
                day++;
            }
            for (int i = 3; i < inputData.length; i++) {
                String[] eventInfo = inputData[i].split(":");
                String event = eventInfo[0];
                BigDecimal eventCost = new BigDecimal(eventInfo[1]);
                if (event.equals("Previous years deficit") || event.equals("Machines") || event.equals("Taxes")) {
                    capital = capital.subtract(eventCost);
                }
                else if (event.equals("Product development ") || event.equals("Unconditional funding ")) {
                    capital = capital.add(eventCost);
                }
            }
            days++;
            if (days % 30 == 0) {
                for (int i = 0; i < days; i++) {
                    int workingDaysMonth = (i) % 30 + 1;

                    BigDecimal paiedSalaries = salaries.get(day)
                                                       .multiply(new BigDecimal(workingDaysMonth))
                                                       .multiply(new BigDecimal(hiredWorkers.get(i)));
                    capital = capital.subtract(paiedSalaries);
                }
            }
            if (capital.compareTo(new BigDecimal(0)) <= 0) {
                System.out.printf("BANKRUPTCY: %.4f", capital)
                          .println();
                return;
            }
        }
        System.out.printf("%d %.4f",hiredWorkers.stream().mapToInt(x->x).sum(), capital)
                  .println();
    }
}
