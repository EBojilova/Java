
public class Literals {
    public static void main(String[] args) {
        String str = "Hello,\nI\'m Java.";
        System.out.println(str);
        String nullStr = null; // null
        System.out.println(nullStr);
        int dec = 5; // decimal value 5
        System.out.println(dec);
        int hex = 0xFE; // hexadecimal value FE -> 254
        System.out.println(hex);
        int bin = 0b11001; // binary value 11001 -> 25
        System.out.println(bin);
        int bigNum = 1_250_000; // decimal value 1250000
        System.out.println(bigNum);
        long num = 1234567890123456789L;
        System.out.println(num); // 1234567890123456789
        long hexNum = 0x7FFF_FFFF_FFFF_FFFFL; // L nakraia e ot tipa L
        System.out.println(hexNum); // 9223372036854775807- maksimuma na Long
        boolean bool = true;
        System.out.println(bool); // true
        float floatNum = 1.25e+7f; // 12500000
        System.out.println(floatNum); // 1.25E7
        double doubleNum = 6.02e+23; // 602000000000000000000000
        System.out.println(doubleNum); // 6.02E23
        char newLine = '\n'; // Character <new line>
        System.out.println(newLine);
        char backSlash = '\\'; // Character: \
        System.out.println(backSlash);
        char unicodeChar = '\u00F1'; // Character: ñ
        System.out.println(unicodeChar);
        long fourBytes = 0b11010010_01101001_10010100_10010010; // -764832622
        System.out.println(fourBytes); // -764832622
    }
}
