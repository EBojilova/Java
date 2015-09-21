public class StudentExamples {

    public static void main(String[] args) {
        Student peter = new Student("Peter", 22); // Student-icon is loaded. is written from static constructor
        System.out.println(peter); // tudent(name: Peter, age: 22, local: false) from overload of to string method
        System.out.println(peter.toJson()); // {"name":"Peter","age":22,"local":false}
        System.out.println("Pater's age: " + peter.getAge()); // Pater's age: 22

        System.out.println("Student icon: " + Student.getIcon()); // Student icon: null
    }
}
