/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author LaDivina
 * 
 */
public class LargestPrimeFactor {

	/**
	 * Dividindo desde 1 até x enquanto o resto não for 0, achando assim os divisores. Continuar o processo até que o número dado dividido pelo divisor encontrado seja 1
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		long number = 600851475143L;
		long resto = 0;
		long divisor = 1;
		do {
			divisor++;
			resto = number % divisor;
			if(resto == 0){
				System.out.println(divisor);
				number = number / divisor;
				divisor = 1;
			}
		} while(number != 1);
		
	}

}
