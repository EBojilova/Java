import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Student {

    private String name;

    private int age;

    private boolean local = false;

    private static final String iconFileName = "student-icon.png";

    private static byte[] icon;

    public Student(String name, int age, boolean local) {
        this.setName(name);
        this.setAge(age);
        this.setLocal(local);
    }

    // overload na parvia konstruktor, kato ne zadavame local
    // ako vmesto this e super, vikame konstruktora na klasa roditel, kato dori i da ne go napishem se izvikva pod default
    public Student(String name, int age) {
        this(name, age, false);
    }

    //    It's called a "static initialisation block".
//    It runs when the class is first loaded; only once.
//    http://stackoverflow.com/questions/13699075/calling-a-java-method-with-no-name
    static {
        Student.icon = loadIcon(iconFileName);
        System.out.println("Student-icon is loaded.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException(
                    "Age should be in range [0...120]");
        }
        this.age = age;
    }

    // for boolean fields gettera is not getLocal, it is isLocal
    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    //This will not compile (no default parameter values in Java)
    //public void incrementAge(int p = 1) {
    //	this.age = this.age + p;
    //}

    public void incrementAge(int p) {
        this.age = this.age + p;
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    @Override
    public String toString() {
        return "Student(name: " + this.name + ", age: " +
                this.age + ", local: " + this.local + ")";
    }

    private static byte[] loadIcon(String fileName) {
        try {
            byte[] icon = Files.readAllBytes(Paths.get(iconFileName));
            return icon;
        }
        catch (IOException ioex) {
            return null;
        }
    }

    public static byte[] getIcon() {
        return Student.icon;
    }
}
