import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * @author LaDivina
 * 
 */
public class DigitFactorials {

	public static void main(String[] args) {
		BigInteger bigSum = BigInteger.ZERO;
		for (int i = 3; i < 100000000; i++) {
			String numberAsString = String.valueOf(i);
			String[] splittedNumbers = numberAsString.split("");
			BigInteger factorialSum = BigInteger.ZERO;
			for (String string : splittedNumbers) {
				if (string.equals("0")) {
					factorialSum = factorialSum.add(BigInteger.ONE);
				} else {
					BigInteger factorial = new BigInteger(string);
					for (int k = factorial.intValue() - 1; k >= 1; k--) {
						factorial = factorial.multiply(new BigInteger(String.valueOf(k)));
					}
					factorialSum = factorialSum.add(factorial);
				}
			}
			if (factorialSum.equals(new BigInteger(numberAsString))) {
				System.out.println(i);
				bigSum = bigSum.add(factorialSum);
			}
		}
		System.out.println(bigSum);
	}
}
