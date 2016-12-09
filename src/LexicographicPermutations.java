import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author LaDivina
 * 
 */
public class LexicographicPermutations {

	static List<String> permutations = new ArrayList<>();

	static int counter = 1;

	public static void main(String[] args) {

		printPermutations(10, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		permutations.sort(Comparator.naturalOrder());
		for (String string : permutations) {
			System.out.println(counter++ + " - " + string);
			if(counter == 1000001){
				break;
			}
		}

	}

	public static void printPermutations(int n, Integer[] a) {
		if (n == 1) {
			String currentPermutation = "";
			List<Integer> list = Arrays.asList(a);
			for (Integer i : list) {
				currentPermutation += i;
			}
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < n - 1; i++) {
				printPermutations(n - 1, a);
				if (n % 2 == 0) {
					int ai = a[i];
					a[i] = a[n - 1];
					a[n - 1] = ai;
				} else {
					int ai = a[0];
					a[0] = a[n - 1];
					a[n - 1] = ai;
				}
			}
			printPermutations(n - 1, a);
		}
	}

}