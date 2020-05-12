package comp3111.coursescraper;

import java.awt.event.ActionEvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
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
import java.math.BigDecimal;

/**
 * Placeholder
 * @author
 *
 */

public class Controller {
	Filter filter = new Filter();

	List<Course> courseList = null;
	List<Course> filteredCourseList = null;
	List<Course> enrolledCourseList = new Vector<Course>();
	boolean twiceClick = false;
	List<SFQ> sfqList;
	List<TimetableBlock> blocklist = new Vector<TimetableBlock>();

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
     * 	=== === === === === === === === === === === === === === === === 
     */
    @FXML
    private Tab tabList;
    
    @FXML
    private TableView<ListItem> sectionTable;
    
    @FXML
    private ObservableList<ListItem> sectionTableData;
    
    @FXML
    private TableColumn<ListItem, String> courseCodeCol;
    
    @FXML
    private TableColumn<ListItem, String> sectionCol;

    @FXML
    private TableColumn<ListItem, String> courseNameCol;

    @FXML
    private TableColumn<ListItem, String> instructorCol;

    @FXML
    private TableColumn<ListItem, String> enrollCol;
    
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
    void initialize() {
    	buttonSfqEnrollCourse.setDisable(true);
    }
    
    /**
     *  Fires when button "All Subject Search" is pressed.
     *  Scraps subject and courses data from Base URL and term entered in Main Tab and prints the number of subjects and courses in the console.
     */
    @FXML
    void allSubjectSearch() {
    	int ALL_SUBJECT_COUNT = 0;
    	int TOTAL_NUMBER_OF_COURSES = 0;
    	
    	List<String> subjectList = scraper.scrapeSubject(textfieldURL.getText(), textfieldTerm.getText());
    	
    	if (subjectList == null) {
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Error 404. Please check your input again.");
    	}
    	else {
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

        	buttonSfqEnrollCourse.setDisable(false);
    	}
    	
    	
    	
    }
    
    /**
     *  Fires when button "List instructor's average SFQ" is pressed.
     *  Scraps instructor's SFQ data from SFQ website URL entered above and prints it in the console.
     */
    @FXML
    void findInstructorSfq() {
    	List<SFQ> sfqList = scraper.scrapeInstructorSFQ(textfieldSfqUrl.getText());
    	printSFQConsole(sfqList, true);
    }
    
    /**
     *  Fires when button "Find SFQ with my enrolled courses" is pressed.
     *  Scraps data from SFQ URL entered above, checked with EnrolledCourseList and print data in console.
     */
    @FXML
    void findSfqEnrollCourse() {
    	List<SFQ> sfqList = scraper.scrapeSFQ(textfieldSfqUrl.getText());
    	List<SFQ> sfqEnrolled = new Vector<SFQ>();
    	for (SFQ s: sfqList) {
    		for (Course c: enrolledCourseList)
    			if (s.getTitle().equalsIgnoreCase(c.getCode()) && !sfqEnrolled.contains(s))
    				sfqEnrolled.add(s);
    	} 
    	printSFQConsole(sfqEnrolled, false);
    }

    @FXML
    void search() {
    	int NUMBER_OF_SECTIONS = 0;
    	int NUMBER_OF_COURSES = 0;

    	textAreaConsole.setText("");
    	filteredCourseList = null;
    	courseList = scraper.scrape(textfieldURL.getText(), textfieldTerm.getText(),textfieldSubject.getText());
    	
    	if (courseList == null) {
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Error 404. Please check your input again.");
    	}
    	else {
        	for (Course c : courseList) {
        		String newline = c.getCode() + " - " + c.getTitle() + "\n";
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
        		//else {
        			//System.out.println(a);
        		//}
        		
        	}
    	
        	textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Display Instructors who has teaching assignment this term but does not need to teach at Tu 3:10pm: "+ "\n" + output);
    	}
    	

    	
    	/* Add a random block on Saturday
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
    
    	ap.getChildren().addAll(randomLabel); */
    	
    	buttonSfqEnrollCourse.setDisable(false);   // For Task 6: SFQ
    }
  
    /*	=== === === === === === === === === === === === === === === === 
     * 		Actions for Filter Tab
     * === === === === === === === === === === === === === === === === 
     */
    
