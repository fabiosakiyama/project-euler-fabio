
public class CircularPrimes {

	public static void main(String[] args) {

		int counter = 0;
		for (int i = 2; i <= 1000000; i++) {
			if (isPrimeNumber(i)) {
				String numberAsString = String.valueOf(i);
				if (numberAsString.length() == 1) {
					counter++;
				}

				if (numberAsString.length() >= 2) {
					boolean foundCircularPrime = true;
					String reverse = numberAsString;
					do {
						reverse = rotate(reverse);
						if (!isPrimeNumber(Integer.parseInt(reverse))) {
							foundCircularPrime = false;
						}
						
					}while (!reverse.equals(numberAsString));
					if (foundCircularPrime == true) {
						counter++;
					}
				}
			}
		}
		System.out.println("Counter: " + counter);

	}

	private static String rotate(String numberAsString) {
		
		String rotationedString = "";
		for(int i = 1; i < numberAsString.length() ; i++){
			rotationedString = rotationedString + numberAsString.charAt(i);
		}
		rotationedString = rotationedString + numberAsString.charAt(0);
		return rotationedString;
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
