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

public class Task1FxTest extends ApplicationTest{
	
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
	// This test is to test the functionality of the Search button in Main and the console output of the search
	public void search() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		Button b = (Button)s.lookup("#buttonSearch");
		clickOn(b);
		while (console.getText().isEmpty()) { }
		sleep(2000);
		assertEquals(b.getText(), "Search");
		assertEquals(console.getText(), "\n" + 
				"COMP 1001 - Exploring Multimedia and Internet Computing (3 units)\n" + 
				"Slot 0:We15:00-16:50:Rm 5620, Lift 31-32 (70)\n" + 
				"L1 (1782)\n" + 
				"Slot 1:Th16:00-17:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1783)\n" + 
				"\n" + 
				"COMP 1021 - Introduction to Computer Science (3 units)\n" + 
				"Slot 0:Mo12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1784)\n" + 
				"Slot 1:We12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1784)\n" + 
				"Slot 2:We16:30-17:20:Lecture Theater F (134)\n" + 
				"L2 (1786)\n" + 
				"Slot 3:Fr16:30-17:20:Lecture Theater F (134)\n" + 
				"L2 (1786)\n" + 
				"Slot 4:We15:00-15:50:Rm 2306, Lift 17-18 (111)\n" + 
				"L3 (1788)\n" + 
				"Slot 5:Fr15:00-15:50:Rm 2306, Lift 17-18 (111)\n" + 
				"L3 (1788)\n" + 
				"Slot 6:Tu15:00-15:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L4 (1790)\n" + 
				"Slot 7:Th15:00-15:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L4 (1790)\n" + 
				"Slot 8:Tu13:30-14:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L5 (3904)\n" + 
				"Slot 9:Th13:30-14:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L5 (3904)\n" + 
				"Slot 10:Tu16:30-17:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L6 (3905)\n" + 
				"Slot 11:Th16:30-17:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L6 (3905)\n" + 
				"Slot 12:We17:30-19:20:Rm 4213, Lift 19 (67)\n" + 
				"LA01 (1792)\n" + 
				"Slot 13:Tu17:30-19:20:Rm 4213, Lift 19 (67)\n" + 
				"LA02 (1794)\n" + 
				"Slot 14:Th12:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"LA03 (1795)\n" + 
				"Slot 15:Fr18:00-19:50:Rm 4213, Lift 19 (67)\n" + 
				"LA04 (1796)\n" + 
				"Slot 16:Tu11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"LA05 (1797)\n" + 
				"Slot 17:Mo18:00-19:50:Rm 4213, Lift 19 (67)\n" + 
				"LA06 (1798)\n" + 
				"Slot 18:Fr11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"LA07 (3906)\n" + 
				"Slot 19:We10:00-11:50:Rm 4221, Lift 19 (52)\n" + 
				"LA08 (3907)\n" + 
				"Slot 20:We13:00-14:50:Rm 4221, Lift 19 (52)\n" + 
				"LA09 (3908)\n" + 
				"Slot 21:Th10:30-12:20:Rm 4214, Lift 19 (52)\n" + 
				"LA10 (3909)\n" + 
				"\n" + 
				"COMP 1022P - Introduction to Computing with Java (3 units)\n" + 
				"Slot 0:Mo12:00-12:50:Lecture Theater G (135)\n" + 
				"L1 (1800)\n" + 
				"Slot 1:We12:00-12:50:Lecture Theater G (135)\n" + 
				"L1 (1800)\n" + 
				"Slot 2:Mo09:30-10:20:Lecture Theater F (134)\n" + 
				"L2 (1802)\n" + 
				"Slot 3:We09:30-10:20:Lecture Theater F (134)\n" + 
				"L2 (1802)\n" + 
				"Slot 4:Mo10:30-11:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L3 (1803)\n" + 
				"Slot 5:We10:30-11:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L3 (1803)\n" + 
				"Slot 6:We18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1804)\n" + 
				"Slot 7:Tu17:00-18:50:Rm 4210, Lift 19 (67)\n" + 
				"LA2 (1806)\n" + 
				"Slot 8:Fr14:30-16:20:Rm 4213, Lift 19 (67)\n" + 
				"LA3 (1807)\n" + 
				"Slot 9:Th12:30-14:20:Rm 4210, Lift 19 (67)\n" + 
				"LA4 (1808)\n" + 
				"Slot 10:We15:30-17:20:Rm 4213, Lift 19 (67)\n" + 
				"LA5 (1809)\n" + 
				"\n" + 
				"COMP 1022Q - Introduction to Computing with Excel VBA (3 units)\n" + 
				"Slot 0:We14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L1 (1811)\n" + 
				"Slot 1:Fr14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L1 (1811)\n" + 
				"Slot 2:We15:30-16:20:Rm 2465, Lift 25-26 (122)\n" + 
				"L2 (1813)\n" + 
				"Slot 3:Fr15:30-16:20:Rm 2465, Lift 25-26 (122)\n" + 
				"L2 (1813)\n" + 
				"Slot 4:We16:30-17:20:Rm 2465, Lift 25-26 (122)\n" + 
				"L3 (1815)\n" + 
				"Slot 5:Fr16:30-17:20:Rm 2465, Lift 25-26 (122)\n" + 
				"L3 (1815)\n" + 
				"Slot 6:Tu12:00-12:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L4 (1817)\n" + 
				"Slot 7:Th12:00-12:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L4 (1817)\n" + 
				"Slot 8:We11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"LA1 (1819)\n" + 
				"Slot 9:Mo12:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"LA2 (1821)\n" + 
				"Slot 10:Mo10:30-12:20:Rm 4213, Lift 19 (67)\n" + 
				"LA3 (1822)\n" + 
				"Slot 11:Th14:30-16:20:Rm 4213, Lift 19 (67)\n" + 
				"LA4 (1823)\n" + 
				"Slot 12:Th10:30-12:20:Rm 4213, Lift 19 (67)\n" + 
				"LA5 (1824)\n" + 
				"Slot 13:Tu15:00-16:50:Rm 4213, Lift 19 (67)\n" + 
				"LA6 (1825)\n" + 
				"\n" + 
				"COMP 1029C - C Programming Bridging Course (1 unit)\n" + 
				"\n" + 
				"COMP 1029J - Java Programming Bridging Course (1 unit)\n" + 
				"\n" + 
				"COMP 1029P - Python Programming Bridging Course (1 unit)\n" + 
				"\n" + 
				"COMP 1029V - Excel VBA Programming Bridging Course (1 unit)\n" + 
				"\n" + 
				"COMP 1943 - Creative Sound Design (3 units)\n" + 
				"Slot 0:Mo12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1835)\n" + 
				"Slot 1:We12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1835)\n" + 
				"\n" + 
				"COMP 1991 - Industrial Experience (0 units)\n" + 
				"\n" + 
				"COMP 2011 - Programming with C++ (4 units)\n" + 
				"Slot 0:Tu12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1840)\n" + 
				"Slot 1:Th12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1840)\n" + 
				"Slot 2:We15:00-16:20:Rm 4619, Lift 31-32 (126)\n" + 
				"L2 (1842)\n" + 
				"Slot 3:Fr15:00-16:20:Rm 4619, Lift 31-32 (126)\n" + 
				"L2 (1842)\n" + 
				"Slot 4:Tu13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"L3 (1844)\n" + 
				"Slot 5:Th13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"L3 (1844)\n" + 
				"Slot 6:Tu15:00-16:20:Rm 2464, Lift 25-26 (122)\n" + 
				"L4 (1846)\n" + 
				"Slot 7:Th15:00-16:20:Rm 2464, Lift 25-26 (122)\n" + 
				"L4 (1846)\n" + 
				"Slot 8:Mo15:00-16:50:Rm 4213, Lift 19 (67)\n" + 
				"LA1 (1848)\n" + 
				"Slot 9:Tu15:00-16:50:Rm 4210, Lift 19 (67)\n" + 
				"LA2 (1850)\n" + 
				"Slot 10:Fr18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"LA3 (1851)\n" + 
				"Slot 11:Fr09:00-10:50:Rm 4213, Lift 19 (67)\n" + 
				"LA4 (1852)\n" + 
				"Slot 12:Fr14:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"LA5 (1853)\n" + 
				"Slot 13:Mo18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"LA6 (1854)\n" + 
				"\n" + 
				"COMP 2012 - Object-Oriented Programming and Data Structures (4 units)\n" + 
				"Slot 0:Mo13:30-14:50:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1856)\n" + 
				"Slot 1:Fr09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L1 (1856)\n" + 
				"Slot 2:We15:00-16:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L2 (1858)\n" + 
				"Slot 3:Fr15:00-16:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L2 (1858)\n" + 
				"Slot 4:Th10:30-12:20:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1860)\n" + 
				"Slot 5:Th18:00-19:50:Rm 4221, Lift 19 (52)\n" + 
				"LA2 (1862)\n" + 
				"Slot 6:Tu13:00-14:50:Rm 4210, Lift 19 (67)\n" + 
				"LA3 (3956)\n" + 
				"\n" + 
				"COMP 2012H - Honors Object-Oriented Programming and Data Structures (5 units)\n" + 
				"Slot 0:Tu13:30-15:20:Rm 2302, Lift 17-18 (74)\n" + 
				"L1 (1864)\n" + 
				"Slot 1:Th13:30-15:20:Rm 2302, Lift 17-18 (74)\n" + 
				"L1 (1864)\n" + 
				"Slot 2:Fr11:30-13:20:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1865)\n" + 
				"\n" + 
				"COMP 2611 - Computer Organization (4 units)\n" + 
				"Slot 0:Mo13:30-14:50:Rm 2302, Lift 17-18 (74)\n" + 
				"L1 (1866)\n" + 
				"Slot 1:Fr09:00-10:20:Rm 2302, Lift 17-18 (74)\n" + 
				"L1 (1866)\n" + 
				"Slot 2:We16:30-17:50:Rm 6573, Lift 29-30 (88)\n" + 
				"L2 (1868)\n" + 
				"Slot 3:Fr16:30-17:50:Rm 6573, Lift 29-30 (88)\n" + 
				"L2 (1868)\n" + 
				"Slot 4:Mo09:30-10:20:Rm 5583, Lift 29-30 (80)\n" + 
				"T1 (1873)\n" + 
				"Slot 5:Tu15:00-15:50:Rm 5583, Lift 29-30 (80)\n" + 
				"T2 (1875)\n" + 
				"Slot 6:We09:00-09:50:Rm 4213, Lift 19 (67)\n" + 
				"LA1 (1870)\n" + 
				"Slot 7:Fr13:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"LA2 (1872)\n" + 
				"\n" + 
				"COMP 2711 - Discrete Mathematical Tools for Computer Science (4 units)\n" + 
				"Slot 0:Mo12:00-13:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L1 (1876)\n" + 
				"Slot 1:We12:00-13:20:Rm 4620, Lift 31-32 (126)\n" + 
				"L1 (1876)\n" + 
				"Slot 2:Tu16:30-17:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L2 (1878)\n" + 
				"Slot 3:Th16:30-17:50:Rm 2465, Lift 25-26 (122)\n" + 
				"L2 (1878)\n" + 
				"Slot 4:Mo13:30-14:50:Rm 4619, Lift 31-32 (126)\n" + 
				"L3 (1880)\n" + 
				"Slot 5:Fr09:00-10:20:Rm 4619, Lift 31-32 (126)\n" + 
				"L3 (1880)\n" + 
				"Slot 6:Mo17:00-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"T1A (1882)\n" + 
				"Slot 7:Th09:30-10:20:Rm 1410, Lift 25-26 (60)\n" + 
				"T1B (1884)\n" + 
				"Slot 8:We09:30-10:20:Rm 2304, Lift 17-18 (76)\n" + 
				"T2A (1885)\n" + 
				"Slot 9:Mo12:00-12:50:Rm 2304, Lift 17-18 (76)\n" + 
				"T2B (1886)\n" + 
				"Slot 10:Th18:00-18:50:Rm 1409, Lift 25-26 (60)\n" + 
				"T3A (1887)\n" + 
				"Slot 11:Fr12:00-12:50:Rm 1410, Lift 25-26 (60)\n" + 
				"T3B (1888)\n" + 
				"\n" + 
				"COMP 2711H - Honors Discrete Mathematical Tools for Computer Science (4 units)\n" + 
				"Slot 0:Mo12:00-13:20:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1889)\n" + 
				"Slot 1:We12:00-13:20:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1889)\n" + 
				"Slot 2:Mo17:00-17:50:Rm 2306, Lift 17-18 (111)\n" + 
				"T1 (1890)\n" + 
				"\n" + 
				"COMP 3021 - Java Programming (3 units)\n" + 
				"Slot 0:Tu15:00-16:20:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1891)\n" + 
				"Slot 1:Th15:00-16:20:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1891)\n" + 
				"Slot 2:Th09:00-09:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1892)\n" + 
				"\n" + 
				"COMP 3031 - Principles of Programming Languages (3 units)\n" + 
				"Slot 0:Mo10:30-11:50:Rm 2304, Lift 17-18 (76)\n" + 
				"L1 (1893)\n" + 
				"Slot 1:We10:30-11:50:Rm 2304, Lift 17-18 (76)\n" + 
				"L1 (1893)\n" + 
				"Slot 2:We15:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1894)\n" + 
				"\n" + 
				"COMP 3111 - Software Engineering (4 units)\n" + 
				"Slot 0:Mo09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1895)\n" + 
				"Slot 1:We09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1895)\n" + 
				"Slot 2:Tu12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1897)\n" + 
				"Slot 3:Th12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1897)\n" + 
				"Slot 4:Fr09:30-11:20:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1899)\n" + 
				"Slot 5:Th18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"LA2 (1901)\n" + 
				"Slot 6:We10:30-12:20:Rm 4210, Lift 19 (67)\n" + 
				"LA3 (1902)\n" + 
				"\n" + 
				"COMP 3111H - Honors Software Engineering (4 units)\n" + 
				"Slot 0:Mo09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1903)\n" + 
				"Slot 1:We09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"L1 (1903)\n" + 
				"Slot 2:Tu12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1905)\n" + 
				"Slot 3:Th12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1905)\n" + 
				"Slot 4:Mo16:00-17:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1907)\n" + 
				"\n" + 
				"COMP 3211 - Fundamentals of Artificial Intelligence (3 units)\n" + 
				"Slot 0:Tu13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L1 (1910)\n" + 
				"Slot 1:Th13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L1 (1910)\n" + 
				"Slot 2:Tu18:00-18:50:Rm 1104, Acad Concourse (120)\n" + 
				"T1 (1911)\n" + 
				"\n" + 
				"COMP 3311 - Database Management Systems (3 units)\n" + 
				"Slot 0:Tu12:00-13:20:Lecture Theater K (106)\n" + 
				"L1 (1912)\n" + 
				"Slot 1:Th12:00-13:20:Lecture Theater K (106)\n" + 
				"L1 (1912)\n" + 
				"Slot 2:Tu18:00-18:50:Rm 4502, Lift 25-26 (60)\n" + 
				"T1 (1917)\n" + 
				"Slot 3:Th18:00-18:50:Rm 6591, Lift 31-32 (88)\n" + 
				"T2 (1919)\n" + 
				"Slot 4:Tu09:00-09:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1914)\n" + 
				"Slot 5:Mo09:30-10:20:Rm 4210, Lift 19 (67)\n" + 
				"LA2 (1916)\n" + 
				"\n" + 
				"COMP 3511 - Operating Systems (3 units)\n" + 
				"Slot 0:We16:30-17:50:Rm 4620, Lift 31-32 (126)\n" + 
				"L1 (1920)\n" + 
				"Slot 1:Fr16:30-17:50:Rm 4620, Lift 31-32 (126)\n" + 
				"L1 (1920)\n" + 
				"Slot 2:Tu09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L2 (1922)\n" + 
				"Slot 3:Th09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"L2 (1922)\n" + 
				"Slot 4:Mo12:00-13:50:Rm 4214, Lift 19 (52)\n" + 
				"LA1 (1924)\n" + 
				"Slot 5:Mo14:00-15:50:Rm 4214, Lift 19 (52)\n" + 
				"LA2 (1926)\n" + 
				"Slot 6:Mo18:00-19:50:Rm 4214, Lift 19 (52)\n" + 
				"LA3 (1927)\n" + 
				"Slot 7:Tu18:00-19:50:Rm 4214, Lift 19 (52)\n" + 
				"LA4 (1928)\n" + 
				"Slot 8:Sa11:00-12:50:Rm 4214, Lift 19 (52)\n" + 
				"LA5 (3954)\n" + 
				"\n" + 
				"COMP 3632 - Principles of Cybersecurity (3 units)\n" + 
				"Slot 0:Tu12:00-13:20:Rm 2504, Lift 25-26 (84)\n" + 
				"L1 (1929)\n" + 
				"Slot 1:Th12:00-13:20:Rm 2504, Lift 25-26 (84)\n" + 
				"L1 (1929)\n" + 
				"\n" + 
				"COMP 3711 - Design and Analysis of Algorithms (3 units)\n" + 
				"Slot 0:Tu10:30-11:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L1 (1930)\n" + 
				"Slot 1:Th10:30-11:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L1 (1930)\n" + 
				"Slot 2:We13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1932)\n" + 
				"Slot 3:Fr13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"L2 (1932)\n" + 
				"Slot 4:Fr12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"T1 (1934)\n" + 
				"Slot 5:Th14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"T2 (1936)\n" + 
				"Slot 6:We16:30-17:20:G010, CYT Bldg (140)\n" + 
				"T3 (1937)\n" + 
				"\n" + 
				"COMP 3711H - Honors Design and Analysis of Algorithms (4 units)\n" + 
				"Slot 0:Tu10:30-11:50:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1938)\n" + 
				"Slot 1:Th10:30-11:50:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1938)\n" + 
				"Slot 2:Fr12:00-12:50:Lecture Theater K (106)\n" + 
				"T1 (1939)\n" + 
				"\n" + 
				"COMP 3721 - Theory of Computation (3 units)\n" + 
				"Slot 0:Tu09:00-10:20:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1940)\n" + 
				"Slot 1:Th09:00-10:20:Rm 6591, Lift 31-32 (88)\n" + 
				"L1 (1940)\n" + 
				"Slot 2:Tu12:30-13:20:G009A, CYT Bldg (80)\n" + 
				"T1 (1941)\n" + 
				"\n" + 
				"COMP 4021 - Internet Computing (3 units)\n" + 
				"Slot 0:Tu13:30-14:20:Rm 2404, Lift 17-18 (81)\n" + 
				"L1 (1942)\n" + 
				"Slot 1:Th13:30-14:20:Rm 2404, Lift 17-18 (81)\n" + 
				"L1 (1942)\n" + 
				"Slot 2:Mo14:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (1943)\n" + 
				"\n" + 
				"COMP 4211 - Machine Learning (3 units)\n" + 
				"Slot 0:Mo10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1944)\n" + 
				"Slot 1:We10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1944)\n" + 
				"Slot 2:Mo15:00-15:50:Rm 2464, Lift 25-26 (122)\n" + 
				"T1 (1945)\n" + 
				"\n" + 
				"COMP 4331 - Data Mining (3 units)\n" + 
				"Slot 0:Mo12:00-13:20:Lecture Theater E (143)\n" + 
				"L1 (3878)\n" + 
				"Slot 1:We12:00-13:20:Lecture Theater E (143)\n" + 
				"L1 (3878)\n" + 
				"Slot 2:Tu15:00-15:50:Rm 4221, Lift 19 (52)\n" + 
				"T1 (3879)\n" + 
				"Slot 3:Th12:00-12:50:Rm 4221, Lift 19 (52)\n" + 
				"T2 (3880)\n" + 
				"\n" + 
				"COMP 4421 - Image Processing (3 units)\n" + 
				"Slot 0:We13:30-14:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1946)\n" + 
				"Slot 1:Fr13:30-14:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1946)\n" + 
				"Slot 2:Mo14:00-14:50:Rm 2463, Lift 25-26 (42)\n" + 
				"T1 (1948)\n" + 
				"Slot 3:Th17:00-17:50:Rm 6591, Lift 31-32 (88)\n" + 
				"T2 (1950)\n" + 
				"\n" + 
				"COMP 4461 - Human-Computer Interaction (3 units)\n" + 
				"Slot 0:Tu12:00-13:20:Rm 1410, Lift 25-26 (60)\n" + 
				"L1 (1951)\n" + 
				"Slot 1:Th12:00-13:20:Rm 1410, Lift 25-26 (60)\n" + 
				"L1 (1951)\n" + 
				"Slot 2:Tu09:00-09:50:Rm 4213, Lift 19 (67)\n" + 
				"LA1 (1952)\n" + 
				"\n" + 
				"COMP 4621 - Computer Communication Networks I (3 units)\n" + 
				"Slot 0:Mo10:30-11:50:Rm 2404, Lift 17-18 (81)\n" + 
				"L1 (1953)\n" + 
				"Slot 1:We10:30-11:50:Rm 2404, Lift 17-18 (81)\n" + 
				"L1 (1953)\n" + 
				"Slot 2:Tu09:30-10:20:Rm 4214, Lift 19 (52)\n" + 
				"LA1 (1955)\n" + 
				"Slot 3:Tu11:00-11:50:Rm 4214, Lift 19 (52)\n" + 
				"LA2 (1957)\n" + 
				"\n" + 
				"COMP 4651 - Cloud Computing and Big Data Systems (3 units)\n" + 
				"Slot 0:We13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"L1 (1958)\n" + 
				"Slot 1:Fr13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"L1 (1958)\n" + 
				"Slot 2:Fr15:00-15:50:Rm 4214, Lift 19 (52)\n" + 
				"LA1 (1960)\n" + 
				"Slot 3:Mo09:30-10:20:Rm 4214, Lift 19 (52)\n" + 
				"LA2 (1962)\n" + 
				"\n" + 
				"COMP 4900 - Academic and Professional Development (0 units)\n" + 
				"Slot 0:We18:00-18:50:Lecture Theater C (213)\n" + 
				"T02 (1964)\n" + 
				"Slot 1:We18:00-18:50:TBA\n" + 
				"T03 (1965)\n" + 
				"Slot 2:We18:00-18:50:TBA\n" + 
				"T04 (1966)\n" + 
				"Slot 3:We18:00-18:50:TBA\n" + 
				"T06 (1968)\n" + 
				"Slot 4:We18:00-18:50:TBA\n" + 
				"T08 (1970)\n" + 
				"Slot 5:We18:00-18:50:TBA\n" + 
				"T09 (1971)\n" + 
				"Slot 6:We18:00-18:50:TBA\n" + 
				"T11 (1973)\n" + 
				"Slot 7:We18:00-18:50:TBA\n" + 
				"T13 (1975)\n" + 
				"Slot 8:We18:00-18:50:TBA\n" + 
				"T14 (1976)\n" + 
				"Slot 9:We18:00-18:50:TBA\n" + 
				"T15 (1977)\n" + 
				"Slot 10:We18:00-18:50:TBA\n" + 
				"T16 (1978)\n" + 
				"Slot 11:We18:00-18:50:TBA\n" + 
				"T19 (1981)\n" + 
				"Slot 12:We18:00-18:50:TBA\n" + 
				"T23 (1985)\n" + 
				"Slot 13:We18:00-18:50:TBA\n" + 
				"T24 (1986)\n" + 
				"Slot 14:We18:00-18:50:TBA\n" + 
				"T25 (1987)\n" + 
				"Slot 15:We18:00-18:50:TBA\n" + 
				"T26 (1988)\n" + 
				"Slot 16:We18:00-18:50:TBA\n" + 
				"T27 (1989)\n" + 
				"Slot 17:We18:00-18:50:TBA\n" + 
				"T30 (1992)\n" + 
				"Slot 18:We18:00-18:50:TBA\n" + 
				"T31 (1993)\n" + 
				"Slot 19:We18:00-18:50:TBA\n" + 
				"T33 (1995)\n" + 
				"Slot 20:We18:00-18:50:TBA\n" + 
				"T34 (1996)\n" + 
				"Slot 21:We18:00-18:50:TBA\n" + 
				"T35 (1997)\n" + 
				"Slot 22:We18:00-18:50:TBA\n" + 
				"T37 (1999)\n" + 
				"Slot 23:We18:00-18:50:TBA\n" + 
				"T38 (2000)\n" + 
				"Slot 24:We18:00-18:50:TBA\n" + 
				"T40 (2002)\n" + 
				"Slot 25:We18:00-18:50:TBA\n" + 
				"T41 (2003)\n" + 
				"Slot 26:We18:00-18:50:TBA\n" + 
				"T42 (2004)\n" + 
				"Slot 27:We18:00-18:50:TBA\n" + 
				"T43 (3917)\n" + 
				"\n" + 
				"COMP 4901L - Foundations of Computer Vision (3 units)\n" + 
				"Slot 0:Tu16:30-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"L1 (2005)\n" + 
				"Slot 1:Th16:30-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"L1 (2005)\n" + 
				"Slot 2:We12:30-13:20:Rm 4210, Lift 19 (67)\n" + 
				"LA1 (2006)\n" + 
				"\n" + 
				"COMP 4910 - Co-op Program (6 units)\n" + 
				"\n" + 
				"COMP 4971A - Independent Work (1 unit)\n" + 
				"\n" + 
				"COMP 4971B - Independent Work (2 units)\n" + 
				"\n" + 
				"COMP 4971C - Independent Work (3 units)\n" + 
				"\n" + 
				"COMP 4971D - Independent Work (4 units)\n" + 
				"\n" + 
				"COMP 4971H - Independent Work (4 units)\n" + 
				"\n" + 
				"COMP 4981 - Final Year Project (6 units)\n" + 
				"\n" + 
				"COMP 4981H - Final Year Thesis (6 units)\n" + 
				"\n" + 
				"COMP 5211 - Advanced Artificial Intelligence (3 units)\n" + 
				"Slot 0:Tu09:00-10:20:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1105)\n" + 
				"Slot 1:Th09:00-10:20:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1105)\n" + 
				"\n" + 
				"COMP 5222 - Statistical Learning Models for Text and Graph Data (3 units)\n" + 
				"Slot 0:We13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1107)\n" + 
				"Slot 1:Fr13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1107)\n" + 
				"\n" + 
				"COMP 5331 - Knowledge Discovery in Databases (3 units)\n" + 
				"Slot 0:Mo10:30-11:50:Rm 2504, Lift 25-26 (84)\n" + 
				"L1 (1108)\n" + 
				"Slot 1:We10:30-11:50:Rm 2504, Lift 25-26 (84)\n" + 
				"L1 (1108)\n" + 
				"\n" + 
				"COMP 5411 - Advanced Computer Graphics (3 units)\n" + 
				"Slot 0:We15:00-16:20:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1109)\n" + 
				"Slot 1:Fr15:00-16:20:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1109)\n" + 
				"\n" + 
				"COMP 5621 - Computer Networks (3 units)\n" + 
				"Slot 0:Mo12:00-13:20:Rm 5583, Lift 29-30 (80)\n" + 
				"L1 (1110)\n" + 
				"Slot 1:We12:00-13:20:Rm 5583, Lift 29-30 (80)\n" + 
				"L1 (1110)\n" + 
				"\n" + 
				"COMP 5631 - Cryptography and Security (3 units)\n" + 
				"Slot 0:Tu13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1111)\n" + 
				"Slot 1:Th13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1111)\n" + 
				"\n" + 
				"COMP 5711 - Introduction to Advanced Algorithmic Techniques (3 units)\n" + 
				"Slot 0:Tu10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1112)\n" + 
				"Slot 1:Th10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"L1 (1112)\n" + 
				"\n" + 
				"COMP 6211D - Deep Learning (3 units)\n" + 
				"Slot 0:Tu12:00-13:20:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1113)\n" + 
				"Slot 1:Th12:00-13:20:Rm 2503, Lift 25-26 (87)\n" + 
				"L1 (1113)\n" + 
				"\n" + 
				"COMP 6911 - Computer Science and Engineering Seminar I (0 units)\n" + 
				"Slot 0:Mo16:00-16:50:Lecture Theater F (134)\n" + 
				"T1 (1114)\n" + 
				"\n" + 
				"COMP 6912 - Computer Science and Engineering Seminar II (1 unit)\n" + 
				"Slot 0:Mo16:00-16:50:Lecture Theater F (134)\n" + 
				"T1 (1115)\n" + 
				"\n" + 
				"COMP 6921B - Research Project: Software Fault Analysis (1 unit)\n" + 
				"\n" + 
				"COMP 6921E - Research Project (1 unit)\n" + 
				"\n" + 
				"COMP 6921M - Research Project (1 unit)\n" + 
				"\n" + 
				"COMP 6921R - Research Project (1 unit)\n" + 
				"\n" + 
				"COMP 6921V - Research Project (1 unit)\n" + 
				"\n" + 
				"COMP 6931A - Independent Studies (3 units)\n" + 
				"\n" + 
				"COMP 6990 - MPhil Thesis Research (0 units)\n" + 
				"\n" + 
				"COMP 7990 - Doctoral Thesis Research (0 units)\n" + 
				"\n" + 
				"Total Number of difference sections in this search: 195\n" + 
				"Total Number of Course in this search: 45\n" + 
				"Display Instructors who has teaching assignment this term but does not need to teach at Tu 3:10pm: \n" + 
				"ARYA, Sunil, \n" + 
				"BENSAOU, Brahim, \n" + 
				"CHAN, Gary Shueng Han, \n" + 
				"CHEN, Kai, \n" + 
				"CHEN, Qifeng, \n" + 
				"CHUNG, Albert Chi Shing, \n" + 
				"DING, Cunsheng, \n" + 
				"GOLIN, Mordecai Jay, \n" + 
				"HORNER, Andrew Brian, \n" + 
				"LAM, Gibson, \n" + 
				"LEE, Dik Lun, \n" + 
				"LEUNG, Wai Ting, \n" + 
				"LI, Bo, \n" + 
				"LIN, Fangzhen, \n" + 
				"LOCHOVSKY, Frederick Horst, \n" + 
				"LUO, Qiong, \n" + 
				"MA, Xiaojuan, \n" + 
				"MUPPALA, Kumaraswamy R Jogesh, \n" + 
				"NG, Wilfred Siu Hung, \n" + 
				"PAPADOPOULOS, Dimitris, \n" + 
				"QU, Huamin, \n" + 
				"QUAN, Long, \n" + 
				"SANDER, Pedro, \n" + 
				"SONG, Yangqiu, \n" + 
				"TAI, Chiew Lan, \n" + 
				"TANG, Chi Keung, \n" + 
				"WANG, Shuai, \n" + 
				"WANG, Tao, \n" + 
				"WANG, Wei, \n" + 
				"WONG, Raymond Chi Wing, \n" + 
				"YI, Ke, \n" + 
				"ZHANG, Charles Chuan, \n" + 
				"ZHANG, Nevin Lianwen, \n" + 
				"ZHANG, Qian, \n" + 
				"");
	}
	
	@Test
	// This test is to test the functionality of dealing with Error 404 when the input in Main Tab is invalid
	public void error404() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("COM");
		assertEquals(subject.getText(), "COM");
		Button b = (Button)s.lookup("#buttonSearch");
		clickOn(b);
		sleep(3000);
		assertEquals(console.getText(), "\n" + 
				"Error 404. Please check your input again.");
	}
	

}
