package comp3111.coursescraper;

/**
 * Instructor class defines every instructor belonging to a section.
 * <br><br>
 * Each Instructor contains both the first name and the last name of the instructor.
 * @author thomas-chong
 *
 */
public class Instructor {
	private String firstName;
	private String lastName;

	
	/**
	 * Default constructor for Instructor class.
	 */
	public Instructor() {
		firstName = "";
		lastName = "";
	}
	
	/**
	 * Mutator function to modify instructor name, including first and last name.
	 * @param firstName: firstName variable of String type
	 * @param lastName: lastName variable of String type
	 */
	public void setInstructor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Constructs and returns an identical Instructor object via deep-copying.
	 * @return a Instructor object with identical attributes
	 */
	public Instructor clone() {
		Instructor in = new Instructor();
		in.firstName = this.firstName;
		in.lastName = this.lastName;
		return in;
	}
	
	/**
	 * Accessor function to obtain first name.
	 * @return firstName of String type
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Accessor function to obtain last name.
	 * @return lastName of String type
	 */
	public String getLastName() {
		return lastName;
	}
}