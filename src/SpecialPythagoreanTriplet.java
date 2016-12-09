/**
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a² + b² = c² For example, 3² + 4² = 9 + 16 = 25 = 5².
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 * 
 * @author LaDivina
 * 
 */
public class SpecialPythagoreanTriplet {
	
	public static void main(String args[]){
		
		// Check square
		for(int a = 0; a < 1000; a++){
			for(int b = 0; b < 1000; b++){
				for(int c = 0; c < 1000; c++){
					if(a*a + b*b == c*c){
						// Found a match...
						if(a + b + c == 1000 && (a < b) && (b < c)){
							System.out.println("A: " + a);
							System.out.println("B: " + b);
							System.out.println("C: " + c);
							System.out.println("Product: " +( a*b*c));
							System.out.println("-----------");
						}
					}
				}
			}
		}
	}
}
