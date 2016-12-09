/**
 * 
 * @author LaDivina
 * 
 */
public class LongestCollatzSequence {

	public static void main(String args[]) {
		long starttime = System.currentTimeMillis();

		long greatestNumber = 0 ;
		int longestChainCounter = 0;

		for (long currentNumber = 999999; currentNumber > 0; currentNumber--) {
			System.out.println("Testing number: " + currentNumber);
			int currentChainCounter = 1;
			long startingNumber = currentNumber;
			while (startingNumber != 1) {
				if (isEven(startingNumber)) {
					startingNumber = startingNumber / 2;
				} else {
					startingNumber = 3 * startingNumber + 1;
				}
				currentChainCounter++;
			}
			if (longestChainCounter < currentChainCounter) {
				longestChainCounter = currentChainCounter;
				greatestNumber = currentNumber;
			}
		}
		System.out.println("Greatest number: " + greatestNumber);
		System.out.println("Longest chain counter: " + longestChainCounter);
		long finishtime = System.currentTimeMillis();
		System.out.println("Time: " + (finishtime - starttime));
	}

	private static boolean isEven(long startingNumber) {
		return startingNumber % 2 == 0;
	}
}
