package comp3111.coursescraper;
/**
 * SFQ class to store sets of SFQ information scrapped from the SFQ website.
 * Each SFQ object contains either the course title or the instructor, as well as the SFQ score.
 * @author justinlyli
 * 
 */
public class SFQ {
	private String title;
	private String instructor;
	private double sfq;
	
	/**
	 * Default constructor for SFQ class.
	 */
	public SFQ() {
		title = "";
		instructor = "";
		sfq = 0;
	}
	
	/**
	 * Constructor by directly passing the title, instructor and SFQ score to the new SFQ object.
	 * @param t: Course title
	 * @param i: Instructor
	 * @param s: SFQ score
	 */
	public SFQ(String t, String i, double s) {
		title = t;
		instructor = i;
		sfq = s;
	}
	
	/**
	 * Mutator function to modify course title.
	 * @param t: Course title variable of String type
	 */
	public void setTitle(String t) {
		title = t;
	}
	
	/**
	 * Accessor function to obtain course title.
	 * @return Course title of String type
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Mutator function to modify instructor.
	 * @param i: Instructor variable of String type
	 */
	public void setInstructor(String i) {
		instructor = i;
	}
	
	/**
	 * Accessor function to obtain instructor.
	 * @return Instructor of String type
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * Mutator function to modify SFQ score.
	 * @param s: SFQ score variable of double type
	 */
	public void setSFQ(double s) {
		sfq = s;
	}
	
	/**
	 * Accessor function to obtain SFQ score.
	 * @return SFQ score of double type
	 */
	public double getSFQ() {
		return sfq;
	}
	
	/**
	 * Mutator function to clear and reset all class members
	 */
	public void clear() {
		title = "";
		instructor = "";
		sfq = 0;
	}
}
