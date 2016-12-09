/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 * @author LaDivina
 * 
 */
public class DoubleBasePalindromes {
	
	public static void main(String[] args) {
		long sum = 0;
		for(int i = 1; i <= 1000000; i++){
			if(isPalindrome(String.valueOf(i))){
				String baseTwo = transformToBaseTwo(i);
				if(isPalindrome(baseTwo)){
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}
	
	private static String transformToBaseTwo(int i) {
		int n = i;
		String baseTwo = "";
		while(n > 0){
			baseTwo = baseTwo + String.valueOf(n  % 2);
			n = n / 2;
		}
		return baseTwo;
		
	}

	private static boolean isPalindrome(String result) {
		String orSt = String.valueOf(result);
		String voltSt = "";
		for (int x = orSt.length(); x > 0; x--) {
			voltSt += String.valueOf(orSt.charAt(x - 1));
		}
		return voltSt.equals(result);
	}

}
