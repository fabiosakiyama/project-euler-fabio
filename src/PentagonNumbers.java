import java.util.ArrayList;
import java.util.List;

public class PentagonNumbers {

	public static void main(String[] args) {
		int d = Integer.MAX_VALUE;
		List<Integer> pentagonNumbers = new ArrayList();

		for (int i = 1; i < 3000; i++) {
			int pentagonNumber = i * (3 * i - 1) / 2;
			pentagonNumbers.add(pentagonNumber);
		}

		for (int i = 0; i < pentagonNumbers.size(); i++) {
			for (int j = i; j < pentagonNumbers.size(); j++) {

				Integer pj = pentagonNumbers.get(i);
				Integer pk = pentagonNumbers.get(j);

				Integer sum = pj + pk;
				Integer diff = pk - pj;
				if (pentagonNumbers.contains(sum) && pentagonNumbers.contains(diff)) {
					if (diff < d) {
						d = diff;
					}
				}
			}
		}
		
		System.out.println("D: " + d);

	}
}
