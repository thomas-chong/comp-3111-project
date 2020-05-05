package comp3111.coursescraper;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Vector;
import java.util.Collections;
import java.util.List;
public class Controller {
	Filter filter = new Filter();
	List<Course> courseList;
	List<Course> filteredCourseList;
	boolean twiceClick = false;

    @FXML
    private Tab tabMain;

    @FXML
    private TextField textfieldTerm;

    @FXML
    private TextField textfieldSubject;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField textfieldURL;

    @FXML
    private Tab tabStatistic;

    @FXML
    private ComboBox<?> comboboxTimeSlot;
    
    /*	=== === === === === === === === === === === === === === === === 
     * 		UI Elements for Filter Tab
     * 	=== === === === === === === === === === === === === === === === 
     */
    @FXML
    private Tab tabFilter;
    
    @FXML
    private CheckBox checkboxAM;

    @FXML
    private CheckBox checkboxPM;

    @FXML
    private CheckBox checkboxMon;

    @FXML
    private CheckBox checkboxTue;

    @FXML
    private CheckBox checkboxWed;

    @FXML
    private CheckBox checkboxThu;

    @FXML
    private CheckBox checkboxFri;

    @FXML
    private CheckBox checkboxSat;

    @FXML
    private Button buttonSelectAll;

    @FXML
    private CheckBox checkboxCC;

    @FXML
    private CheckBox checkboxNoExclusion;

    @FXML
    private CheckBox checkboxLabTutorial;

    /*	=== === === === === === === === === === === === === === === === 
     * 		UI Elements for List Tab
     * === === === === === === === === === === === === === === === === 
     */
    @FXML
    private Tab tabList;

    @FXML
    private Tab tabTimetable;

    @FXML
    private Tab tabAllSubject;

    @FXML
    private ProgressBar progressbar;

    @FXML
    private TextField textfieldSfqUrl;

    @FXML
    private Button buttonSfqEnrollCourse;

    @FXML
    private Button buttonInstructorSfq;

    @FXML
    private TextArea textAreaConsole;
    
    private Scraper scraper = new Scraper();
    
    @FXML
    void allSubjectSearch() {
    	int ALL_SUBJECT_COUNT = 0;
    	int TOTAL_NUMBER_OF_COURSES = 0;
    	
    	List<String> subjectList = scraper.scrapeSubject(textfieldURL.getText(), textfieldTerm.getText());
    	
    	if (subjectList == null) {
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Error 404. Please check your input again.");
    	}
    	
    	ALL_SUBJECT_COUNT = subjectList.size();
    	
    	textAreaConsole.setText("Total Number of Categories/Code Prefix: " + ALL_SUBJECT_COUNT + "\n\n");
    	
    	if (twiceClick) {
    		Vector<Course> result = new Vector<Course>();
	    		
	    	int count = 0;
	    	for (String subject : subjectList) {
	    				
	    		List<Course> temp = scraper.scrape(textfieldURL.getText(), textfieldTerm.getText(),subject);
	    		
	    		for (Course a : temp) {
	    			result.add(a);
	    		}
	    		
	    		System.out.println("SUBJECT is done.");
	    		progressbar.setProgress(++count/ALL_SUBJECT_COUNT);
	    	}
	    	
	    	courseList = result;
	    	
	    	TOTAL_NUMBER_OF_COURSES = courseList.size();
	    	textAreaConsole.setText(textAreaConsole.getText() + "Total Number of Courses fetched:  " + TOTAL_NUMBER_OF_COURSES + "\n\n");
    	}
    	
    	if (!twiceClick) {
    		twiceClick = true;
    	}

    	
    	
    }

    @FXML
    void findInstructorSfq() {
    	buttonInstructorSfq.setDisable(true);
    }

    @FXML
    void findSfqEnrollCourse() {	
    	
    }

