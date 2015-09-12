import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _03a_LinkedList {

    public static void main(String[] args) {

        //Vsichki funkcii otdolu vajat i za ArrayList i za LinkedList
//        List<Integer> numbers = new ArrayList<Integer>() {{
//            add(2);
//            add(5);
//            add(8);
//        }};

        List<Integer> numbers = new LinkedList<Integer>() {{
            add(2);
            add(5);
            add(8);
        }};
        System.out.println(numbers);
        System.out.println(numbers.get(1));

        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(numbers);

        //Arrays.sort(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

        numbers.removeAll(Arrays.asList(2, 3, 5));
        System.out.println(numbers);
    }
}
