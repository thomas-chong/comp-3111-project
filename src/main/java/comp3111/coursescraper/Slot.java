package comp3111.coursescraper;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalTime;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

/**
 * Slot class defines every slots belonging to a section. Each Slot contains information about time and venue. A Slot is considered valid if its time follows the format (Mo/Tu/We/Th/Fr/Sa)(H:MMAA-H:MMAA) (e.g. "Mo9:00-10:20"). Slots in any other formats are considered invalid and will be ignored (e.g. "TBA").
 * <br><br>
 * A Slot object provides methods for data manipulation between its own type. 
 * @author lky-bulbasaur
 *
 */

public class Slot {
	private int day;
	private LocalTime start;
	private LocalTime end;
	private String venue;
	public static final String DAYS[] = {"Mo", "Tu", "We", "Th", "Fr", "Sa"};
	public static final Map<String, Integer> DAYS_MAP = new HashMap<String, Integer>();
	static {
		for (int i = 0; i < DAYS.length; i++)
			DAYS_MAP.put(DAYS[i], i);
	}
	
	/**
	 * Default constructor for Slot class.
	 */
	Slot() {
		
	}
	
	/**
	 * Constructs and returns an identical Slot object via deep-copying.
	 * @return a Slot object with identical attributes
	 */
	@Override
	public Slot clone() {
		Slot s = new Slot();
		s.day = this.day;
		s.start = this.start;
		s.end = this.end;
		s.venue = this.venue;
		return s;
	}
	
	/**
	 * Concatenates, converts and returns the Slot's day of week, starting time, ending time and venue into a String. 
	 * @return a String which represents the Slot's day of week, starting time, ending time and venue
	 */
	public String toString() {
		return DAYS[day] + start.toString() + "-" + end.toString() + ":" + venue;
	}
	
	/**
	 * Starting hour accessor.
	 * @return the Slot's starting hour in integer
	 */
	public int getStartHour() {
		return start.getHour();
	}
	
	/**
	 * Starting minute accessor.
	 * @return the Slot's starting minute in integer
	 */
	public int getStartMinute() {
		return start.getMinute();
	}
	
	/**
	 * Ending hour accessor.
	 * @return the Slot's ending hour in integer
	 */
	public int getEndHour() {
		return end.getHour();
	}
	
	/**
	 * Ending minute accessor.
	 * @return the Slot's ending minute in integer
	 */
	public int getEndMinute() {
		return end.getMinute();
	}
	
	/**
	 * Starting time accessor.
	 * @return the Slot's starting time in LocalTime
	 */
	public LocalTime getStart() {
		return start;
	}
	
	/**
	 * Starting time mutator.
	 * @param start the starting time to be set
	 */
	public void setStart(String start) {
		this.start = LocalTime.parse(start, DateTimeFormatter.ofPattern("hh:mma", Locale.US));
	}
	
	/**
	 * Ending time accessor.
	 * @return the Slot's ending time in LocalTime
	 */
	public LocalTime getEnd() {
		return end;
	}
	
	/**
	 * Ending time mutator.
	 * @param end the ending time to be set
	 */
	public void setEnd(String end) {
		this.end = LocalTime.parse(end, DateTimeFormatter.ofPattern("hh:mma", Locale.US));
	}
	
	/**
	 * Venue accessor.
	 * @return the Slot's venue
	 */
	public String getVenue() {
		return venue;
	}
	
	/**
	 * Venue mutator
	 * @param venue the Slot's venue to be set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * Day of week accessor.
	 * @return the Slot's day of week
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Day of week mutator.
	 * @param day the Slot's day of week to be set
	 */
	public void setDay(int day) {
		this.day = day;
	}

}