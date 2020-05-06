package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task4TimetableTest {
	Course c = new Course();
	Section sec = new Section();
	Slot s1 = new Slot();
	Slot s2 = new Slot();
	Instructor i = new Instructor();
	
	@Before
	public void setUp() throws Exception {
		s1.setDay(1);
		s2.setDay(3);
		s1.setStart("09:00AM");
		s1.setEnd("10:20AM");
		s2.setStart("09:00AM");
		s2.setEnd("10:20AM");
		s1.setVenue("");
		sec.addSlot(s1);
		sec.addSlot(s2);
		sec.setID("L0");
		sec.addInstructor(i);
		c.addSection(sec);
	}
		
	@Test
	public void testgetNumSlots() {
		TimetableBlock block = new TimetableBlock(c, sec);
		assertEquals(2, block.getNumSlots());
	}
	
	@Test
	public void testgetID() {
		TimetableBlock block = new TimetableBlock(c, sec);
		assertEquals("L0", block.getID());
	}

}
