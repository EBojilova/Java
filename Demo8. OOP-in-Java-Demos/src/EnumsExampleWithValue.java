// http://stackoverflow.com/questions/1067352/can-set-enum-start-value-in-java
// ako se sloji public otpred niama da raboti
enum DayWithValue {
    SUNDAY(7), MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private final int dayValue;

    DayWithValue(int i) {
        this.dayValue = i;
    }

    public int getDayValue() {
        return dayValue;
    }
}

public class EnumsExampleWithValue {

    public static void main(String[] args) {
        DayWithValue d = DayWithValue.MONDAY;
        if (d == DayWithValue.MONDAY) {
            printEnum(d);
        }
        d = DayWithValue.SUNDAY;
        printEnum(d);

    }

    private static void printEnum(DayWithValue d) {
        System.out.println(d); // MONDAY
        // ste izprintira koia podred e saotventana enumeracia
        System.out.println(d.ordinal()); // 1
        System.out.println(d.getDayValue());
    }

}

