import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringDivisibility {

	static List<String> permutations = new ArrayList<>();

	static long sum = 0;

	public static void main(String[] args) {

		printPermutations(10, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		for (String string : permutations) {
			System.out.println(string);
			sum += Long.parseLong(string);
		}
		System.out.println("Soma: " + sum);
	}

	public static void printPermutations(int n, Integer[] a) {
		if (n == 1) {
			String currentPermutation = "";
			List<Integer> list = Arrays.asList(a);
			for (Integer i : list) {
				currentPermutation += i;
			}
			
			if(isBizarreProperty(currentPermutation)){
				permutations.add(currentPermutation);
			}
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


	private static boolean isBizarreProperty(String currentPermutation) {
		String[] d = currentPermutation.split("");
		
		int number = Integer.parseInt(d[1] + d[2] + d[3]);
		if (!(number % 2 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[2] + d[3] + d[4]);
		if (!(number % 3 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[3] + d[4] + d[5]);
		if (!(number % 5 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[4] + d[5] + d[6]);
		if (!(number % 7 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[5] + d[6] + d[7]);
		if (!(number % 11 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[6] + d[7] + d[8]);
		if (!(number % 13 == 0)){
			return false;
		}
		
		number = Integer.parseInt(d[7] + d[8] + d[9]);
		if (!(number % 17 == 0)){
			return false;
		}
		return true;
	}
}
