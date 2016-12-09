/**
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1² + 2² + ... + 10² = 385 The square of the sum of the first ten natural
 * numbers is,
 * 
 * (1 + 2 + ... + 10)² = 55² = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025 −
 * 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author LaDivina
 * 
 */
public class SumSquareDifference {
	
	public static void main(String args[]){
		
		int limit = 100;
		long sumOfNumbers = 0;
		long squareSumOfNumbers = 0;
		long squareValueOfNumbers = 0;
		
		for(int i = 1; i <= limit; i++){
			sumOfNumbers += i;
			squareSumOfNumbers += i * i;
		}
		
		squareValueOfNumbers = sumOfNumbers * sumOfNumbers;
		System.out.println("Sum then ²: " + squareValueOfNumbers);
		System.out.println("Sum ²: " + squareSumOfNumbers);
		System.out.println("Diff: " + (squareValueOfNumbers - squareSumOfNumbers));
	}

}
