/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author LaDivina
 * 
 */
public class SummationOfPrimes {

	public static void main(String args[]) {
		
		long sumOfPrimeNumbers = 0;
		int numberToBeTested = 2;

		while(numberToBeTested < 2000000){
			if (isPrimeNumber(numberToBeTested)) {
				sumOfPrimeNumbers += numberToBeTested;
			}
			numberToBeTested++;
		}
		System.out.println("Sum of prime numbers below 2kk: " + sumOfPrimeNumbers);


	}

	private static boolean isPrimeNumber(Integer numberToBeTested) {

		// Check if its an even number.
		if (numberToBeTested % 2 == 0 && numberToBeTested != 2) {
			return false;
		}
		

		if(numberToBeTested == 1){
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
