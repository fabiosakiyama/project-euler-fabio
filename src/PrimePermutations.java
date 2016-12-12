import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimePermutations {
	
	static List<String> permutations = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 1000; i <= 6670; i++) {
			if (isPrimeNumber(i) && isPrimeNumber(i + 3330) && isPrimeNumber(i + 6660)) {
				String[] split = String.valueOf(i).split("");
				printPermutations(4, split);
				if(permutations.contains(String.valueOf(i + 3330)) && permutations.contains(String.valueOf(i + 6660))){
					System.out.println(i);
					System.out.println(i + 3330);
					System.out.println(i + 6660);
				}
			}
		}
	}
	
	public static void printPermutations(int n, String[] a) {
		if (n == 1) {
			String currentPermutation = "";
			List<String> list = Arrays.asList(a);
			for (String i : list) {
				currentPermutation += i;
			}
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < n - 1; i++) {
				printPermutations(n - 1, a);
				if (n % 2 == 0) {
					String ai = a[i];
					a[i] = a[n - 1];
					a[n - 1] = ai;
				} else {
					String ai = a[0];
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
}