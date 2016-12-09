/**
 * 
 * @author LaDivina
 * 
 */
public class NumberLetterCounts {

	public static void main(String[] args) {
		int numberOfLetters = 0;
		for (Integer number = 1; number <= 1000; number++) {
			String numberAsString = String.valueOf(number);
			if (containsOneDigit(numberAsString)) {
				numberOfLetters += getNumberOfLettersOneDigit(number);
			}
			if (containsTwoDigits(numberAsString)) {
				if (startsWithOne(numberAsString)) {
					numberOfLetters += getNumberOfLettersTwoDigitsStartingWithOne(number);
				} else {
					numberOfLetters += getNumberOfLettersTwoDigits(numberAsString);
				}
			}
			if (containsThreeDigits(numberAsString)) {
				numberOfLetters += getNumberOfLettersThreeDigits(numberAsString);
			}

			if (number == 1000) {
				numberOfLetters += 11;
			}
		}
		System.out.println("---------------------------");
		System.out.println("Number of Letters: " + numberOfLetters);
	}

	private static int getNumberOfLettersThreeDigits(String numberAsString) {
		int numberOfLetters = 0;
		int hundredLetters = 7;
		int andLetters = 3;

		int firstDigit = Integer.parseInt(numberAsString.substring(0, 1));
		String secondAndThirdDigitAsString = numberAsString.substring(1, 3);
		numberOfLetters = getNumberOfLettersOneDigit(firstDigit) + hundredLetters;
		if (startsWithOne(secondAndThirdDigitAsString)) {
			System.out.print(" hundred and ");
			int secondAndThirdDigit = Integer.parseInt(numberAsString.substring(1, 3));
			numberOfLetters = numberOfLetters + getNumberOfLettersTwoDigitsStartingWithOne(secondAndThirdDigit)  + andLetters;
			
		} else {
			if (secondAndThirdDigitAsString.equalsIgnoreCase("00")) {
				System.out.print(" hundred ");
				return numberOfLetters;
			} else {
				System.out.print(" hundred and ");
				numberOfLetters = numberOfLetters + getNumberOfLettersTwoDigits(secondAndThirdDigitAsString) + andLetters;
			}
		}
		// System.out.println("Number: " + numberAsString + " | Letters: " +
		// numberOfLetters);

		return numberOfLetters;
	}

	private static int getNumberOfLettersTwoDigits(String numberAsString) {
		int numberOfLetters = 0;
		int firstDigit = Integer.parseInt(numberAsString.substring(0, 1));
		int secondDigit = Integer.parseInt(numberAsString.substring(1, 2));
		switch (firstDigit) {
		case 2: // Twenty
			numberOfLetters = "Twenty".length();
			System.out.print("Twenty ");
			break;
		case 3: // Thirty
			numberOfLetters = "Thirty".length();
			System.out.print("Thirty ");
			break;
		case 4: // Forty
			numberOfLetters = "Forty".length();
			System.out.print("Forty ");
			break;
		case 5: // Fifty
			numberOfLetters = "Fifty".length();
			System.out.print("Fifty ");
			break;
		case 6: // Sixty
			numberOfLetters = "Sixty".length();
			System.out.print("Sixty ");
			break;
		case 7: // Seventy
			numberOfLetters = "Seventy".length();
			System.out.print("Seventy ");
			break;
		case 8: // Eighty
			numberOfLetters = "Eighty".length();
			System.out.print("Eighty ");
			break;
		case 9: // Ninety
			numberOfLetters = "Ninety".length();
			System.out.print("Ninety ");
			break;
		}
		return numberOfLetters + getNumberOfLettersOneDigit(secondDigit);
	}

	private static int getNumberOfLettersTwoDigitsStartingWithOne(Integer number) {
		int numberOfLetters = 0;
		switch (number) {
		case 10: // Ten
			numberOfLetters = "Ten".length();
			System.out.println("Ten");
			break;
		case 11: // Eleven
			numberOfLetters = "Eleven".length();
			System.out.println("Eleven");
			break;
		case 12: // Twelve
			numberOfLetters = "Twelve".length();
			System.out.println("Twelve");
			break;
		case 13: // Thirteen
			numberOfLetters = "Thirteen".length();
			System.out.println("Thirteen");
			break;
		case 14: // Fourteen
			numberOfLetters = "Fourteen".length();
			System.out.println("Fourteen");
			break;
		case 15: // Fifteen
			numberOfLetters = "Fifteen".length();
			System.out.println("Fifteen");
			break;
		case 16: // Sixteen
			numberOfLetters = "Sixteen".length();
			System.out.println("Sixteen");
			break;
		case 17: // Seventeen
			numberOfLetters = "Seventeen".length();
			System.out.println("Seventeen");
			break;
		case 18: // Eighteen
			numberOfLetters = "Eighteen".length();
			System.out.println("Eighteen");
			break;
		case 19: // Nineteen
			numberOfLetters = "Nineteen".length();
			System.out.println("Nineteen");
			break;
		}
		return numberOfLetters;
	}

	private static int getNumberOfLettersOneDigit(Integer number) {
		int numberOfLetters = 0;
		switch (number) {
		case 1: // One
			numberOfLetters = "One".length();
			System.out.println("One");
			break;
		case 2: // Two
			numberOfLetters = "Two".length();
			System.out.println("Two");
			break;
		case 3: // Three
			numberOfLetters = "Three".length();
			System.out.println("Three");
			break;
		case 4: // Four
			numberOfLetters = "Four".length();
			System.out.println("Four");
			break;
		case 5: // Five
			numberOfLetters = "Five".length();
			System.out.println("Five");
			break;
		case 6: // Six
			numberOfLetters = "Six".length();
			System.out.println("Six");
			break;
		case 7: // Seven
			numberOfLetters = "Seven".length();
			System.out.println("Seven");
			break;
		case 8: // Eight
			numberOfLetters = "Eight".length();
			System.out.println("Eight");
			break;
		case 9: // Nine
			numberOfLetters = "Nine".length();
			System.out.println("Nine");
			break;
		}
		return numberOfLetters;
	}

	private static boolean startsWithOne(String numberAsString) {
		return numberAsString.startsWith("1");
	}

	private static boolean containsThreeDigits(String numberAsString) {
		return numberAsString.length() == 3;
	}

	private static boolean containsOneDigit(String numberAsString) {
		return numberAsString.length() == 1;
	}

	private static boolean containsTwoDigits(String numberAsString) {
		return numberAsString.length() == 2;
	}
}
