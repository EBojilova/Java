public class Human {

    private String name;

    private int Age;

    static {
        System.out.println("This is written in static parent constructor.");
    }

    public Human(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
