import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_RegularExpressions {

    public static void main(String[] args) {
        String text =
                "Hello, my number in Sofia is +359 894 11 22 33, " +
                        "but in Munich my number is +49 89 975-99222.";
        String phoneRegEx = "\\+\\d{1,3}([ -]*[0-9]+)+";
        Pattern phonePattern = Pattern.compile(phoneRegEx);
        Matcher matcher = phonePattern.matcher(text);

        // zadaljitelno triabva da dadem parvo find na matchera da nameri matcha i posle da go razpechatame
        while (matcher.find()) {
            System.out.println(matcher.group());
            // repeated capturing group will only capture the last iteration.
            // Put a capturing group around the repeated group to capture all iterations or use a non-capturing group
            // instead if you're not interested in the data
            System.out.println(matcher.group(1));
        }

        System.out.println("+359 2 981-981".matches(phoneRegEx)); // true
        System.out.println("invalid number".matches(phoneRegEx)); // false
        System.out.println("+359 123-".matches(phoneRegEx)); // false
        System.out.println("+359 (2) 981 981".matches(phoneRegEx)); // false
        System.out.println("+44 280 11 11".matches(phoneRegEx)); // true
        System.out.println("++44 280 11 11".matches(phoneRegEx)); // false
        System.out.println("(+49) 325 908 44".matches(phoneRegEx)); // false
        System.out.println("+49 325 908-40-40".matches(phoneRegEx)); // true
    }

}
