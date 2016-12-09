
public class PandigitalMultiples {

	public static void main(String[] args) {

		int[] a = new int[]{1,2,3};

		printPermutations(3, a);
		
	}

	public static void printPermutations(int n, int[] a) {
		if (n == 1) {
			for (int i : a) {
				System.out.print(i);
			}
			System.out.println();
		} else {
			for (int i = 0; i < n - 1; i++) {
				printPermutations(n - 1, a);
				if (n % 2 == 0) {
					int ai = a[i];
					a[i] = a[n-1];
					a[n-1] = ai;
				} else {
					int ai = a[0];
					a[0] = a[n-1];
					a[n-1] = ai;
				}
			}
			printPermutations(n - 1, a);
		}
	}

}
