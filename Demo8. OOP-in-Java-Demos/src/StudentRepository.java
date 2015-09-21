import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentRepository implements Serializable{

    public static void main(String[] args) throws Exception {
        List<Double> marks= Arrays.asList(3.00, 3.50, 4.00, 5.00, 6.00);
        List<String> cources=Arrays.asList("Java basics", "C# basics", "C# Advanced", "C# OOP", "HQC");
        List<StudentWithParent> studentsRepository= new ArrayList<>();
        studentsRepository.add(new StudentWithParent("Pesho",20));
        studentsRepository.add(new StudentWithParent("Minka",21));
        studentsRepository.add(new StudentWithParent("Gosho",25));
        studentsRepository.add(new StudentWithParent("Tosho",26));

        Random generator = new Random();
        for (int i = 0; i < studentsRepository.size() ; i++) {
            for (int j = 0; j < cources.size() ; j++) {
                studentsRepository.get(i).addCourse(cources.get(j));
                for (int k = 0; k < 4; k++) {
                    int markIndex= generator.nextInt(marks.size());
                    studentsRepository.get(i).addGrade(cources.get(j), marks.get(markIndex));
                }
            }
        }

        for (StudentWithParent student: studentsRepository) {
            System.out.printf("%s:", student.getName()).println();
            for (String course: student.getCouses()){
                System.out.printf("   %s -> %s", course, student.getGrades(course)).println();
            }
        }

        System.out.println(studentsRepository.get(0).height);
    }
}
