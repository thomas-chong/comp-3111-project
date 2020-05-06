package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task6SFQTest {
	SFQ sfq = new SFQ("COMP 0001", "Professor X", 89.9);
	
	@Test
	public void testTitle() {
		assertEquals("COMP 0001", sfq.getTitle());
	}
	
	@Test
	public void testInstructor() {
		assertEquals("Professor X", sfq.getInstructor());
	}
	
}
