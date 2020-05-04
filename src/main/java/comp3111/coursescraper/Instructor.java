package comp3111.coursescraper;

public class Instructor {
	private String firstName;
	private String lastName;
	
	public Instructor() {
		firstName = "";
		lastName = "";
	}
	
	public void setInstructor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Instructor clone() {
		Instructor in = new Instructor();
		in.firstName = this.firstName;
		in.lastName = this.lastName;
		return in;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}