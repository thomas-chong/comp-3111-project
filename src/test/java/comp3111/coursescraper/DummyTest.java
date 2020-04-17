
package comp3111.coursescraper;

import static org.junit.Assert.*;

import org.junit.Test;

public class DummyTest {
	/*
	 * 	This test case tests a method used to count the number of 'A' and 'B' (case-sensitive) in a String.
	 */
	
	int[] arr;

	@Test
	public void A0B2_ALowerBoundaryValid() {
		arr = new int [] {0, 2};
		assertArrayEquals(arr, Dummy.countAB("BB"));
	}
	
	@Test
	public void A1B2_ALowerBoundaryValid() {
		arr = new int [] {1, 2};
		assertArrayEquals(arr, Dummy.countAB("ABB"));
	}
	
	@Test
	public void A2B0_BLowerBoundaryValid() {
		arr = new int [] {2, 0};
		assertArrayEquals(arr, Dummy.countAB("AA"));
	}
	
	@Test
	public void A2B1_BLowerBoundaryValid() {
		arr = new int [] {2, 1};
		assertArrayEquals(arr, Dummy.countAB("BAA"));
	}
	
	@Test
	public void A0B0_ABLowerBoundaryValid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Dummy.countAB(""));
	}
	
	@Test
	public void A1B1_ABLowerBoundaryValid() {
		arr = new int [] {1, 1};
		assertArrayEquals(arr, Dummy.countAB("BA"));
	}
	
	@Test
	public void A2B2_ABValid() {
		arr = new int [] {2, 2};
		assertArrayEquals(arr, Dummy.countAB("BAAB"));
	}
	
	@Test
	public void lowercase_invalid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Dummy.countAB("baab"));
	}
	
	@Test
	public void nonAB_invalid() {
		arr = new int [] {0, 0};
		assertArrayEquals(arr, Dummy.countAB("this string is inv4lid"));
	}

}
