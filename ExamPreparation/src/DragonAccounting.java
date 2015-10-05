import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class DragonAccounting {
    private static final BigDecimal MONTH = new BigDecimal(30);
    private static final BigDecimal YEAR = new BigDecimal(365);
    private static final BigDecimal RAISE = new BigDecimal(1.006);

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int currentDay = 1;
        BigDecimal initialCapital = new BigDecimal(scn.nextLine());
        ArrayList<BigDecimal[]> hiredDaysSalary = new ArrayList<>();
        boolean isBankrupt = false;

        String command = scn.nextLine();
        while (!command.equals("END")) {
            String[] commandTokens = command.split(";");
            BigDecimal hired = new BigDecimal(commandTokens[0]);
            BigDecimal fired = new BigDecimal(commandTokens[1]);
            BigDecimal averageSalary = new BigDecimal(commandTokens[2]);

            // hire
            if (hired.compareTo(BigDecimal.ZERO) > 0) {
                hiredDaysSalary.add(new BigDecimal[]{
                        hired,
                        BigDecimal.ZERO,
                        averageSalary
                });
            }

            // check for raise
            for (BigDecimal[] employee : hiredDaysSalary) {
                employee[1] = employee[1].add(BigDecimal.ONE);
                BigDecimal totalDays = employee[1];
                if (totalDays.remainder(YEAR).equals(BigDecimal.ZERO)) {
                    employee[2] = employee[2].multiply(RAISE);
                }
            }

            // montly salaries
            if (currentDay % 30 == 0) {
                for (BigDecimal[] employee : hiredDaysSalary) {
                    BigDecimal totalDays = employee[1];
                    if (totalDays.compareTo(MONTH) > 0) {
                        totalDays = MONTH;
                    }
                    BigDecimal fractionSalary = employee[2]
                            .divide(MONTH, 9, BigDecimal.ROUND_UP)
                            .setScale(7, BigDecimal.ROUND_DOWN);
                    initialCapital = initialCapital
                            .subtract(fractionSalary
                            .multiply(totalDays)
                            .multiply(employee[0]));
                }
            }

            //fire employees
            for (BigDecimal[] employee : hiredDaysSalary) {
                if (fired.compareTo(BigDecimal.ZERO) <= 0) {
                    break;
                }

                if (employee[0].compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal employeeCount = employee[0];
                    if (employeeCount.compareTo(fired) == 0) {
                        employee[0] = BigDecimal.ZERO;
                        fired = BigDecimal.ZERO;
                    } else if (employeeCount.compareTo(fired) > 0){
                        employee[0] = employee[0].subtract(fired);
                        fired = BigDecimal.ZERO;
                    } else {
                        fired = fired.subtract(employeeCount);
                        employee[0] = BigDecimal.ZERO;
                    }
                }
            }

            if (commandTokens.length > 3) {
                for (int i = 3; i < commandTokens.length; i++) {
                    String[] newEventArgs = commandTokens[i].split(":");
                    switch (newEventArgs[0]) {
                        case "Previous years deficit":
                        case "Machines":
                        case "Taxes":
                            initialCapital = initialCapital.subtract(new BigDecimal(newEventArgs[1]));
                            break;
                        case "Product development":
                        case "Unconditional funding":
                            initialCapital = initialCapital.add(new BigDecimal(newEventArgs[1]));
                            break;
                        default:
                            System.out.println("tuka stana nekaw kor");
                            System.out.println(newEventArgs[0]);
                            break;
                    }
                }
            }

            if (initialCapital.compareTo(BigDecimal.ZERO) < 1) {
                isBankrupt = true;
                break;
            }

            currentDay++;
            command = scn.nextLine();
        }

        //System.out.println(currentDay);

        BigDecimal totalEmployees = BigDecimal.ZERO;

        if (isBankrupt) {
            BigDecimal debt = BigDecimal.ZERO.subtract(initialCapital).abs()
                    .setScale(4, BigDecimal.ROUND_DOWN);
            System.out.println("BANKRUPTCY: " + debt);
        } else {
            for (BigDecimal[] e : hiredDaysSalary) {
                totalEmployees = totalEmployees.add(e[0]);
            }
            System.out.println(totalEmployees + " " + initialCapital.setScale(4, BigDecimal.ROUND_DOWN));
        }
    }
}