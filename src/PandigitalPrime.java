
public class PandigitalPrime {

	static long largestPandigitalPrime = 0;

	public static void main(String[] args) {

		int[] pandigitalNumbers = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		printPermutations(pandigitalNumbers.length, pandigitalNumbers);
		System.out.println(largestPandigitalPrime);

	}

	public static void printPermutations(int n, int[] a) {
		if (n == 1) {
			long number = createNumber(a);
			if (number > largestPandigitalPrime && isPrimeNumber(number)) {
				largestPandigitalPrime = number;
			}
		} else {
			for (int i = 0; i < n - 1; i++) {
				printPermutations(n - 1, a);
				if (n % 2 == 0) {
					int ai = a[i];
					a[i] = a[n - 1];
					a[n - 1] = ai;
				} else {
					int ai = a[0];
					a[0] = a[n - 1];
					a[n - 1] = ai;
				}
			}
			printPermutations(n - 1, a);
		}
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

	private static long createNumber(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i : a) {
			sb.append(i);
		}
		return Long.parseLong(sb.toString());
	}
}