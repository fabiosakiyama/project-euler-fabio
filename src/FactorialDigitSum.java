import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author LaDivina
 * 
 */
public class FactorialDigitSum {

	public static void main(String[] args) {

		BigInteger factorial = new BigInteger("100");
		long sum = 0;
		
		for(int i = 99; i >= 1 ; i--){
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}
		String[] factorialAsString = String.valueOf(factorial).split("");
		for (String factorialNumber : factorialAsString) {
			sum += Long.parseLong(factorialNumber);
		}
		System.out.println("Fatorial: " + factorial);
		System.out.println("Sum: " + sum);
	}
}