import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamsOfElements {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(values.stream()
		    .filter(e -> e > 3)
		    .filter(e -> e % 2 > 0)
		    .map(e -> e * 2)
		    .findFirst()
		);
		// The same in C#
//		List<int> values = new List<int>() {1, 2, 3, 4, 5, 6, 7, 8};
//		Console.WriteLine(values
//				.Where(e => e > 3)
//			    .Where(e => e % 2 > 0)
//				.Select(e => e * 2)
//				.First()
//		);

		IntStream.range(0,10).forEach(i-> System.out.println(i));
	}

	private static boolean isPrime(int number) {
		// s funkcionalno programirane na edin red namirame dali dadeno chislo e prime
		return number > 1 &&
				IntStream.range(2, number).noneMatch(i -> number % i == 0);
	}

}
