import java.time.*;

/**
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author LaDivina
 * 
 */
public class CountingSundays {

	public static void main(String[] args) {

		LocalDate first = LocalDate.of(1901, Month.JANUARY, 1);
		LocalDate second = LocalDate.of(2000, Month.DECEMBER, 31);

		int numberOfSundays = 0;
		while (diffDate(first, second)) {
			// If its sunday AND its january
			if (DayOfWeek.SUNDAY == first.getDayOfWeek() &&  first.getDayOfMonth() == 1) {
				numberOfSundays++;
			}
			first = first.plusDays(1);
		}
		System.out.println("Number of sundays: " + numberOfSundays);
	}

	private static boolean diffDate(final LocalDate first, final LocalDate second) {
		return first.compareTo(second) <= 0;
	}
}