import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamesScores {
 
	static Map<String, Integer> map = new HashMap<>();
	
	static {
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.put("F", 6);
		map.put("G", 7);
		map.put("H", 8);
		map.put("I", 9);
		map.put("J", 10);
		map.put("K", 11);
		map.put("L", 12);
		map.put("M", 13);
		map.put("N", 14);
		map.put("O", 15);
		map.put("P", 16);
		map.put("Q", 17);
		map.put("R", 18);
		map.put("S", 19);
		map.put("T", 20);
		map.put("U", 21);
		map.put("V", 22);
		map.put("W", 23);
		map.put("X", 24);
		map.put("Y", 25);
		map.put("Z", 26);
		
	}
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		populateGrid(names);
		Collections.sort(names);
		long sum = 0;
		
		for (String name : names) {
			long alphabeticalValue = getAlphabeticalValue(name);
			long position = names.indexOf(name) + 1;
			sum += position * alphabeticalValue;
			
		}
		System.out.println("Sum: " + sum);
	}

	private static long getAlphabeticalValue(String name) {
		long sum = 0;
		String[] letters = name.split("");
		for (String letter : letters) {
			sum += map.get(letter);
		}
		return sum;
	}

	private static void populateGrid(List<String> names) {

		List<String> gridInLines = loadGrid();
		String[] split = gridInLines.get(0).split(",");
		for (String name : split) {
			name = name.substring(1, name.length() -1);
			names.add(name);
		}
	}

	private static List<String> loadGrid() {
		List<String> gridInLines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/p022_names.txt"));
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
