/**
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author LaDivina
 * 
 */
public class SmallestMultiple {
	
	public static void main(String args[]){
		
		long menorNumero = 20;
		boolean achou = false;
		
		while(achou == false){
			if(isDivisivelPor10(menorNumero)){
				achou = true;
				System.out.println(menorNumero);
			}
			menorNumero++;
		}
	}

	private static boolean isDivisivelPor10(long menorNumero) {
		
		for(int i = 20; i >= 1;  i--){
			if(menorNumero % i != 0){
				return false;
			}
		}
		return true;
	}

}