    @FXML
    void search() {
    	int NUMBER_OF_SECTIONS = 0;
    	int NUMBER_OF_COURSES = 0;
    	
    	courseList = scraper.scrape(textfieldURL.getText(), textfieldTerm.getText(),textfieldSubject.getText());
    	
    	if (courseList == null) {
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Error 404. Please check your input again.");
    	}
    	
    	for (Course c : courseList) {
    		String newline = c.getTitle() + "\n";
    		boolean courseCount = true;
    		int counter = 0;
    		for (int i = 0; i < c.getNumSections(); i++) {
    			Section s = c.getSection(i);
    			for (int j = 0; j < s.getNumSlots(); j++) {
    				Slot t = s.getSlot(j);
    				newline += "Slot " + counter + ":" + t + "\n" + s.getSections() + " (" + s.getID() + ")\n";
    				counter++;
    			}
    			if (!s.isValid()) {
    				courseCount = false;
    			}
    		}
    		if (courseCount) {
    			NUMBER_OF_COURSES++;
    		}
    		NUMBER_OF_SECTIONS += c.getNumSections();
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + newline);
    	}
    	
    	Vector<String> instructorList = new Vector<String>();
    	Vector<String> uniqueInstructorList = new Vector<String>();
    	Vector<String> blackList = new Vector<String>();
    	
    	for (Course c : courseList) {
    		for (int i = 0; i < c.getNumSections(); i++) {
    			Section s = c.getSection(i);
    			int targetTime = 15*60 + 10;
    			for (int j = 0; j < s.getNumSlots(); j++) {
    				
    				int day = s.getSlot(j).getDay();
    				int startHour = s.getSlot(j).getStartHour();
    				int endHour = s.getSlot(j).getEndHour();
    				int startMinute = s.getSlot(j).getStartMinute();
    				int endMinute = s.getSlot(j).getEndMinute();
    				
    				
    				for (int k = 0; k < s.getNumInstructors(); k++) {
    					String name = s.getInstructor(k).getLastName() + ", " + s.getInstructor(k).getFirstName();
    					instructorList.add(name);
					}
    			}
    		}
    	}
    	
    	for (String a : instructorList) {
    		String temp = a;
    		temp = temp.trim();
    		if (!uniqueInstructorList.contains(temp) && !temp.equals("null, null")) {
    			uniqueInstructorList.add(temp);
    		}
    	}
    	
    	for (Course c : courseList) {
    		for (int i = 0; i < c.getNumSections(); i++) {
    			Section s = c.getSection(i);
    			int targetTime = 15*60 + 10;
    			for (int j = 0; j < s.getNumSlots(); j++) {
    				int day = s.getSlot(j).getDay();
    				int startHour = s.getSlot(j).getStartHour();
    				int endHour = s.getSlot(j).getEndHour();
    				int startMinute = s.getSlot(j).getStartMinute();
    				int endMinute = s.getSlot(j).getEndMinute();
    				
    				if (day == 1 && (startHour * 60 + startMinute) <= targetTime && (endHour * 60 + endMinute) >= targetTime) {
    					for (int k = 0; k < s.getNumInstructors(); k++) {
    						String name = s.getInstructor(k).getLastName() + ", " + s.getInstructor(k).getFirstName();
    						name = name.trim();
        					if (!blackList.contains(name)) {
        						blackList.add(name);
        					}			
    					}
    				}
    			}
    		}
    	}
    	
    	Collections.sort(uniqueInstructorList);
    	
    	textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Total Number of difference sections in this search: " + NUMBER_OF_SECTIONS);
    	textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Total Number of Course in this search: " + NUMBER_OF_COURSES);
    	
    	String output = "";
    	for (String a : uniqueInstructorList) {
    		if (!blackList.contains(a)) {
    			output += a + ", \n";
    		}
    		else {
    			System.out.println(a);
    		}
    		
    	}
	
    	textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Display Instructors who has teaching assignment this term but does not need to teach at Tu 3:10pm: "+ "\n" + output);
    	
    	//Add a random block on Saturday
    	AnchorPane ap = (AnchorPane)tabTimetable.getContent();
    	Label randomLabel = new Label("COMP1022\nL1");
    	Random r = new Random();
    	double start = (r.nextInt(10) + 1) * 20 + 40;

    	randomLabel.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    	randomLabel.setLayoutX(600.0);
    	randomLabel.setLayoutY(start);
    	randomLabel.setMinWidth(100.0);
    	randomLabel.setMaxWidth(100.0);
    	randomLabel.setMinHeight(60);
    	randomLabel.setMaxHeight(60);
    
