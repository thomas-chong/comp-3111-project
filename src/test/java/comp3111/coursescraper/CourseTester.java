package comp3111.coursescraper;

import static org.junit.Assert.*;
import org.junit.Test;

public class CourseTester {
	int[] arr;
	
	/*
	 * 	countAB() Test Cases
	 */
	
	@Test
	public void A0B2_ALowerBoundaryValid() {
		arr = new int [] {0, 2};
		assertArrayEquals(arr, Course.countAB("BB"));
	}
	
	@Test
	public void A1B2_ALowerBoundaryValid() {
		arr = new int [] {1, 2};
		assertArrayEquals(arr, Course.countAB("ABB"));
	}
	
	@Test
	public void A2B0_BLowerBoundaryValid() {
		arr = new int [] {2, 0};
		assertArrayEquals(arr, Course.countAB("AA"));
	}
	
	@Test
	public void A2B1_BLowerBoundaryValid() {
		arr = new int [] {2, 1};
		assertArrayEquals(arr, Course.countAB("BAA"));
	}
	
	@Test
	public void A0B0_ABLowerBoundaryValid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Course.countAB(""));
	}
	
	@Test
	public void A1B1_ABLowerBoundaryValid() {
		arr = new int [] {1, 1};
		assertArrayEquals(arr, Course.countAB("BA"));
	}
	
	@Test
	public void A2B2_ABValid() {
		arr = new int [] {2, 2};
		assertArrayEquals(arr, Course.countAB("BAAB"));
	}
	
	@Test
	public void lowercase_invalid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Course.countAB("baab"));
	}
	
	@Test
	public void nonAB_invalid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Course.countAB("this string is inv4lid"));
	}

}
