/**
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * @author LaDivina
 * 
 */
public class IntegerRightTriangles {

	public static void main(String[] args) {
		int maxP = 0;
		int maxCounter = 0;
		for (int p = 1; p <= 1000; p++) {
			int currentcounter = 0;
			for (int a = 1; a <= p; a++) {
				for (int b = 1; b <= p; b++) {
					for (int c = 1; c <= p; c++) {
						if ((a + b + c == p) && isRightAngleTriangle(a, b, c)) {
							currentcounter++;
							if (maxCounter < currentcounter) {
								maxP = p;
								maxCounter = currentcounter;
							}
						}
					}
				}
			}
		}
		System.out.println(maxCounter);
		System.out.println(maxP);
	}

	private static boolean isRightAngleTriangle(int a, int b, int c) {
		return (a * a + b * b == c * c);
	}

}
