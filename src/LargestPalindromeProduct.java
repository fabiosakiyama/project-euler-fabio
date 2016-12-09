
/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author LaDivina
 * 
 */
public class LargestPalindromeProduct {

	public static void main(String args[]) {
		long maxNumber = 0;
		for (int i = 999; i > 800; i--) {
			for (int j = 999; j > 800; j--) {

				int result = i * j;

				if (isPalindrome(result) && maxNumber < result) {
					maxNumber = result;
				}
			}
		}
		System.out.println("Numero max: " + maxNumber);

	}

	private static boolean isPalindrome(int result) {
		String resultString = String.valueOf(result);

		String orSt = String.valueOf(resultString);
		String voltSt = "";
		for (int x = orSt.length(); x > 0; x--) {
			voltSt += String.valueOf(orSt.charAt(x - 1));
		}
		return voltSt.equals(resultString);

	}

}
