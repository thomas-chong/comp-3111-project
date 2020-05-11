package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Task5FxTest extends ApplicationTest{

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
	// This test is to test the functionality of the search all button when clicking the first time and second time
	public void searchAll() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		clickOn("#tabAllSubject");
		Button b = (Button)s.lookup("#buttonAllSearch");
		clickOn(b);
		while (console.getText().isEmpty()) { }
		sleep(2000);
		assertEquals(console.getText(), "Total Number of Categories/Code Prefix: 75\n" + 
				"\n" + 
				"");
		clickOn(b);
		sleep(2000);
		assertEquals(console.getText(), "Total Number of Categories/Code Prefix: 75\n" + 
				"\n" + 
				"Total Number of Courses fetched:  1163\n" + 
				"\n" + 
				"");
	}

}

