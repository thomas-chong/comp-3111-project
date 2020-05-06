package comp3111.coursescraper;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

/**
 * ListItem class is a container class for storing data in JavaFx TableView UI element. Each ListItem object constitutes a record in TableView. Each record describes a Section object using 5 fields:
 * <ul>
 * 	<li><em>Course Code</em>, a String field which represents the unique course code of each Course (e.g. "COMP 3111")</li>
 * 	<li><em>Section</em>, a String field which represents the unique section code of each Section (e.g. "L1")</li>
 * 	<li><em>Course Title</em>, a String field which represents the course title and the credit units of a Course (e.g. "Software Engineering (4 units)")</li>
 * 	<li><em>Instructor</em>, a String field which represents the name of Instructor(s) of a Section (e.g. "LEUNG, Wai Ting")</li>
 * 	<li><em>isEnrolled</em>, a CheckBox field which represents and allows the changing of the enrollment status of a Course</li>
 * </ul>
 * <br>
 * Each ListItem object contains references to its corresponding Section and Course stored in other List of Courses. Each ListItem object can be uniquely identified with a 4-digit section-ID retrieved from its associated Section object. Enrollment status can be preserved at object instantiation.
 * @author lky-bulbasaur
 */

public class ListItem {
	private final SimpleStringProperty code;
	private final SimpleStringProperty sectionName;
	private final SimpleStringProperty courseName;
	private final SimpleStringProperty instructorName;
	private CheckBox isEnrolled;
	
	private Course course;
	private Section section;
	
	/**
	 * General constructor of ListItem class. Constructs and returns a ListItem object that defines a Section in a format displayable in JavaFx TableView UI elements. Enrollment status can be preserved by passing true to <em>enrolled</em> at instantiation when invoking other methods.
	 * @param c the reference to a Course to which the Section belongs; a dynamically-allocated Course object should be passed into this parameter
	 * @param s the reference to a Section; a dynamically-allocated Section object should be passed into this parameter
	 * @param enrolled true if this ListItem object represents a Section enrolled by the user; false otherwise
	 */
	public ListItem(Course c, Section s, boolean enrolled) {
		this.course = c;		// Shallow copy
		this.section = s;		// Shallow copy
		this.code = new SimpleStringProperty(c.getCode());
		this.sectionName = new SimpleStringProperty(s.getSections());
		this.courseName = new SimpleStringProperty(c.getTitle());
		String t = "";
		for (int i = 0; i < s.getNumInstructors(); ++i) {
			if (s.getInstructor(i).getLastName().contentEquals("null")) {
				t += "TBA";
			} else {
				t += s.getInstructor(i).getLastName() + ", " + s.getInstructor(i).getFirstName();
			}
			if (i + 1 != s.getNumInstructors()) {
				t += "\n";
			}
		}
		this.instructorName = new SimpleStringProperty(t);
		this.isEnrolled = new CheckBox();
		this.isEnrolled.setSelected(enrolled);
	}
	
	/**
	 * Course code accessor.
	 * @return the course code of the Course to which the Section belongs
	 */
	public String getCode() {
		return code.get();
	}
	
	/**
	 * Course code mutator.
	 * @param n the course code to be set
	 */
	public void setCode(String n) {
		code.set(n);
	}
	
	/**
	 * Section code accessor.
	 * @return the section code of the Section
	 */
	public String getSectionName() {
		return sectionName.get();
	}
	
	/**
	 * Section code mutator.
	 * @param n the section code to be set
	 */
	public void setSectionName(String n) {
		sectionName.set(n);
	}
	
	/**
	 * Course title accessor.
	 * @return the title of the Course to which the Section belongs
	 */
	public String getCourseName() {
		return courseName.get();
	}
	
	/**
	 * Course title mutator.
	 * @param n the course title to be set
	 */
	public void setCourseName(String n) {
		courseName.set(n);
	}
	
	/**
	 * Instructor name accessor.
	 * @return the full name of the Instructor of the Section
	 */
	public String getInstructorName() {
		return instructorName.get();
	}
	
	/**
	 * Instructor name mutator.
	 * @param n the Instructor's full name to be set
	 */
	public void setInstructorName(String n) {
		instructorName.set(n);
	}
	
	/**
	 * Enrollment status checkbox accessor.
	 * @return the Course's enrollment status checkbox
	 */
	public CheckBox getIsEnrolled() {
		return isEnrolled;
	}
	
	/**
	 * Enrollment status checkbox mutator.
	 * @param n the Course's enrollment status checkbox to be set
	 */
	public void setIsEnrolled(CheckBox n) {
		this.isEnrolled = n;
	}
	
}