    	ap.getChildren().addAll(randomLabel);
    }
  
    /*	=== === === === === === === === === === === === === === === === 
     * 		Actions for Filter Tab
     * === === === === === === === === === === === === === === === === 
     */
    void printConsole(List<Course> courseList) {
    	textAreaConsole.setText("");
    	for (Course c : courseList) {
    		String newline = c.getTitle() + "\n";
    		for (int i = 0; i < c.getNumSections(); i++) {
    			int counter = 0;
    			Section s = c.getSection(i);
    			newline += "\tSection " + s.getSections() + "\tInstructor: ";
    			for (int j = 0; j < s.getNumInstructors(); ++j) {
    				if (s.getInstructor(j).getLastName().contentEquals("null")) {
    					newline += "TBA";
    				} else {
    					newline += s.getInstructor(j).getLastName() + ", " + s.getInstructor(j).getFirstName();
    				}
    				if (j + 1 != s.getNumInstructors()) {
    					newline += ", ";
    				}
    			}
    			newline += "\n";
    			for (int j = 0; j < s.getNumSlots(); j++) {
    				Slot t = s.getSlot(j);
    				newline += "\t\tSlot " + counter + "\t" + t + "\n";
    				counter++;
    			}
    		}
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + newline);
    	}
    }
    
    @FXML
    void buttonSelectAllPressed() {
    	if (buttonSelectAll.getText().contentEquals("Select All")) {
    		checkboxAM.setSelected(true);
    		checkboxPM.setSelected(true);
    		checkboxMon.setSelected(true);
    		checkboxTue.setSelected(true);
    		checkboxWed.setSelected(true);
    		checkboxThu.setSelected(true);
    		checkboxFri.setSelected(true);
    		checkboxSat.setSelected(true);
    		checkboxCC.setSelected(true);
    		checkboxLabTutorial.setSelected(true);
    		checkboxNoExclusion.setSelected(true);
    		buttonSelectAll.setText("De-select All");
    	} else {
    		checkboxAM.setSelected(false);
    		checkboxPM.setSelected(false);
    		checkboxMon.setSelected(false);
    		checkboxTue.setSelected(false);
    		checkboxWed.setSelected(false);
    		checkboxThu.setSelected(false);
    		checkboxFri.setSelected(false);
    		checkboxSat.setSelected(false);
    		checkboxCC.setSelected(false);
    		checkboxLabTutorial.setSelected(false);
    		checkboxNoExclusion.setSelected(false);
    		buttonSelectAll.setText("Select All");
    	}
    	checkboxAMChecked();
    	checkboxPMChecked();
    	checkboxMonChecked();
    	checkboxTueChecked();
    	checkboxWedChecked();
    	checkboxThuChecked();
    	checkboxFriChecked();
    	checkboxSatChecked();
    	checkboxCCChecked();
    	checkboxLabTutorialChecked();
    	checkboxNoExclusionChecked();
    }

    @FXML
    void checkboxAMChecked() {
    	filter.setFilter(filterType.AM, checkboxAM.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxCCChecked() {
    	filter.setFilter(filterType.CC, checkboxCC.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxFriChecked() {
    	filter.setFilter(filterType.FRI, checkboxFri.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxLabTutorialChecked() {
    	filter.setFilter(filterType.LAB_TUTORIAL, checkboxLabTutorial.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxMonChecked() {
    	filter.setFilter(filterType.MON, checkboxMon.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxNoExclusionChecked() {
    	filter.setFilter(filterType.NO_EXCLUSION, checkboxNoExclusion.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxPMChecked() {
    	filter.setFilter(filterType.PM, checkboxPM.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxSatChecked() {
    	filter.setFilter(filterType.SAT, checkboxSat.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxThuChecked() {
    	filter.setFilter(filterType.THU, checkboxThu.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxTueChecked() {
    	filter.setFilter(filterType.TUE, checkboxTue.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

    @FXML
    void checkboxWedChecked() {
    	filter.setFilter(filterType.WED, checkboxWed.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	printConsole(filteredCourseList);
    }

}