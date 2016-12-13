import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHands {

	public static void main(String[] args) {

		List<String> cardsInLine = readCardsInLine();
		for (String lineCards : cardsInLine) {
			String[] cards = lineCards.split(" ");
			for (String card : cards) {
				String[] valueSuit = card.split("");
				Card c = new Card(valueSuit[0], SuitTypesEnum.valueOf(valueSuit[1]));
				Dealer.dealCard(c);
			}
			Dealer.showWinner();
		}
	}

	private static List<String> readCardsInLine() {
		List<String> hands = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/p054_poker.txt"));
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
}

class Dealer {

	static int player1Wins = 0;

	static List<Card> player1cards = new ArrayList<>();

	static List<Card> player2cards = new ArrayList<>();

	public static void dealCard(Card c) {
		if (player1cards.size() < 5) {
			player1cards.add(c);
		} else {
			player2cards.add(c);
		}
	}

	public static void showWinner() {
		System.out.println("Player 1 Hand: ");
		player1cards.forEach(p -> System.out.print(p + " "));

		System.out.println();

		System.out.println("Player 2 Hand: ");
		player2cards.forEach(p -> System.out.print(p + " "));

		System.out.println();
		// calcula pontuacao
		int player1Score = getHandScore(player1cards);
		int player2Score = getHandScore(player2cards);
		if (player1Score > player2Score) {
			System.out.println("Player 1 Wins");
			player1Wins++;
		}

		player1cards.clear();
		player2cards.clear();
	}

	private static int getHandScore(List<Card> cards) {
		int score = 0;
		if (isRoyalStraightFlush(cards)) {
			return 1000;
		}

		if (isStraightFlush(cards)) {
			return 950;
		}

		if (isFourOfAKind(cards)) {
			return 900;
		}

		if (isFullHouse(cards)) {
			return 850;
		}
		
		if(isFlush(cards)){
			return 800;
		}

		if(isStraight(cards)){
			return 750;
		}
		
		if(isThreeOfAKind(cards)){
			return 700;
		}
		return score;
	}

	private static boolean isThreeOfAKind(List<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isStraight(List<Card> cards) {
		if(hasSequence(cards)){
			return true;
		}
		return false;
	}

	private static boolean isFlush(List<Card> cards) {
		if(hasSameSuits(cards)){
			return true;
		}
		return false;
	}

	private static boolean isFullHouse(List<Card> cards) {
		if (hasXRepeatedCards(cards, 3) && hasXRepeatedCards(cards, 2)) {
			return true;
		}
		return false;
	}

	private static boolean isFourOfAKind(List<Card> cards) {
		if (hasXRepeatedCards(cards, 4)) {
			return true;
		}
		return false;
	}

	private static boolean isStraightFlush(List<Card> cards) {
		// Checking same suits
		if (!hasSameSuits(cards)) {
			return false;
		}

		// Checking repeated cards
		if (hasRepeatedCards(cards)) {
			return false;
		}

		// Checking Sequence
		if (!hasSequence(cards)) {
			return false;
		}

		return true;
	}

	private static boolean hasSequence(List<Card> cards) {
		List<Integer> values = new ArrayList<>();
		cards.stream().forEach(c -> values.add(Integer.parseInt(getValue(c))));
		List<Integer> orderedValues = values.stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < orderedValues.size() - 1; i++) {
			if (!(orderedValues.get(i) + 1 == orderedValues.get(i + 1))) {
				return false;
			}
		}

		return true;
	}

	private static String getValue(Card c) {
		if (c.getValue().equals("A")) {
			return "1";
		}

		if (c.getValue().equals("K")) {
			return "13";
		}

		if (c.getValue().equals("Q")) {
			return "12";
		}

		if (c.getValue().equals("J")) {
			return "11";
		}

		if (c.getValue().equals("T")) {
			return "10";
		}

		return c.getValue();
	}

	private static boolean isRoyalStraightFlush(List<Card> cards) {
		// Checking same suits
		if (!hasSameSuits(cards)) {
			return false;
		}

		// Checking repeated cards
		if (hasRepeatedCards(cards)) {
			return false;
		}

		// Check A K Q J 10
		for (Card card : cards) {
			switch (card.getValue()) {
			case "A":
				break;
			case "K":
				break;
			case "Q":
				break;
			case "J":
				break;
			case "T":
				break;
			default:
				return false;
			}
		}
		return true;
	}

	private static boolean hasXRepeatedCards(List<Card> cards, int x) {
		Collection<List<Card>> values = cards.stream().collect(Collectors.groupingBy(Card::getValue)).values();
		long count = values.stream().filter(c -> c.size() == x).count();
		if (count == 1) {
			return true;
		}
		return false;
	}

	private static boolean hasRepeatedCards(List<Card> cards) {
		Collection<List<Card>> values = cards.stream().collect(Collectors.groupingBy(Card::getValue)).values();
		long count = values.stream().filter(c -> c.size() > 1).count();
		if (count == 0) {
			return false;
		}
		return true;
	}

	private static boolean hasSameSuits(List<Card> cards) {
		long count = cards.stream().collect(Collectors.groupingBy(Card::getSuit)).values().stream()
				.filter(c -> c.size() == 5).count();
		if (count == 0) {
			return false;
		}
		return true;
	}
}

class Card {

	private String value;

	private SuitTypesEnum suit;

	public Card(String value, SuitTypesEnum suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return value + " of " + suit.getName();
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SuitTypesEnum getSuit() {
		return this.suit;
	}

	public void setSuit(SuitTypesEnum suit) {
		this.suit = suit;
	}
}

enum SuitTypesEnum {

	H {
		@Override
		String getName() {
			return "Heart";
		}
	},
	C {
		@Override
		String getName() {
			return "Club";
		}
	},
	S {
		@Override
		String getName() {
			return "Spades";
		}
	},
	D {
		@Override
		String getName() {
			return "Diamond";
		}
	};

	abstract String getName();
}
