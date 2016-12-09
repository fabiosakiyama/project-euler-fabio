/**
 * 
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 * 
 * 1634 = 14 + 64 + 34 + 44 8208 = 84 + 24 + 04 + 84 9474 = 94 + 44 + 74 + 44 As
 * 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * @author LaDivina
 * 
 */
public class DigitFifthPowers {

	public static void main(String[] args) {
		long bigSum = 0;
		
		for(int i = 2; i < 1000000; i++){
			double sum = 0;
			String numberAsString = String.valueOf(i);
			String[] splittedNumbers = numberAsString.split("");
			for (String string : splittedNumbers) {
				double pow = Math.pow(Integer.parseInt(string), 5);
				sum += pow;
			}
			if(sum == i){
				System.out.println("Number: " + i);
				bigSum += sum;
			}
		}
		System.out.println("Big sum: " + bigSum);
	}

}