    /**
     * Prints filtered course informations on the console. The filtered course information includes course code, course title, section code, section-ID, section instructors and slot information.
     * @param courseList the List of Courses to be printed
     */
    void filterPrintConsole(List<Course> courseList) {
    	textAreaConsole.setText(textAreaConsole.getText() + "Displaying filtered courses:\n");
    	if (courseList == null) return;
    	
    	for (Course c : courseList) {
    		if (c.getNumValidSection() > 0) {
	    		String newline = c.getCode() + " - " + c.getTitle() + "\n";
	    		for (int i = 0; i < c.getNumSections(); i++) {
	    			int counter = 1;
	    			Section s = c.getSection(i);
	    			if (s.isValid()) {
		    			newline += "\tSection " + s.getSections() + " (" + s.getID() + ")\t\tInstructor: ";
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
	    			}
	    			for (int j = 0; j < s.getNumSlots(); j++) {
	    				Slot t = s.getSlot(j);
	    				newline += "\t\tSlot " + counter + "\t" + t + "\n";
	    				counter++;
	    			}
	    		} 	
	    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + newline);
    		}
    	}
    }
    

    /* printConsole function for SFQ */
    void printSFQConsole(List<SFQ> sfqList, boolean instructor) {
    	textAreaConsole.setText("");
    	textAreaConsole.setText((instructor? "Instructor":"Course") + "\t\t\t" + "(Average) SFQ Score");
    	for (SFQ s : sfqList) {
    		String newline = (instructor? s.getInstructor():s.getTitle()) + "\t\t" + (Math.round(s.getSFQ() * 10000.0) / 10000.0);
    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + newline);
    	}
    }

    /**
     * Fires when the button "Select All" or "De-select All" is pressed. When "Select All" is pressed, all checkboxes in the Filter tab are checked, and the button becomes "De-select All".
     * <br><br>
     * When "De-select All" is pressed, all checkboxes in the Filter tab are unchecked, and the button becomes "Select All".
     * <br><br>
     * Either way, this method fires the onSelect() method of all checkboxes at last in the Filter tab.
     */
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
    
    /**
     * Fires when the checkbox "AM" is checked/unchecked. It applies/unapplies the "AM" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxAMChecked() {
    	filter.setFilter(filterType.AM, checkboxAM.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }
    
    /**
     * Fires when the checkbox "CC" is checked/unchecked. It applies/unapplies the "CC" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxCCChecked() {
    	filter.setFilter(filterType.CC, checkboxCC.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }
    
    /**
     * Fires when the checkbox "FRI" is checked/unchecked. It applies/unapplies the "FRI" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxFriChecked() {
    	filter.setFilter(filterType.FRI, checkboxFri.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "LAB_TUTORIAL" is checked/unchecked. It applies/unapplies the "LAB_TUTORIAL" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxLabTutorialChecked() {
    	filter.setFilter(filterType.LAB_TUTORIAL, checkboxLabTutorial.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "MON" is checked/unchecked. It applies/unapplies the "MON" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxMonChecked() {
    	filter.setFilter(filterType.MON, checkboxMon.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "NO_EXCLUSION" is checked/unchecked. It applies/unapplies the "NO_EXCLUSION" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxNoExclusionChecked() {
    	filter.setFilter(filterType.NO_EXCLUSION, checkboxNoExclusion.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "PM" is checked/unchecked. It applies/unapplies the "PM" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxPMChecked() {
    	filter.setFilter(filterType.PM, checkboxPM.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "SAT" is checked/unchecked. It applies/unapplies the "SAT" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxSatChecked() {
    	filter.setFilter(filterType.SAT, checkboxSat.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "THU" is checked/unchecked. It applies/unapplies the "THU" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxThuChecked() {
    	filter.setFilter(filterType.THU, checkboxThu.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "TUE" is checked/unchecked. It applies/unapplies the "TUE" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxTueChecked() {
    	filter.setFilter(filterType.TUE, checkboxTue.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }

    /**
     * Fires when the checkbox "WED" is checked/unchecked. It applies/unapplies the "WED" filter to <em>courseList</em>, recalculates the <em>filteredCourseList</em>, then prints the filtered information to the console.
     */
    @FXML
    void checkboxWedChecked() {
    	filter.setFilter(filterType.WED, checkboxWed.isSelected());
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	textAreaConsole.setText("");
    	filterPrintConsole(filteredCourseList);
    }
    
    /*	=== === === === === === === === === === === === === === === === 
     * 		Actions for List Tab
     * === === === === === === === === === === === === === === === === 
     */
    /**
     * Prints enrolled course informations on the console. The enrolled course information includes course code, course title, section code, section-ID, section instructors and slot information. Unlike filtered course information, each Section and each Course are printed in an "one-to-one" format.
     * @param courseList the List of Courses to be printed
     */
    void listPrintConsole(List<Course> courseList) {
    	textAreaConsole.setText(textAreaConsole.getText() + "The following sections are enrolled:\n");
    	if (courseList == null) return;
    	
    	for (Course c : courseList) {
    		if (c.getNumValidSection() > 0) {
	    		String newline = c.getCode() + " - " + c.getTitle() + "\n";
	    		for (int i = 0; i < c.getNumSections(); i++) {
	    			int counter = 1;
	    			Section s = c.getSection(i);
	    			if (s.isValid()) {
	    				newline += "\tSection " + s.getSections() + " (" + s.getID() + ")\t\tInstructor: ";
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
	    			}
	    			for (int j = 0; j < s.getNumSlots(); j++) {
	    				Slot t = s.getSlot(j);
	    				newline += "\t\tSlot " + counter + "\t" + t + "\n";
	    				counter++;
	    			}
	    		} 	
	    		textAreaConsole.setText(textAreaConsole.getText() + "\n" + newline);
    		}
    	}
    }
    
    /**
     *  (To be completed)
     *  Updates timetable in "Time Table" tab whenever a new course section is enrolled or removed
     */
    @FXML
    void tabListSelected() {
    	// Initialization
    	sectionTableData = FXCollections.observableArrayList();
    	filteredCourseList = filter.getFilteredCourseList(courseList);
    	
    	// Set up column factories
    	courseCodeCol.setCellValueFactory(new PropertyValueFactory<ListItem, String>("code"));
    	sectionCol.setCellValueFactory(new PropertyValueFactory<ListItem, String>("sectionName"));
    	courseNameCol.setCellValueFactory(new PropertyValueFactory<ListItem, String>("courseName"));
    	instructorCol.setCellValueFactory(new PropertyValueFactory<ListItem, String>("instructorName"));
    	enrollCol.setCellValueFactory(new PropertyValueFactory<ListItem, String>("isEnrolled"));
    	
    	// Select list to be displayed - scraped list by default
    	List<Course> displayList = null;
    	if (filteredCourseList != null) {
    		displayList = filteredCourseList;
    	} else if (courseList != null) {
    		displayList = courseList;
    	}
    	
    	if (displayList != null) {
	    	for (Course c : displayList) {
	    		for (int i = 0; i < c.getNumSections(); ++i) {
	    			
	    			// Add row
	    			Section s = c.getSection(i);
	    			if (!s.isValid()) {
	    				continue;
	    			}
	    			boolean flag = false;
	    			// Check in enrolledCourseList if Section is enrolled
	    			for (int j = 0; j < enrolledCourseList.size(); ++j) {
	    				Course enrollCourse = enrolledCourseList.get(j);
	    				if (enrollCourse.getSection(0).getID().contentEquals(s.getID())) {
	    					flag = true;
	    				}
	    			}		
	    			ListItem t = new ListItem(c, c.getSection(i), flag);
	    			sectionTableData.add(t);
	    			
	    			// AnchorPane for Timetable update
	    			AnchorPane ap = (AnchorPane) tabTimetable.getContent();
	    			ap.setBlendMode(BlendMode.SRC_ATOP);
	    			
	    			// Checkbox listener for enrollment
	    			t.getIsEnrolled().selectedProperty().addListener(new ChangeListener<Boolean>() {
	    				public void changed(ObservableValue ov, Boolean old_value, Boolean new_value) {
	    					// Enroll course into enrolledCourseList
	    					if (t.getIsEnrolled().isSelected()) {
	    						Course enrollCourse = c.cloneWithoutSections();
	    						enrollCourse.addSection(s);
	    						enrolledCourseList.add(enrollCourse);
	    						// Update timetable (create block)
	    						TimetableBlock block = new TimetableBlock(enrollCourse, s);
	    						for (int k=0; k < block.getNumSlots(); k++) {
	    							ap.getChildren().addAll(block.getBlock(k));
	    						}
	
	    						blocklist.add(block);  
	    						// End of timetable update    					
	    					// Withdraw course from enrolledCourseList
	    					} else {	
	    						for (int k = 0; k < enrolledCourseList.size(); ++k) {
	    							Course withdrawCourse = enrolledCourseList.get(k);
	    							if (withdrawCourse.getSection(0).getID().contentEquals(s.getID())) {
	    								enrolledCourseList.remove(k);
	    								// Update (remove) course from timetable
	    								for (int h=0; h < blocklist.size(); h++) {
	    									if (s.getID().equals(blocklist.get(h).getID())) {
	    										for (int g=0; g < blocklist.get(h).getNumSlots(); g++)
	    											ap.getChildren().remove(blocklist.get(h).getBlock(g));
	    										blocklist.remove(h);
	    									}
	    								}  // End of timetable update
	    								break;
	    							}
	    						}
	    					}
	    					
	    					// Print enrollment statuses
	    					textAreaConsole.setText("");
	    					listPrintConsole(enrolledCourseList);
	    					textAreaConsole.setText(textAreaConsole.getText() + "\n\n\n");
	    					filterPrintConsole(filteredCourseList);
	    				}
	    			});
	    		}
	    	}
    	}
    	sectionTable.setItems(sectionTableData);
    }
}

