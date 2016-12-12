import java.util.ArrayList;
import java.util.List;

public class ConsecutivePrimeSum {

	static List<String> permutations = new ArrayList<>();

	public static void main(String[] args) {

		int sum = 0;
		int limit = 100;
		List<Integer> primeNumbers = findAllPrimeNumbersUntil(limit);
		
		while(){
		sum = primeNumbers.stream().mapToInt(Integer::intValue).sum();
		if(isPrimeNumber(sum)){
			System.out.println("sum: " + sum);
		}
		}
	}

	private static List<Integer> findAllPrimeNumbersUntil(long limit) {
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 1; i < limit; i++) {
			if (isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

	private static boolean isPrimeNumber(long numberToBeTested) {
		// Check if its an even number.
		if (numberToBeTested % 2 == 0 && numberToBeTested != 2) {
			return false;
		}

		if (numberToBeTested == 1) {
			return false;
		}

		// Going to check from 2 to only until sqrt of the number
		int limit = (int) Math.ceil(Math.sqrt(numberToBeTested));

		for (int i = 3; i <= limit; i++) {
			if (numberToBeTested % i == 0) {
				return false;
			}
		}
		return true;
	}

}
