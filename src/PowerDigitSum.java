import java.math.BigInteger;

/**
 * 
 * 
 * @author LaDivina
 *
 */
public class PowerDigitSum {

	
	public static void main(String[] args) {
		BigInteger result = new BigInteger("2");
		long sum = 0;
		String resultAsString = String.valueOf(result.pow(1000));
		String[] splittedNumbers = resultAsString.split("");
		for (String splittedNumber : splittedNumbers) {
			long number = Long.parseLong(splittedNumber);
			sum += number;
		}
		System.out.println("Sum: " + sum);
	}
}
