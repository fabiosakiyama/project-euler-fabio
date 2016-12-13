import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
		
		System.out.println("PLAYER 1 WINS: " + Dealer.player1Wins);
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
		if(player1Score == player2Score){
			player1Score += getHighestCard(player1cards);
			player2Score += getHighestCard(player2cards);
			while(player1Score == player2Score){
				player1cards.remove(getHighestCard(player1cards));
				player2cards.remove(getHighestCard(player2cards));
			}
		}
		
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
			return 900 + getHighestCard(cards);
		}

		if (isFourOfAKind(cards)) {
			return 800 + getPairValue(cards, 4);
		}

		if (isFullHouse(cards)) {
			return 600 + (getPairValue(cards, 3) * 8) + getPairValue(cards, 2);
		}
		
		if(isFlush(cards)){
			return 500 + getHighestCard(cards);
		}

		if(isStraight(cards)){
			return 400 + getHighestCard(cards);
		}
		
		if(isThreeOfAKind(cards)){
			return 300 + getPairValue(cards, 3);
		}
		
		if(isTwoPairs(cards)){
			return 200 + getPairValue(cards, 2);
		}
		
		if(isOnePair(cards)){
			return 100 + getPairValue(cards, 2);
		}
		return score + getHighestCard(cards);
	}

	private static Integer getPairValue(List<Card> cards, int x) {
		Collection<List<Card>> values = cards.stream().collect(Collectors.groupingBy(Card::getValue)).values();
		List<List<Card>> collect = values.stream().filter(c -> c.size() == x).collect(Collectors.toList());
		if(collect.size() == 2){
			Integer cardValue1 = Integer.parseInt(getValue(collect.get(0).get(0).getValue()));
			Integer cardValue2 = Integer.parseInt(getValue(collect.get(1).get(0).getValue()));
			if(cardValue1 > cardValue2){
				return cardValue1;
			}
			else{
				return cardValue2;
			}
		}
		String cardValue = collect.get(0).get(0).getValue();
		int value = Integer.parseInt(getValue(cardValue));
		return value;
	}

	private static boolean isOnePair(List<Card> cards) {
		if (hasXRepeatedCards(cards, 2) && !hasXRepeatedCards(cards, 3)) {
			return true;
		}
		return false;
	}

	private static boolean isTwoPairs(List<Card> cards) {
		if (hasXRepeatedCardsTwice(cards)) {
			return true;
		}
		return false;
	}

	private static boolean isThreeOfAKind(List<Card> cards) {
		if (hasXRepeatedCards(cards, 3) && !hasXRepeatedCards(cards, 2)) {
			return true;
		}
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
	
	private static Integer getHighestCard(List<Card> cards) {
		List<Integer> values = new ArrayList<>();
		cards.stream().forEach(c -> values.add(Integer.parseInt(getValue(c.getValue()))));
		List<Integer> orderedValues = values.stream().sorted().collect(Collectors.toList());
		return orderedValues.get(orderedValues.size()- 1);
	}

	private static boolean hasSequence(List<Card> cards) {
		List<Integer> values = new ArrayList<>();
		boolean hasAce = false;
		int sequenceCounter = 0;
		cards.stream().forEach(c -> values.add(Integer.parseInt(getValue(c.getValue()))));
		List<Integer> orderedValues = values.stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < orderedValues.size() - 1; i++) {
			// ESPECIAL CASE ACE
			if(orderedValues.get(orderedValues.size() - 1) == 14){
				hasAce = true;
			}
			
			if (!(orderedValues.get(i) + 1 == orderedValues.get(i + 1))) {
				if(sequenceCounter == 3 && hasAce){
					if(orderedValues.get(0) == 2){
						return true;
					}
				}
				return false;
			}else{
				sequenceCounter++;
			}
		}

		return true;
	}

	private static String getValue(String value) {
		if (value.equals("A")) {
			return "14";
		}

		if (value.equals("K")) {
			return "13";
		}

		if (value.equals("Q")) {
			return "12";
		}

		if (value.equals("J")) {
			return "11";
		}

		if (value.equals("T")) {
			return "10";
		}

		return value;
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

	private static boolean hasXRepeatedCardsTwice(List<Card> cards) {
		Collection<List<Card>> values = cards.stream().collect(Collectors.groupingBy(Card::getValue)).values();
		long count = values.stream().filter(c -> c.size() == 2).count();
		if (count == 2) {
			return true;
		}
		return false;
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
