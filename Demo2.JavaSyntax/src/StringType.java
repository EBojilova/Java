
public class StringType {
    public static void main(String[] args) {
        String firstName = "Ivan";
        System.out.println("Hello, " + firstName);
        System.out.println(firstName.charAt(0));
        System.out.println(firstName.substring(1));
        System.out.println(firstName.indexOf('v'));
        String lastName = "Ivanov";
        String fullName = firstName + " " + lastName;
        System.out.println("Your full name is: " + fullName);
        int age = 21;
        System.out.println("Hello, I am " + age + " years old");
    }
}
