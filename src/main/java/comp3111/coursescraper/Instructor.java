package comp3111.coursescraper;

public class Instructor {
	private String firstName;
	private String lastName;
	
	void Instructor() {
		firstName = "";
		lastName = "";
	}
	
	public void setInstructor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
