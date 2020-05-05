package comp3111.coursescraper;

public class Course {
	private static final int DEFAULT_MAX_SECTION = 100;
	
	private String title ; 
	private String code;
	private String description ;
	private String exclusion;
	private boolean isCC;
	private Section [] sections;
	private int numSection;
	
	/*
	//private static final int DEFAULT_MAX_SLOT = 20;
	private static final int DEFAULT_MAX_SECTION = 40;
	
	private String title ; 
	private String description ;
	private String exclusion;
	private boolean isCC;
	//private Slot [] slots;
	//private int numSlots;
	private Section [] sections;
	private int numSections;
	*/
	
	public Course() {
		sections = new Section[DEFAULT_MAX_SECTION];
		for (int i = 0; i < DEFAULT_MAX_SECTION; i++) sections[i] = null;
		numSection = 0;
		isCC = false;
	}
	
	public Course clone() {
		Course c = new Course();
		c.title = this.title;
		c.code = this.code;
		c.description = this.description;
		c.exclusion = this.exclusion;
		c.isCC = this.isCC;
		c.numSection = this.numSection;
		for (int i = 0; i < numSection; ++i) {
			c.sections[i] = this.sections[i].clone();
		}
		return c;
	}
	
	public Course cloneWithoutSections() {
		Course c = new Course();
		c.title = this.title;
		c.code = this.code;
		c.description = this.description;
		c.exclusion = this.exclusion;
		c.isCC = this.isCC;
		return c;
	}
	
	public void addSection(Section s) {
		if (numSection >= DEFAULT_MAX_SECTION) {
			return;
		}
		sections[numSection++] = s.clone();
	}
	
	public Section getSection(int i) {
		if (i >= 0 && i < numSection) {
			return sections[i];
		}
		return null;
	}
	
	public Section getSection(String id) {
		for (int i = 0; i < getNumSections(); ++i) {
			if (sections[i].getID().contentEquals(id)) {
				return sections[i];
			}
		}
		return null;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	public int getNumSections() {
		return numSection;
	}

	/**
	 * @param numSlots the numSlots to set
	 */
	public void setNumSections(int numSections) {
		this.numSection = numSections;
	}
	
	/**
	 * @param flag the value of isCC to set
	 */
	public void setIsCC(boolean flag) {
		this.isCC = flag;
	}

	
	/**
	 * @return true if this Course is 4Y CC; false if this Course is not 4Y CC
	 */
	public boolean isCC() {
		return isCC;
	}
	
	/**
	 * @return true if this Course has exclusion(s); false if this Course has no exclusions
	 */
	public boolean hasExclusion() {
		if (exclusion.contentEquals("null")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @return true if this Course has labs/tutorials; false if this Coruse has no labs/tutorials
	 */
	public boolean hasLabTutorial() {
		for (int i = 0; i < numSection; ++i) {
			if ((sections[i].getSections().contains("LA")) || sections[i].getSections().contains("T")) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumValidSection() {
		int invalid_count = 0;
		for (int i = 0; i < numSection; ++i) {
			if (!sections[i].isValid()) {
				invalid_count++;
			}
		}
		return numSection - invalid_count;
	}

}