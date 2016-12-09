import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author LaDivina
 * 
 */
public class AmicableNumbers {
	
	static Set<Integer> setAmicableNumbersFound = new HashSet<>();

	public static void main(String[] args) {
		int sumOfAmicableNumbers = 0;

		for (int firstNumber = 1; firstNumber < 10000; firstNumber++) {
				sumOfAmicableNumbers += checkAmicableNumber(firstNumber);
		}
		
		System.out.println("Sum of amicable numbers: " + sumOfAmicableNumbers);
	}

	private static int checkAmicableNumber(int number) {
		List<Integer> divisorsNumber = findDivisors(number);
		int sumOfDivisors = sumOfDivisors(divisorsNumber);
		List<Integer> divisorsPossiblyAmicableNumber = findDivisors(sumOfDivisors);
		int sumOfDivisorPossiblyAmicableNumber = sumOfDivisors(divisorsPossiblyAmicableNumber);
		if(sumOfDivisorPossiblyAmicableNumber == number && number != sumOfDivisors){
			if(setAmicableNumbersFound.contains(sumOfDivisors) || setAmicableNumbersFound.contains(number)){
				return 0;
			}else{
				setAmicableNumbersFound.add(sumOfDivisors);
				setAmicableNumbersFound.add(number);
				return sumOfDivisors + number;
			}
		}
		return 0;
	}

	private static int sumOfDivisors(List<Integer> divisors) {
		int sum = 0;
		for (Integer divisor : divisors) {
			sum += divisor;
		}
		return sum;
	}

	private static List<Integer> findDivisors(int firstNumber) {
		List<Integer> divisors = new ArrayList<>();
		int limit = firstNumber / 2;

		for (int i = 1; i <= limit; i++) {
			if (firstNumber % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

}
