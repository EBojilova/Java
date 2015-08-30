import java.time.*;

public class CurrentDateTime {
    public static void main(String[] args) {
        ZoneId SofiaTimeZone = ZoneId.of("Europe/Sofia");
        LocalDateTime now = LocalDateTime.now(SofiaTimeZone);
        int nowYear = now.getYear();
        Month nowMonth = now.getMonth();
        int nowDay = now.getDayOfMonth();
        DayOfWeek nowDayOfWeek = now.getDayOfWeek();
        int nowHour = now.getHour();
        int nowMinutes = now.getMinute();
        int nowSeconds = now.getSecond();
        System.out.printf("Today is %s.", nowDayOfWeek).println();
        System.out.printf("Date is %s %s %s.", nowDay, nowMonth, nowYear).println();
        System.out.printf("Date is %1$td.%1$tm.%1$tY.", LocalDateTime.now()).println();
        System.out.printf("Time is %s,%d and %d seconds.", nowHour, nowMinutes, nowSeconds).println();
        System.out.println(now);
        System.out.printf("now: {0}", LocalDateTime.now()).println();
        System.out.printf("now: %s", LocalDateTime.now()).println();
        System.out.println(LocalDateTime.now());
    }
}
