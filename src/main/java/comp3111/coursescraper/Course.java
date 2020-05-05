package comp3111.coursescraper;

/**
 * Course class defines every courses scraped from the HKUST Class Schedule and Quota page. Each Course object is uniquely identified by a unique course code following the format (4 block letters) (4 digits)(optional: 1 block letter) (e.g. "COMP 3111H"). Each valid course contains at least 1 Section.
 * <br><br>
 * A Course object provides methods for data manipulation between its own type.
 * @author lky-bulbasaur
 */

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
	
	/**
	 * Default constructor for Course class.
	 */
	public Course() {
		sections = new Section[DEFAULT_MAX_SECTION];
		for (int i = 0; i < DEFAULT_MAX_SECTION; i++) sections[i] = null;
		numSection = 0;
		isCC = false;
	}
	
	/**
	 * Constructs and returns an identical Course object via deep-copying.
	 * @return a Course object with identical attributes
	 */
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
	
	/**
	 * Constructs and returns a Course object with identical attributes except the Sections it owns. The new Course object owns no Sections.
	 * @return a Course object with identical attributes but owns no Sections
	 */
	public Course cloneWithoutSections() {
		Course c = new Course();
		c.title = this.title;
		c.code = this.code;
		c.description = this.description;
		c.exclusion = this.exclusion;
		c.isCC = this.isCC;
		return c;
	}
	
	/**
	 * Constructs and adds a Section object to the List of Sections of the current Course object. If the maximum number of Sections has been reached, do nothing.
	 * @param s the Section object to be added to the List of Sections of this Course object
	 */
	public void addSection(Section s) {
		if (numSection >= DEFAULT_MAX_SECTION) {
			return;
		}
		sections[numSection++] = s.clone();
	}
	
	/**
	 * Section accessor. Returns the Section object stored in index <em>i</em> of the List of Sections of the current Course object. If the index <em>i</em> is out-of-bound, return null.
	 * @param i the index of the Section to be retrieved
	 * @return the required Section object if index <em>i</em> is within-bound; null otherwise
	 */
	public Section getSection(int i) {
		if (i >= 0 && i < numSection) {
			return sections[i];
		}
		return null;
	}
	
	/**
	 * Section accessor. Returns the Section object owned by the current Course object with section-ID matching <em>id</em>. If no matches are found, return null.
	 * @param id the section-ID of the Section to be retrieved
	 * @return the required Section object if found; null otherwise
	 */
	public Section getSection(String id) {
		for (int i = 0; i < getNumSections(); ++i) {
			if (sections[i].getID().contentEquals(id)) {
				return sections[i];
			}
		}
		return null;
	}
	
	/**
	 * Course title accessors.
	 * @return the course title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Course title mutator.
	 * @param title the course title to be set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Course code accessor.
	 * @return the course code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Course code mutator.
	 * @param code the course code to be set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Course description accessor.
	 * @return the course description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Course description mutator.
	 * @param description the course description to be set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Course exclusions accessor.
	 * @return the course exclusions; "null" if the Course defines no exclusion
	 */
	public String getExclusion() {
		return exclusion;
	}

	/**
	 * Course exclusions mutator.
	 * @param exclusion the course exclusions to be set; "null" if the Course defines no exclusion
	 */
	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}

	/**
	 * Section number accessor.
	 * @return the number of Sections the Course has
	 */
	public int getNumSections() {
		return numSection;
	}

	/**
	 * Section number mutator.
	 * @param numSections the nubmer of Section the Course has to be set
	 */
	public void setNumSections(int numSections) {
		this.numSection = numSections;
	}
	
	/**
	 * Common core attribute mutator.
	 * @param flag true if the Course is a 4Y CC; false otherwise
	 */
	public void setIsCC(boolean flag) {
		this.isCC = flag;
	}

	
	/**
	 * Common core attribute accessor.
	 * @return true if this Course is 4Y CC; false otherwise
	 */
	public boolean isCC() {
		return isCC;
	}
	
	/**
	 * Checks if this Course defines exclusion(s).
	 * @return true if this Course has exclusion(s); false otherwise
	 */
	public boolean hasExclusion() {
		if (exclusion.contentEquals("null")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks if this Course contains Sections that are labs or tutorials
	 * @return true if this Course has Sections that are labs or tutorials; false otherwise
	 */
	public boolean hasLabTutorial() {
		for (int i = 0; i < numSection; ++i) {
			if ((sections[i].getSections().contains("LA")) || sections[i].getSections().contains("T")) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the number of valid Sections owned by this Course. A valid Section must possess a section code that starts with either "L", "LA" or "T". For example, "LA1" is a valid Section but "R1" is not.
	 * @return the number of valid Sections owned by this Course.
	 */
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
