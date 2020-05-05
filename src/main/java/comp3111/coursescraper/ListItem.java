package comp3111.coursescraper;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class ListItem {
	private final SimpleStringProperty code;
	private final SimpleStringProperty sectionName;
	private final SimpleStringProperty courseName;
	private final SimpleStringProperty instructorName;
	private CheckBox isEnrolled;
	
	private Course course;
	private Section section;
	
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
	 * @return the Course code
	 */
	public String getCode() {
		return code.get();
	}
	
	/**
	 * @param n the Course code to set
	 */
	public void setCode(String n) {
		code.set(n);
	}
	
	/**
	 * @return the Section name
	 */
	public String getSectionName() {
		return sectionName.get();
	}
	
	/**
	 * @param n the Section name to set
	 */
	public void setSectionName(String n) {
		sectionName.set(n);
	}
	
	/**
	 * @return the Course name
	 */
	public String getCourseName() {
		return courseName.get();
	}
	
	/**
	 * @param n the Course name to set
	 */
	public void setCourseName(String n) {
		courseName.set(n);
	}
	
	/**
	 * @return the Instructor name
	 */
	public String getInstructorName() {
		return instructorName.get();
	}
	
	/**
	 * @param n the Instructor name to set
	 */
	public void setInstructorName(String n) {
		instructorName.set(n);
	}
	
	/**
	 * @return the Course's enrollment status checkbox
	 */
	public CheckBox getIsEnrolled() {
		return isEnrolled;
	}
	
	/**
	 * @param n the Course's enrollment status checkbox to set
	 */
	public void setIsEnrolled(CheckBox n) {
		this.isEnrolled = n;
	}
	
}
