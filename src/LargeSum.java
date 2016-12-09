import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LaDivina
 * 
 */
public class LargeSum {

	public static void main(String args[]) {
		
		BigInteger sum = BigInteger.ZERO;
		List<BigInteger> list = new ArrayList<BigInteger>();
		populateGrid(list);
		
		for (BigInteger tenDigitNumber : list) {
			sum = sum.add(tenDigitNumber);
		}
		String tenDigitSum = String.valueOf(sum);
		System.out.println("Sum: " + tenDigitSum.substring(0, 10));
	}

	
	private static void populateGrid(List<BigInteger> list) {

		List<String> listInLines = loadGrid();
		for (int i = 0; i < 100; i++) {
			String tenDigitNumber = listInLines.get(i);
			list.add(new BigInteger(tenDigitNumber));
		}
		

	}

	private static List<String> loadGrid() {
		List<String> gridInLines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/50x100numbers.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				gridInLines.add(str);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		return gridInLines;
	}
}
