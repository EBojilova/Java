import com.itextpdf.text.pdf.hyphenation.TernaryTree;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class _07_SetsExample {

	public static void main(String[] args) {


		// Try also HashSet<String>
		// Vsichki setove HashSet, LinkedHashSet i TreeSet mogat da se sazdavat s interface Set
		Set<String> set = new HashSet<String>();
		
		set.add("Peter");
		set.add("Tosho");
		set.add("Peter");
		set.add("George");
		set.add("Maria");
		set.add("Alice");
		
		set.remove("Peter");
		
		System.out.println(set); // [George, Alice, Tosho, Maria]

		System.out.println(set.contains("Maria"));
		
		System.out.println();
		
		for (String element : set) {
			System.out.println(element);
		}
		System.out.println();
		
		System.out.println();

		//SortedSet<String> s = new TreeSet<String>(hashSet)
		// It is generally faster to add elements to the HashSet and then convert
		// the collection to a TreeSet for a duplicate-free sorted traversal.
		Set<String> orderedSet = new TreeSet(set);
		
		for (String name : set) {
			orderedSet.add(name);
		}
		
		for (String name : orderedSet) {
			System.out.println(name);
		}

		System.out.println();

		set.iterator().forEachRemaining(s -> System.out.println(s));

		System.out.println();

		orderedSet.iterator().forEachRemaining(s -> System.out.println(s));

		System.out.println();

		for (Iterator i= set.iterator(); i.hasNext();){
			System.out.println(i.next());
		}
	}

}
