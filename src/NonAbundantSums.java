import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonAbundantSums {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int limit = 28123;
		List<Integer> nonAbundantSum = new ArrayList<>();
		List<Integer> abundantNumbers = new ArrayList<>();
		long sum = 0;

		// Let´s find out ALL abundant numbers till 28123
		for (int number = 1; number <= limit; number++) {
			if (isAbundant(number)) {
				abundantNumbers.add(number);
			}
		}
		// Finding ALL POSSIBLE SUMS from the abundant numbers
		Set<Integer> allSumsPossible = new HashSet<Integer>();
		for (Integer abundantNumber1 : abundantNumbers) {
			for (Integer abundantNumber2 : abundantNumbers) {
				allSumsPossible.add(abundantNumber1 + abundantNumber2);
			}
		}

		// Checking from 1 to 28123 if that number is a sum of abundant numbers.
		for (int number = 1; number <= limit; number++) {
			if (!allSumsPossible.contains(number)) {
				sum += number;
			}
		}

		System.out.println("How many abundant numbers? " + abundantNumbers.size());
		System.out.println("How many NON abundant numbers? " + nonAbundantSum.size());
		System.out.println("Sum: " + sum);
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
	}

	private static boolean isAbundant(int number) {
		int sumOfDivisors = sumOfDivisors(findDivisors(number));
		return sumOfDivisors > number;
	}

	private static int sumOfDivisors(List<Integer> divisors) {
		int sum = 0;
		for (Integer divisor : divisors) {
			sum += divisor;
		}
		return sum;
	}

	private static List<Integer> findDivisors(int firstNumber) {
		List<Integer> divisors = new ArrayList<>();
		int limit = firstNumber / 2;

		for (int i = 1; i <= limit; i++) {
			if (firstNumber % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
}
