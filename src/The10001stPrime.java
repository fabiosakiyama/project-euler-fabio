
/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10.001st prime number?
 * 
 * @author LaDivina
 * 
 */
public class The10001stPrime {

	public static void main(String args[]) {
		
		int primeNumberCounter = 0;
		int numberToBeTested = 2;

		while(primeNumberCounter < 10001){
			if (isPrimeNumber(numberToBeTested)) {
				primeNumberCounter++;
				System.out.println("I am the " + primeNumberCounter + " prime number: " + numberToBeTested);
			}
			numberToBeTested++;
		}
		System.out.println("Total prime numbers: " + primeNumberCounter);

	}

	private static boolean isPrimeNumber(Integer numberToBeTested) {
		
		// Check if its an even number.
		if(numberToBeTested % 2 == 0 && numberToBeTested != 2){
			return false;
		}
		

		if(numberToBeTested == 1){
			return false;
		}
		
		// Going to check from 2 to only until sqrt of the number
		int limit = (int) Math.ceil(Math.sqrt(numberToBeTested));
		
		for(int i = 3; i <= limit; i++){
			if(numberToBeTested % i == 0){
				return false;
			}
		}
		return true;
	}
}
