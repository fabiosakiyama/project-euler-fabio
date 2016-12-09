/**
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author LaDivina
 * 
 */
public class MultiplesOf3And5 {

	public static void main(String args[]){
		
		int maxNumber = 1000;
		int sum = 0;
		
		for(int i = 0; i < maxNumber; i++){
			
			if(checkMultiple3or5(i)){
				sum += i;
			}
			
		}
		System.out.println("Soma: " + sum);
		
	}

	private static boolean checkMultiple3or5(int i) {
		if(i % 3 == 0){
			return true;
		}
		if(i % 5 == 0){
			return true;
		}
		return false;
	}
}
