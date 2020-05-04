package comp3111.coursescraper;



public class Course {
	private static final int DEFAULT_MAX_SECTION = 100;
	
	private String title ; 
	private String description ;
	private String exclusion;
	/*private Slot [] slots;
	private int numSlots;*/
	private Section [] s;
	private int numSection;
	
	
	public Course() {
		//slots = new Slot[DEFAULT_MAX_SLOT];
		//for (int i = 0; i < DEFAULT_MAX_SLOT; i++) slots[i] = null;
		//numSlots = 0;
	}
	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the exclusion
	 */
	public String getExclusion() {
		return exclusion;
	}

	/**
	 * @param exclusion the exclusion to set
	 */
	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}

	/**
	 * @return the numSlots
	 */
	public int getNumSlots() {
		return numSlots;
	}

	/**
	 * @param numSlots the numSlots to set
	 */
	public void setNumSlots(int numSlots) {
		this.numSlots = numSlots;
	}
	
	public void addSection(Section section) {
		if (numSection >= DEFAULT_MAX_SECTION)
			return;
		s[numSection] = section.clone();
		numSection++;
	}
	
	
	

}
