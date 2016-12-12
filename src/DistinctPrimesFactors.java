import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctPrimesFactors {

	public static void main(String[] args) {

		List<Long> consecutiveNumbers = new ArrayList<>();
		int numberOfPrimeFactors = 4;
		boolean achou = false;
		long number = 1;
		while (!achou) {
			Set<Long> primeFactors = findPrimeFactor(number);
			if (primeFactors.size() == numberOfPrimeFactors) {
				if (consecutiveNumbers.isEmpty()) {
					consecutiveNumbers.add(number);
				} else {
					Long numberBefore = consecutiveNumbers.get(consecutiveNumbers.size() - 1);
					if (numberBefore + 1 == number) {
						consecutiveNumbers.add(number);
						if (consecutiveNumbers.size() == numberOfPrimeFactors) {
							achou = true;
							consecutiveNumbers.forEach(System.out::println);
							System.out.println("Numero: " + number);
							primeFactors.forEach(p -> System.out.println("Prime factors: " + p.longValue()));
						}
					} else {
						consecutiveNumbers.clear();
					}
				}
			} else {
				consecutiveNumbers.clear();
			}
			number++;
		}
	}

	private static Set<Long> findPrimeFactor(long number) {
		Set<Long> primeFactors = new HashSet<>();
		long resto = 0;
		long divisor = 1;
		do {
			divisor++;
			resto = number % divisor;
			if (resto == 0) {
				// System.out.println(divisor);
				primeFactors.add(divisor);
				number = number / divisor;
				divisor = 1;
			}
		} while (number != 1);
		return primeFactors;
	}
}
