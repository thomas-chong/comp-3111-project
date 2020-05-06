package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Task6TestFX extends ApplicationTest {
	
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

	@Test
	// Tests the enabling of button "Find SFQ with enrolled courses"
	public void testButton() {
		clickOn("#tabSfq");
		clickOn("#buttonInstructorSfq");
		Button b = (Button)s.lookup("#buttonInstructorSfq");
		sleep(1000);
		assertFalse(b.isDisabled());
		clickOn("#buttonSfqEnrollCourse");
		Button b2 = (Button)s.lookup("#buttonSfqEnrollCourse");
		sleep(1000);
		assertTrue(b2.isDisabled());
		clickOn("#tabMain");
		clickOn("#buttonSearch");
		sleep(1000);
		clickOn("#tabSfq");
		clickOn("#buttonSfqEnrollCourse");
		assertFalse(b2.isDisabled());	
	}
}
