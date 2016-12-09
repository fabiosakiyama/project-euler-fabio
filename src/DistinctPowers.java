import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public class DistinctPowers {
	
	public static void main(String[] args) {
		
		Set<BigInteger> setOfNumbers = new HashSet<>();

		int limit = 100;
		for(int a = 2; a <= limit; a++){
			for(int b = 2; b <=limit; b++){
				BigInteger bigIntegerA = new BigInteger(""+ a);
				setOfNumbers.add(bigIntegerA.pow(b));
			}
		}
		System.out.println("Distincts: " + setOfNumbers.size());
	}
}
