import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokerHands {

	public static void main(String[] args) {

		List<Hand> player1hands = new ArrayList<>();
		List<Hand> player2hands = new ArrayList<>();
		List<String> cardsInLine = readCardsInLine();
		for (String lineCards : cardsInLine) {
			String[] cards = lineCards.split(" ");
			List<Card> listOfCards = new ArrayList<>();
			for (String card : cards) {
				String[] valueSuit = card.split("");
				Card c = new Card(valueSuit[0], SuitTypesEnum.valueOf(valueSuit[1]));
				System.out.println(c);
			}
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

class Hand {

	private List<Card> cards = new ArrayList<>();

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
		return "Card: " + value + " of " + suit.getName();
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
			return "Spade";
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
