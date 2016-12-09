import java.math.BigInteger;


public class The1000DigitFibonacciNumber {
	
	public static void main(String[] args) {
		
		long counter = 3;
		BigInteger number1 = BigInteger.ONE;
		BigInteger number2 = new BigInteger("2");
		BigInteger newNumber = BigInteger.ZERO;

		while (String.valueOf(newNumber).length() < 1000) {
			newNumber = number1.add(number2);
			number1 = number2;
			number2 = newNumber;
			counter++;
		}
		System.out.println(counter);
	}

}
