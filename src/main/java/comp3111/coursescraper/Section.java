package comp3111.coursescraper;

enum timeType {AM, PM}
enum dayType {MON, TUE, WED, THU, FRI, SAT}

/**
 * Section class defines every sections belonging to a course. Each Section object is uniquely identified with a unique 4-digit section-ID (e.g. 1808). Within each Course, a Section object can be uniquely identified with a section code (e.g. "LA1"). A valid Section must have a section code that either starts with "L", "LA" or "T", and has at most 3 Slots. All other Sections are considered invalid and will be ignored.
 * <br><br>
 * Two sets of more readable enumerations <em>timeType</em> and <em>dayType</em> have been defined for more intuitive data access. These include:
 * <ul>
 * 	<li><em>AM</em>, which represents "time in AM"</li>
 * 	<li><em>PM</em>, which represents "time in PM"</li>
 * 	<li><em>MON</em>, which represents "Monday"</li>
 * 	<li><em>TUE</em>, which represents "Tuesday"</li>
 * 	<li><em>WED</em>, which represents "Wednesday"</li>
 * 	<li><em>THU</em>, which represents "Thursday"</li>
 * 	<li><em>FRI</em>, which represents "Friday"</li>
 * 	<li><em>SAT</em>, which represents "Saturday"</li>
 * </ul>
 * <br>
 * A Section object provides methods for data manipulation between its own type. 
 * @author lky-bulbasaur
 *
 */

public class Section{
	private static final int DEFAULT_MAX_SLOT = 3;
	private static final int DEFAULT_MAX_INSTRUCTOR = 20;
	private String section;
	private String id;
	private Slot [] slots;
	private int numSlots;
	private Instructor [] instructor;
	private int numInstructor;
	
	/**
	 * Default constructor for Section class.
	 */
	public Section() {
		slots = new Slot[DEFAULT_MAX_SLOT];
		for (int i = 0; i < DEFAULT_MAX_SLOT; i++) slots[i] = null;
		numSlots = 0;
		instructor = new Instructor[DEFAULT_MAX_INSTRUCTOR];
		for (int i = 0; i < DEFAULT_MAX_INSTRUCTOR; i++) instructor[i] = null;
	}

	/**
	 * Constructs and returns an identical Section object via deep-copying.
	 * @return a Section object with identical attributes
	 */
	public Section clone() {
		Section s = new Section();
		s.section = this.section;
		s.id = this.id;
		s.numSlots = this.numSlots;
		s.numInstructor = this.numInstructor;
		for (int i = 0; i < s.numSlots; ++i) {
			s.slots[i] = this.slots[i].clone();
		}
		for (int i = 0; i < s.numInstructor; ++i) {
			s.instructor[i] = this.instructor[i].clone();
		}
		return s;
	}
	
	/**
	 * Section code mutator.
	 * @param section the section code to be set
	 */
	public void setSection(String section) {
		this.section = section;
	}
	
	/**
	 * Section-ID mutator.
	 * @param id the section-ID to be set
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * Section code accessor.
	 * @return the section code of this Section
	 */
	public String getSections() {
		return section;
	}
	
	/**
	 * Section-ID accessor.
	 * @return the section-ID of this Section
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Constructs and adds a Slot object to the List of Slots of the current Section object. If the maximum number of Slots has been reached, do nothing.
	 * @param s the Slot object to be added to the List of Slots of this Section
	 */
	public void addSlot(Slot s) {
		if (numSlots >= DEFAULT_MAX_SLOT)
			return;
		slots[numSlots++] = s.clone();
	}
	
	/**
	 * Slot accessor. Returns the Slot object stored in index <em>i</em> of the List of Slots of the current Section object. If the index <em>i</em> is out-of-bound, return null.
	 * @param i the index of the Slot to be retrieved
	 * @return the required Slot object if index <em>i</em> is within-bound; null otherwise
	 */	
	public Slot getSlot(int i) {
		if (i >= 0 && i < numSlots)
			return slots[i];
		return null;
	}
	
	/**
	 * Slot number accessor.
	 * @return the number of Slots owned by this Section
	 */
	public int getNumSlots() {
		return numSlots;
	}
	
	/**
	 * Instructor number accessor.
	 * @return the number of Instructors teaching this Section
	 */
	public int getNumInstructors() {
		return numInstructor;
	}
	
	/**
	 * Instructor accessor. Returns the Instructor object stored in index <em>i</em> of the List of Instructors of the current Section object. If the index <em>i</em> is out-of-bound, return null.
	 * @param i the index of the Instructor to be retrieved
	 * @return the required Instructor object if index <em>i</em> is within-bound; null otherwise
	 */		
	public Instructor getInstructor(int i) {
		if (i >= 0 && i < numInstructor)
			return instructor[i];
		return null;
	}

	/**
	 * Constructs and adds an Instructor object to the List of Instructors of the current Section object. If the maximum number of Instructors has been reached, do nothing.
	 * @param in the Instructor object to be added to the List of Instructors of this Section
	 */
	public void addInstructor(Instructor in) {
		if (numInstructor >= DEFAULT_MAX_INSTRUCTOR) {
			return;
		}
		instructor[numInstructor++] = in.clone();
	}
	
	/**
	 * Checks if this Section contains any Slots on the selected day of week.
	 * @param selection the target day of week
	 * @return true if this Section that has Slot(s) on the target day of week; false otherwise
	 */
	public boolean hasDay(dayType selection) {
		int selection_int = selection.ordinal();
		for (int i = 0; i < getNumSlots(); ++i) {
			if (selection_int == getSlot(i).getDay()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if this Section contains any Slots at the selected time of day.
	 * @param selection the target time of day (AM/PM)
	 * @return true if this Section has Slots in the target time of day; false otherwise
	 */
	public boolean hasTime(timeType selection) {
		int selection_int = selection.ordinal();
		if (selection_int == 0) {	// Check for slots with starting time in AM
			//12:00 is PM
			for (int i = 0; i < getNumSlots(); ++i) {
				if (getSlot(i).getStartHour() < 12) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < getNumSlots(); ++i) {
				if (getSlot(i).getEndHour() >= 12) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if this Section is valid.
	 * @return true if this Section is valid; false otherwise
	 */
	public boolean isValid() {
		if (section.contains("L") || section.contains("LA") || section.contains("T")) {
			return true;
		}
		return false;
	}
	
}
