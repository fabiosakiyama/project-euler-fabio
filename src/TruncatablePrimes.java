public class TruncatablePrimes {

	public static void main(String[] args) {
		int counter = 0;
		long sum = 0;
		for (int i = 11; i <= 1000000; i++) {
			if (isPrimeNumber(i)) {
				boolean foundNonPrimeNumber = false;
				String numberAsString = String.valueOf(i);
				foundNonPrimeNumber = checkFromTheRight(foundNonPrimeNumber, numberAsString);
				foundNonPrimeNumber = checkFromTheLeft(foundNonPrimeNumber, numberAsString);
				if (foundNonPrimeNumber == false) {
					System.out.println("Number: " + i);
					counter++;
					sum += i;
				}
			}
		}
		System.out.println("Sum: " + sum);
		System.out.println("Counter: " + counter);
	}

	private static boolean checkFromTheLeft(boolean foundNonPrimeNumber, String numberAsString) {
		int size = 1;
		while (size < numberAsString.length()) {
			String substringCutLeft = numberAsString.substring(size, numberAsString.length());
			if (!isPrimeNumber(Integer.parseInt(substringCutLeft))) {
				foundNonPrimeNumber = true;
			}
			size++;
		}
		return foundNonPrimeNumber;
	}

	private static boolean checkFromTheRight(boolean foundNonPrimeNumber, String numberAsString) {
		int size = numberAsString.length();
		while (size > 1) {
			String substringCutRight = numberAsString.substring(0, size - 1);
			if (!isPrimeNumber(Integer.parseInt(substringCutRight))) {
				foundNonPrimeNumber = true;
			}
			size--;
		}
		return foundNonPrimeNumber;
	}

	private static boolean isPrimeNumber(Integer numberToBeTested) {

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
