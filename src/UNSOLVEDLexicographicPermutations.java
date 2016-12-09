import java.util.ArrayList;
import java.util.Collections;
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
public class UNSOLVEDLexicographicPermutations {

	public static void main(String[] args) {
		String abc = "123456789";
		// abc -> abc, acb, bac, bca, cab, cba;

		List<String> permutations = generantePermutations(abc);
		Collections.sort(permutations);
		System.out.println("How many? " + permutations.size());

		String abcd = "023456789";
		List<String> permutations2 = generantePermutations(abcd);
		Collections.sort(permutations2);
		System.out.println("How many? " + permutations.size());

		String abcde = "013456789";
		List<String> permutationse = generantePermutations(abcde);
		Collections.sort(permutationse);
		System.out.println("How many? " + permutations.size());

		for (String string : permutations) {
			System.out.println(string);
		}

//		for (String string : permutations2) {
//			System.out.println(string);
//		}
//
//		for (String string : permutationse) {
//			System.out.println(string);
//		}

		int total = permutations.size() + permutations2.size() + permutationse.size();
		System.out.println("Total: " + total);
		System.out.println("Take off 88640");
		System.out.println("So.." + (total - 88640));
		System.out.println(permutationse.get(permutationse.size() - 88639));
		System.out.println(permutationse.get(permutationse.size() - 88640));

	}

	private static List<String> generantePermutations(String abc) {

		List<String> set = new ArrayList<String>();
		if (abc == "")
			return set;

		Character a = abc.charAt(0);

		if (abc.length() > 1) {
			abc = abc.substring(1);

			List<String> permSet = generantePermutations(abc);

			for (String x : permSet) {
				for (int i = 0; i <= x.length(); i++) {
					set.add(x.substring(0, i) + a + x.substring(i));
				}
			}
		} else {
			set.add(a + "");
		}
		return set;
	}

}