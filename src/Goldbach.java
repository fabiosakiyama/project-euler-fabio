
/**
 * 9 = 7 + 2×12 15 = 7 + 2×22 21 = 3 + 2×32 25 = 7 + 2×32 27 = 19 + 2×22 33 = 31
 * + 2×12
 * 
 * @author zsakfab
 *
 */
public class Goldbach {

	public static void main(String[] args) {

		boolean achou = false;
		int contador = 1;
		while (!achou) {

			if (contador % 2 != 0 && isComposite(contador)) {
				achou = checkGoldBach(contador);
			}
			contador++;
		}

	}

	private static boolean checkGoldBach(int i) {
		boolean achou = false;
		for (int possiblePrime = 1; possiblePrime < i; possiblePrime++) {
			boolean isPrime = isPrimeNumber(possiblePrime);
			if (!isPrime) {
				continue;
			}
			for (int possibleSquare = 1; possibleSquare < i; possibleSquare++) {
				int possibleI = possiblePrime + 2 * possibleSquare * possibleSquare;
				if (possibleI == i) {
					// System.out.println(i + " = " + possiblePrime + " + 2 x "
					// + possibleSquare + "²");
					achou = true;
					return false;
				}
			}
		}
		if (!achou) {
			System.out.println("FAIL " + i);
			return true;
		}
		return false;
	}

	private static boolean isPrimeNumber(int numberToBeTested) {
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

	private static boolean isComposite(int i) {
		for (int j = 1; j < i; j++) {
			for (int k = 1; k < i; k++) {
				if (j * k == i) {
					return true;
				}
			}
		}
		return false;
	}

}
