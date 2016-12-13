import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapPokerHands {

	static List<String> permutations = new ArrayList<>();

	public static void main(String[] args) {
		
		List<String> cards = new ArrayList<>();
		List<String> cardsInLine = readCardsInLine();
		for (String lineOfCards : cardsInLine) {
			String[] cs = lineOfCards.split(" ");
			for (String card : cs) {
				cards.add(card);
			}
		}
		
		printPermutations(5, cards);
		permutations.forEach(System.out::println);

	}
	
	private static List<String> readCardsInLine() {
		List<String> hands = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/cards.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				hands.add(str);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		return hands;
	}

	public static void printPermutations(int n, List<String> cards) {
		if (n == 1) {
			String currentPermutation = "";
			List<String> list = cards;
			for (String i : list) {
				currentPermutation += i;
			}
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < n - 1; i++) {
				printPermutations(n - 1, cards);
				if (n % 2 == 0) {
					String ai = cards.get(i);
					cards.add(i, cards.get(n - 1));
					cards.add(n - 1, ai);
				} else {
					String ai = cards.get(0);
					cards.add(0, cards.get(n-1));
					cards.add(n - 1, ai);
				}
			}
			printPermutations(n - 1, cards);
		}
	}
}
