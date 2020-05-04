package comp3111.coursescraper;

enum timeType {AM, PM}
enum dayType {MON, TUE, WED, THU, FRI, SAT}

public class Section{
	private static final int DEFAULT_MAX_SLOT = 10;
	private static final int DEFAULT_MAX_INSTRUCTOR = 20;
	private String section;
	private String id;
	private Slot [] slots;
	private int numSlots;
	private Instructor [] instructor;
	private int numInstructor;
	
	public Section() {
		slots = new Slot[DEFAULT_MAX_SLOT];
		for (int i = 0; i < DEFAULT_MAX_SLOT; i++) slots[i] = null;
		numSlots = 0;
		instructor = new Instructor[DEFAULT_MAX_INSTRUCTOR];
		for (int i = 0; i < DEFAULT_MAX_INSTRUCTOR; i++) instructor[i] = null;
	}
	
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
	
	public void setSection(String section) {
		this.section = section;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getSections() {
		return section;
	}
	
	public String getID() {
		return id;
	}
	
	public void addSlot(Slot s) {
		if (numSlots >= DEFAULT_MAX_SLOT)
			return;
		slots[numSlots++] = s.clone();
	}
	
	public Slot getSlot(int i) {
		if (i >= 0 && i < numSlots)
			return slots[i];
		return null;
	}
	
	public int getNumSlots() {
		return numSlots;
	}
	
	public int getNumInstructors() {
		return numInstructor;
	}
	
	public Instructor getInstructor(int i) {
		if (i >= 0 && i < numInstructor)
			return instructor[i];
		return null;
	}
	
	public void addInstructor(Instructor in) {
		if (numInstructor >= DEFAULT_MAX_INSTRUCTOR) {
			return;
		}
		instructor[numInstructor++] = in.clone();
	}
	
	/**
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
	
}
