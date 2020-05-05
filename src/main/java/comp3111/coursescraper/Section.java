package comp3111.coursescraper;

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
		for (int i = 0; i < DEFAULT_MAX_SLOT; i++) {
			slots[i] = null;
		}
		numSlots = 0;
		for (int i = 0; i < DEFAULT_MAX_INSTRUCTOR; i++) {
			instructor[i] = null;
		}
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
	
	public void addInstructor(Instructor instructor) {
		if (numInstructor) {
			
		}
		numInstructor++;
	}
	
	
}




