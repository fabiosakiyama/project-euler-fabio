import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 */
public class CodedTriangleNumbers {

	public static void main(String[] args) {
		int counter = 0;
		Set<Integer> triangleNumbers = new HashSet<>();
		Map<String, Integer> mapaLetraValor = new HashMap<>();
		initMap(mapaLetraValor);

		for (int i = 1; i <= 100; i++) {
			triangleNumbers.add(calcTriangleNumbers(i));
		}
		
		List<String> fileAsString = readFile();
		List<String> words = new ArrayList<>();
		String[] splittedFile = fileAsString.get(0).split(",");
		for (String word : splittedFile) {
			word = word.substring(1, word.length() -1);
			words.add(word);
		}
		for (String word : words) {
			int sum = 0;
			String[] letters = word.split("");
			for (String letter : letters) {
				Integer letterValue = mapaLetraValor.get(letter);
				sum += letterValue;
			}
			if(triangleNumbers.contains(new Integer(sum))){
				counter++;
			}
		}
		System.out.println(counter);

	}
	
	private static List<String> readFile() {
		List<String> gridInLines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/p042_words.txt"));
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

	private static void initMap(Map<String, Integer> mapaLetraValor) {
		
		mapaLetraValor.put("A", 1);
		mapaLetraValor.put("B", 2);
		mapaLetraValor.put("C", 3);
		mapaLetraValor.put("D", 4);
		mapaLetraValor.put("E", 5);
		mapaLetraValor.put("F", 6);
		mapaLetraValor.put("G", 7);
		mapaLetraValor.put("H", 8);
		mapaLetraValor.put("I", 9);
		mapaLetraValor.put("J", 10);
		mapaLetraValor.put("K", 11);
		mapaLetraValor.put("L", 12);
		mapaLetraValor.put("M", 13);
		mapaLetraValor.put("N", 14);
		mapaLetraValor.put("O", 15);
		mapaLetraValor.put("P", 16);
		mapaLetraValor.put("Q", 17);
		mapaLetraValor.put("R", 18);
		mapaLetraValor.put("S", 19);
		mapaLetraValor.put("T", 20);
		mapaLetraValor.put("U", 21);
		mapaLetraValor.put("V", 22);
		mapaLetraValor.put("W", 23);
		mapaLetraValor.put("X", 24);
		mapaLetraValor.put("Y", 25);
		mapaLetraValor.put("Z", 26);
	}

	public static int calcTriangleNumbers(int a) {
		return (1 * a * (a + 1)) / 2;
	}

}
