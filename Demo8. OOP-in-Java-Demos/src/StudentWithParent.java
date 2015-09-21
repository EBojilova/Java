import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentWithParent extends Human {

    public static final double height = 1.80;

    private Map<String, List<Double>> courseMarks;

    static {
        System.out.println("This is written in static child constructor.");
    }

    public StudentWithParent(String name, int age) {
        super(age, name);
        this.courseMarks = new HashMap<>();
        System.out.println("This is written in child constructor");
    }

    public void addCourse(String course) {
        this.courseMarks.put(course, new ArrayList<>());
    }

    public void addGrade(String course, Double grade) throws Exception {
        if (!this.courseMarks.containsKey(course)) {
            throw new Exception("This course does not exist in student's courses.");
        }
        this.courseMarks.get(course).add(grade);
    }

    // Slagame Iterable vmesto ArrayList
    //http://stackoverflow.com/questions/2413633/java-the-difference-between-iterators-and-arraylists
    public Iterable<Double> getGrades(String course) {
        return this.courseMarks.get(course);
    }

    // keySet methoda vrasta Set, no toi sasto naslediava Iterable, za da ne moje da se barnika vav filda
    public Iterable<String> getCouses() {
        return this.courseMarks.keySet();
    }
}
