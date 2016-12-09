import java.math.BigDecimal;

/**
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * @author fsakiyama
 *
 */
public class ReciprocalCycles {

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		
		long longestCycle = 0;
		long currentCycle = 0;
		String longestCycleString = null;
		BigDecimal longestDenominator = BigDecimal.ZERO;
		BigDecimal numerator = BigDecimal.ONE;
		BigDecimal denominator = new BigDecimal("2");
		BigDecimal limit = new BigDecimal("1000");
		while (denominator.compareTo(limit) <= 0) {

			BigDecimal division = numerator.divide(denominator, 10000, BigDecimal.ROUND_FLOOR);
			if (!isExactDivision(numerator, denominator, division)) {
				String divisionAsString = String.valueOf(division);
				String decimalsAsString = divisionAsString.substring(2, divisionAsString.length());
				if (!is1digitCycle(decimalsAsString)) {
					// System.out.println(division);
					currentCycle = countCycleLength(decimalsAsString);
					if (currentCycle > longestCycle) {
						longestCycle = currentCycle;
						longestCycleString = decimalsAsString;
						longestDenominator = denominator;
					}
				}
			}
			denominator = denominator.add(BigDecimal.ONE);
		}
		
		System.out.println("MAIOR DENOMINADOR: " + longestDenominator);
		System.out.println("MAIOR CICLO: " + longestCycleString);
		System.out.println("CONTAGEM: " + longestCycle);
		long finishtime = System.currentTimeMillis();
		System.out.println("Time: " + (finishtime - starttime));
	}

	private static long countCycleLength(String decimalAsString) {

		// 142857142857142857142857142857 = 5 ciclos de 6 digitos

		String startingString = decimalAsString.substring(0, 2);
		//System.out.println(startingString);
		int currentSize = startingString.length();
		String substring = decimalAsString.substring(currentSize, currentSize * 2);
		//System.out.println(substring);
		while (true) {
			if (startingString.equals(substring)) {
			//	System.out.println("Achei ciclo " + startingString);
				return startingString.length();
			} else {
				currentSize++;
				startingString = decimalAsString.substring(0, currentSize);
				//System.out.println(startingString);
				if (currentSize * 2 <= decimalAsString.length()) {
					substring = decimalAsString.substring(currentSize, currentSize * 2);
				//	System.out.println(substring);
				} else {
					return 0;
				}
			}
		}
	}

	private static boolean isExactDivision(BigDecimal numerator, BigDecimal denominator, BigDecimal decimalRep) {
		return decimalRep.multiply(denominator).compareTo(numerator) == 0;
	}

	private static boolean is1digitCycle(String decimalsOnly) {
		return decimalsOnly.matches("(.)\\1*") || decimalsOnly.substring(1, decimalsOnly.length()).matches("(.)\\1*");
	}

}
