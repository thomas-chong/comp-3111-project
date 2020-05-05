package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class Task3FxTest extends ApplicationTest {

	private Scene s;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Course Scraper");
   		stage.show();
   		s = scene;
	}

	// This test case tests the functionality of the List tab when Filter is empty
	@Test
	public void testEmptyFilter() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabList");
		TableView table = (TableView)s.lookup("#sectionTable");
		assertEquals(table.getItems().size(), 7);
	}
	
	// This test case tests the functionality of the List tab when Filter exists
	@Test
	public void testWithFilter() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabFilter");
		clickOn("#checkboxPM");
		clickOn("#tabList");
		TableView table = (TableView)s.lookup("#sectionTable");
		assertEquals(table.getItems().size(), 6);
		clickOn("#tabFilter");
		clickOn("#buttonSelectAll");
		clickOn("#buttonSelectAll");
	}
	
	// This test case tests the functionality of the enroll checkbox
	@Test
	public void testEnroll() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabList");
		TableView table = (TableView)s.lookup("#sectionTable");
		CheckBox enroll = ((ListItem) table.getItems().get(6)).getIsEnrolled();
		enroll.setSelected(true);
		assertTrue(
				(console.getText().substring(0,300).contains("(1574)"))
				);
		enroll.setSelected(false);
		assertFalse(
				(console.getText().substring(0,300).contains("(1574)"))
				);
	}	
	
	// This test case tests the persistence of enrollment status
	@Test
	public void testPersistance() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabList");
		TableView table = (TableView)s.lookup("#sectionTable");
		CheckBox enroll = ((ListItem) table.getItems().get(6)).getIsEnrolled();
		enroll.setSelected(true);
		clickOn("#tabMain");
		subject.setText("BIBU");
		clickOn("#buttonSearch");
		sleep(5000);
		clickOn("#tabList");
		table = (TableView)s.lookup("#sectionTable");
		enroll = ((ListItem) table.getItems().get(0)).getIsEnrolled();
		enroll.setSelected(true);
		enroll.setSelected(false);
		assertTrue(
				(console.getText().substring(0,300).contains("(1574)"))
				);
		clickOn("#tabMain");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		sleep(5000);
		clickOn("#tabList");
		table = (TableView)s.lookup("#sectionTable");
		enroll = ((ListItem) table.getItems().get(6)).getIsEnrolled();
		enroll.setSelected(false);
	}		
}
