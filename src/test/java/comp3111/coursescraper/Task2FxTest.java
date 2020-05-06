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


public class Task2FxTest extends ApplicationTest {

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
	// This test case tests the functionality of "Select All" and "De-select All" buttons
	public void testSelectAll() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabFilter");
		Button b = (Button)s.lookup("#buttonSelectAll");
		clickOn(b);
		sleep(500);
		assertEquals(b.getText(), "De-select All");
		assertEquals(console.getText(), "Displaying filtered courses:\n");
		clickOn(b);
		sleep(500);
		assertEquals(b.getText(), "Select All");
		assertEquals(console.getText(), "Displaying filtered courses:\n" + 
				"\n" + 
				"COMP 1001 - Exploring Multimedia and Internet Computing (3 units)\n" + 
				"	Section L1 (1782)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	We15:00-16:50:Rm 5620, Lift 31-32 (70)\n" + 
				"	Section LA1 (1783)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	Th16:00-17:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 1021 - Introduction to Computer Science (3 units)\n" + 
				"	Section L1 (1784)		Instructor: LAM, Gibson\n" + 
				"		Slot 1	Mo12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"		Slot 2	We12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"	Section L2 (1786)		Instructor: LAM, Ngok\n" + 
				"		Slot 1	We16:30-17:20:Lecture Theater F (134)\n" + 
				"		Slot 2	Fr16:30-17:20:Lecture Theater F (134)\n" + 
				"	Section L3 (1788)		Instructor: LAM, Gibson\n" + 
				"		Slot 1	We15:00-15:50:Rm 2306, Lift 17-18 (111)\n" + 
				"		Slot 2	Fr15:00-15:50:Rm 2306, Lift 17-18 (111)\n" + 
				"	Section L4 (1790)		Instructor: KIM, Sung Hun\n" + 
				"		Slot 1	Tu15:00-15:50:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Th15:00-15:50:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section L5 (3904)		Instructor: KIM, Sung Hun\n" + 
				"		Slot 1	Tu13:30-14:20:Rm 4620, Lift 31-32 (126)\n" + 
				"		Slot 2	Th13:30-14:20:Rm 4620, Lift 31-32 (126)\n" + 
				"	Section L6 (3905)		Instructor: LAM, Ngok\n" + 
				"		Slot 1	Tu16:30-17:20:Rm 4620, Lift 31-32 (126)\n" + 
				"		Slot 2	Th16:30-17:20:Rm 4620, Lift 31-32 (126)\n" + 
				"	Section LA01 (1792)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	We17:30-19:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA02 (1794)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Tu17:30-19:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA03 (1795)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Th12:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA04 (1796)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Fr18:00-19:50:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA05 (1797)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Tu11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA06 (1798)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Mo18:00-19:50:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA07 (3906)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Fr11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA08 (3907)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	We10:00-11:50:Rm 4221, Lift 19 (52)\n" + 
				"	Section LA09 (3908)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	We13:00-14:50:Rm 4221, Lift 19 (52)\n" + 
				"	Section LA10 (3909)		Instructor: KIM, Sung Hun, LAM, Gibson, LAM, Ngok\n" + 
				"		Slot 1	Th10:30-12:20:Rm 4214, Lift 19 (52)\n" + 
				"\n" + 
				"COMP 1022P - Introduction to Computing with Java (3 units)\n" + 
				"	Section L1 (1800)		Instructor: NG, Wilfred Siu Hung\n" + 
				"		Slot 1	Mo12:00-12:50:Lecture Theater G (135)\n" + 
				"		Slot 2	We12:00-12:50:Lecture Theater G (135)\n" + 
				"	Section L2 (1802)		Instructor: NG, Wilfred Siu Hung\n" + 
				"		Slot 1	Mo09:30-10:20:Lecture Theater F (134)\n" + 
				"		Slot 2	We09:30-10:20:Lecture Theater F (134)\n" + 
				"	Section L3 (1803)		Instructor: MUPPALA, Kumaraswamy R Jogesh\n" + 
				"		Slot 1	Mo10:30-11:20:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	We10:30-11:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section LA1 (1804)		Instructor: MUPPALA, Kumaraswamy R Jogesh, NG, Wilfred Siu Hung\n" + 
				"		Slot 1	We18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA2 (1806)		Instructor: MUPPALA, Kumaraswamy R Jogesh, NG, Wilfred Siu Hung\n" + 
				"		Slot 1	Tu17:00-18:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA3 (1807)		Instructor: MUPPALA, Kumaraswamy R Jogesh, NG, Wilfred Siu Hung\n" + 
				"		Slot 1	Fr14:30-16:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA4 (1808)		Instructor: MUPPALA, Kumaraswamy R Jogesh, NG, Wilfred Siu Hung\n" + 
				"		Slot 1	Th12:30-14:20:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA5 (1809)		Instructor: MUPPALA, Kumaraswamy R Jogesh, NG, Wilfred Siu Hung\n" + 
				"		Slot 1	We15:30-17:20:Rm 4213, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 1022Q - Introduction to Computing with Excel VBA (3 units)\n" + 
				"	Section L1 (1811)		Instructor: ROSSITER, David\n" + 
				"		Slot 1	We14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Fr14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section L2 (1813)		Instructor: ROSSITER, David\n" + 
				"		Slot 1	We15:30-16:20:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Fr15:30-16:20:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section L3 (1815)		Instructor: CHAN, Ki Cecia\n" + 
				"		Slot 1	We16:30-17:20:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Fr16:30-17:20:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section L4 (1817)		Instructor: ROSSITER, David\n" + 
				"		Slot 1	Tu12:00-12:50:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Th12:00-12:50:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section LA1 (1819)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	We11:30-13:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA2 (1821)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	Mo12:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA3 (1822)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	Mo10:30-12:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA4 (1823)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	Th14:30-16:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA5 (1824)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	Th10:30-12:20:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA6 (1825)		Instructor: CHAN, Ki Cecia, ROSSITER, David\n" + 
				"		Slot 1	Tu15:00-16:50:Rm 4213, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 1029C - C Programming Bridging Course (1 unit)\n" + 
				"	Section L1 (1827)		Instructor: LAM, Gibson\n" + 
				"	Section LA1 (1828)		Instructor: LAM, Gibson\n" + 
				"\n" + 
				"COMP 1029J - Java Programming Bridging Course (1 unit)\n" + 
				"	Section L1 (1829)		Instructor: LAM, Gibson\n" + 
				"	Section LA1 (1830)		Instructor: LAM, Gibson\n" + 
				"\n" + 
				"COMP 1029P - Python Programming Bridging Course (1 unit)\n" + 
				"	Section L1 (1831)		Instructor: LAM, Gibson\n" + 
				"	Section LA1 (1832)		Instructor: LAM, Gibson\n" + 
				"\n" + 
				"COMP 1029V - Excel VBA Programming Bridging Course (1 unit)\n" + 
				"	Section L1 (1833)		Instructor: LAM, Gibson\n" + 
				"	Section LA1 (1834)		Instructor: LAM, Gibson\n" + 
				"\n" + 
				"COMP 1943 - Creative Sound Design (3 units)\n" + 
				"	Section L1 (1835)		Instructor: HORNER, Andrew Brian\n" + 
				"		Slot 1	Mo12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	We12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section LA1 (1836)		Instructor: HORNER, Andrew Brian\n" + 
				"\n" + 
				"COMP 2011 - Programming with C++ (4 units)\n" + 
				"	Section L1 (1840)		Instructor: MAK, Brian Kan Wing\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section L2 (1842)		Instructor: LI, Xin\n" + 
				"		Slot 1	We15:00-16:20:Rm 4619, Lift 31-32 (126)\n" + 
				"		Slot 2	Fr15:00-16:20:Rm 4619, Lift 31-32 (126)\n" + 
				"	Section L3 (1844)		Instructor: CHAN, Ki Cecia\n" + 
				"		Slot 1	Tu13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"		Slot 2	Th13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"	Section L4 (1846)		Instructor: CHAN, Ki Cecia\n" + 
				"		Slot 1	Tu15:00-16:20:Rm 2464, Lift 25-26 (122)\n" + 
				"		Slot 2	Th15:00-16:20:Rm 2464, Lift 25-26 (122)\n" + 
				"	Section LA1 (1848)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Mo15:00-16:50:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA2 (1850)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Tu15:00-16:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA3 (1851)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Fr18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA4 (1852)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Fr09:00-10:50:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA5 (1853)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Fr14:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA6 (1854)		Instructor: CHAN, Ki Cecia, LI, Xin, MAK, Brian Kan Wing\n" + 
				"		Slot 1	Mo18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 2012 - Object-Oriented Programming and Data Structures (4 units)\n" + 
				"	Section L1 (1856)		Instructor: QUAN, Long\n" + 
				"		Slot 1	Mo13:30-14:50:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	Fr09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section L2 (1858)		Instructor: TSOI, Yau Chat\n" + 
				"		Slot 1	We15:00-16:20:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	Fr15:00-16:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section LA1 (1860)		Instructor: QUAN, Long, TSOI, Yau Chat\n" + 
				"		Slot 1	Th10:30-12:20:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA2 (1862)		Instructor: QUAN, Long, TSOI, Yau Chat\n" + 
				"		Slot 1	Th18:00-19:50:Rm 4221, Lift 19 (52)\n" + 
				"	Section LA3 (3956)		Instructor: QUAN, Long, TSOI, Yau Chat\n" + 
				"		Slot 1	Tu13:00-14:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 2012H - Honors Object-Oriented Programming and Data Structures (5 units)\n" + 
				"	Section L1 (1864)		Instructor: TSOI, Yau Chat\n" + 
				"		Slot 1	Tu13:30-15:20:Rm 2302, Lift 17-18 (74)\n" + 
				"		Slot 2	Th13:30-15:20:Rm 2302, Lift 17-18 (74)\n" + 
				"	Section LA1 (1865)		Instructor: TSOI, Yau Chat\n" + 
				"		Slot 1	Fr11:30-13:20:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 2611 - Computer Organization (4 units)\n" + 
				"	Section L1 (1866)		Instructor: LAM, Ngok\n" + 
				"		Slot 1	Mo13:30-14:50:Rm 2302, Lift 17-18 (74)\n" + 
				"		Slot 2	Fr09:00-10:20:Rm 2302, Lift 17-18 (74)\n" + 
				"	Section L2 (1868)		Instructor: LI, Xin\n" + 
				"		Slot 1	We16:30-17:50:Rm 6573, Lift 29-30 (88)\n" + 
				"		Slot 2	Fr16:30-17:50:Rm 6573, Lift 29-30 (88)\n" + 
				"	Section T1 (1873)		Instructor: LAM, Ngok, LI, Xin\n" + 
				"		Slot 1	Mo09:30-10:20:Rm 5583, Lift 29-30 (80)\n" + 
				"	Section T2 (1875)		Instructor: LAM, Ngok, LI, Xin\n" + 
				"		Slot 1	Tu15:00-15:50:Rm 5583, Lift 29-30 (80)\n" + 
				"	Section LA1 (1870)		Instructor: LAM, Ngok, LI, Xin\n" + 
				"		Slot 1	We09:00-09:50:Rm 4213, Lift 19 (67)\n" + 
				"	Section LA2 (1872)		Instructor: LAM, Ngok, LI, Xin\n" + 
				"		Slot 1	Fr13:30-14:20:Rm 4213, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 2711 - Discrete Mathematical Tools for Computer Science (4 units)\n" + 
				"	Section L1 (1876)		Instructor: WANG, Tao\n" + 
				"		Slot 1	Mo12:00-13:20:Rm 4620, Lift 31-32 (126)\n" + 
				"		Slot 2	We12:00-13:20:Rm 4620, Lift 31-32 (126)\n" + 
				"	Section L2 (1878)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	Tu16:30-17:50:Rm 2465, Lift 25-26 (122)\n" + 
				"		Slot 2	Th16:30-17:50:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section L3 (1880)		Instructor: PAPADOPOULOS, Dimitris\n" + 
				"		Slot 1	Mo13:30-14:50:Rm 4619, Lift 31-32 (126)\n" + 
				"		Slot 2	Fr09:00-10:20:Rm 4619, Lift 31-32 (126)\n" + 
				"	Section T1A (1882)		Instructor: WANG, Tao\n" + 
				"		Slot 1	Mo17:00-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"	Section T1B (1884)		Instructor: WANG, Tao\n" + 
				"		Slot 1	Th09:30-10:20:Rm 1410, Lift 25-26 (60)\n" + 
				"	Section T2A (1885)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	We09:30-10:20:Rm 2304, Lift 17-18 (76)\n" + 
				"	Section T2B (1886)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	Mo12:00-12:50:Rm 2304, Lift 17-18 (76)\n" + 
				"	Section T3A (1887)		Instructor: PAPADOPOULOS, Dimitris\n" + 
				"		Slot 1	Th18:00-18:50:Rm 1409, Lift 25-26 (60)\n" + 
				"	Section T3B (1888)		Instructor: PAPADOPOULOS, Dimitris\n" + 
				"		Slot 1	Fr12:00-12:50:Rm 1410, Lift 25-26 (60)\n" + 
				"\n" + 
				"COMP 2711H - Honors Discrete Mathematical Tools for Computer Science (4 units)\n" + 
				"	Section L1 (1889)		Instructor: ARYA, Sunil\n" + 
				"		Slot 1	Mo12:00-13:20:Rm 6591, Lift 31-32 (88)\n" + 
				"		Slot 2	We12:00-13:20:Rm 6591, Lift 31-32 (88)\n" + 
				"	Section T1 (1890)		Instructor: ARYA, Sunil\n" + 
				"		Slot 1	Mo17:00-17:50:Rm 2306, Lift 17-18 (111)\n" + 
				"\n" + 
				"COMP 3021 - Java Programming (3 units)\n" + 
				"	Section L1 (1891)		Instructor: CHEUNG, Shing Chi\n" + 
				"		Slot 1	Tu15:00-16:20:Rm 1103, Acad Concourse (100)\n" + 
				"		Slot 2	Th15:00-16:20:Rm 1103, Acad Concourse (100)\n" + 
				"	Section LA1 (1892)		Instructor: CHEUNG, Shing Chi\n" + 
				"		Slot 1	Th09:00-09:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 3031 - Principles of Programming Languages (3 units)\n" + 
				"	Section L1 (1893)		Instructor: LUO, Qiong\n" + 
				"		Slot 1	Mo10:30-11:50:Rm 2304, Lift 17-18 (76)\n" + 
				"		Slot 2	We10:30-11:50:Rm 2304, Lift 17-18 (76)\n" + 
				"	Section LA1 (1894)		Instructor: LUO, Qiong\n" + 
				"		Slot 1	We15:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 3111 - Software Engineering (4 units)\n" + 
				"	Section L1 (1895)		Instructor: ZHANG, Charles Chuan\n" + 
				"		Slot 1	Mo09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"		Slot 2	We09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"	Section L2 (1897)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"	Section LA1 (1899)		Instructor: LEUNG, Wai Ting, ZHANG, Charles Chuan\n" + 
				"		Slot 1	Fr09:30-11:20:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA2 (1901)		Instructor: LEUNG, Wai Ting, ZHANG, Charles Chuan\n" + 
				"		Slot 1	Th18:00-19:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA3 (1902)		Instructor: LEUNG, Wai Ting, ZHANG, Charles Chuan\n" + 
				"		Slot 1	We10:30-12:20:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 3111H - Honors Software Engineering (4 units)\n" + 
				"	Section L1 (1903)		Instructor: ZHANG, Charles Chuan\n" + 
				"		Slot 1	Mo09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"		Slot 2	We09:00-10:20:Rm 2306, Lift 17-18 (111)\n" + 
				"	Section L2 (1905)		Instructor: LEUNG, Wai Ting\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 2502, Lift 25-26 (120)\n" + 
				"	Section LA1 (1907)		Instructor: LEUNG, Wai Ting, ZHANG, Charles Chuan\n" + 
				"		Slot 1	Mo16:00-17:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 3211 - Fundamentals of Artificial Intelligence (3 units)\n" + 
				"	Section L1 (1910)		Instructor: LIN, Fangzhen\n" + 
				"		Slot 1	Tu13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"		Slot 2	Th13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"	Section T1 (1911)		Instructor: LIN, Fangzhen\n" + 
				"		Slot 1	Tu18:00-18:50:Rm 1104, Acad Concourse (120)\n" + 
				"\n" + 
				"COMP 3311 - Database Management Systems (3 units)\n" + 
				"	Section L1 (1912)		Instructor: LOCHOVSKY, Frederick Horst\n" + 
				"		Slot 1	Tu12:00-13:20:Lecture Theater K (106)\n" + 
				"		Slot 2	Th12:00-13:20:Lecture Theater K (106)\n" + 
				"	Section T1 (1917)		Instructor: LOCHOVSKY, Frederick Horst\n" + 
				"		Slot 1	Tu18:00-18:50:Rm 4502, Lift 25-26 (60)\n" + 
				"	Section T2 (1919)		Instructor: LOCHOVSKY, Frederick Horst\n" + 
				"		Slot 1	Th18:00-18:50:Rm 6591, Lift 31-32 (88)\n" + 
				"	Section LA1 (1914)		Instructor: LOCHOVSKY, Frederick Horst\n" + 
				"		Slot 1	Tu09:00-09:50:Rm 4210, Lift 19 (67)\n" + 
				"	Section LA2 (1916)		Instructor: LOCHOVSKY, Frederick Horst\n" + 
				"		Slot 1	Mo09:30-10:20:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 3511 - Operating Systems (3 units)\n" + 
				"	Section L1 (1920)		Instructor: LI, Bo\n" + 
				"		Slot 1	We16:30-17:50:Rm 4620, Lift 31-32 (126)\n" + 
				"		Slot 2	Fr16:30-17:50:Rm 4620, Lift 31-32 (126)\n" + 
				"	Section L2 (1922)		Instructor: WANG, Wei\n" + 
				"		Slot 1	Tu09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"		Slot 2	Th09:00-10:20:Rm 2407, Lift 17-18 (126)\n" + 
				"	Section LA1 (1924)		Instructor: LI, Bo, WANG, Wei\n" + 
				"		Slot 1	Mo12:00-13:50:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA2 (1926)		Instructor: LI, Bo, WANG, Wei\n" + 
				"		Slot 1	Mo14:00-15:50:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA3 (1927)		Instructor: LI, Bo, WANG, Wei\n" + 
				"		Slot 1	Mo18:00-19:50:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA4 (1928)		Instructor: LI, Bo, WANG, Wei\n" + 
				"		Slot 1	Tu18:00-19:50:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA5 (3954)		Instructor: LI, Bo, WANG, Wei\n" + 
				"		Slot 1	Sa11:00-12:50:Rm 4214, Lift 19 (52)\n" + 
				"\n" + 
				"COMP 3632 - Principles of Cybersecurity (3 units)\n" + 
				"	Section L1 (1929)		Instructor: WANG, Shuai\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 2504, Lift 25-26 (84)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 2504, Lift 25-26 (84)\n" + 
				"\n" + 
				"COMP 3711 - Design and Analysis of Algorithms (3 units)\n" + 
				"	Section L1 (1930)		Instructor: TAI, Chiew Lan\n" + 
				"		Slot 1	Tu10:30-11:50:Rm 2502, Lift 25-26 (120)\n" + 
				"		Slot 2	Th10:30-11:50:Rm 2502, Lift 25-26 (120)\n" + 
				"	Section L2 (1932)		Instructor: QU, Huamin\n" + 
				"		Slot 1	We13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"		Slot 2	Fr13:30-14:50:Rm 2502, Lift 25-26 (120)\n" + 
				"	Section T1 (1934)		Instructor: QU, Huamin, TAI, Chiew Lan\n" + 
				"		Slot 1	Fr12:00-12:50:Rm 2306, Lift 17-18 (111)\n" + 
				"	Section T2 (1936)		Instructor: QU, Huamin, TAI, Chiew Lan\n" + 
				"		Slot 1	Th14:00-14:50:Rm 2465, Lift 25-26 (122)\n" + 
				"	Section T3 (1937)		Instructor: QU, Huamin, TAI, Chiew Lan\n" + 
				"		Slot 1	We16:30-17:20:G010, CYT Bldg (140)\n" + 
				"\n" + 
				"COMP 3711H - Honors Design and Analysis of Algorithms (4 units)\n" + 
				"	Section L1 (1938)		Instructor: GOLIN, Mordecai Jay\n" + 
				"		Slot 1	Tu10:30-11:50:Rm 6591, Lift 31-32 (88)\n" + 
				"		Slot 2	Th10:30-11:50:Rm 6591, Lift 31-32 (88)\n" + 
				"	Section T1 (1939)		Instructor: GOLIN, Mordecai Jay\n" + 
				"		Slot 1	Fr12:00-12:50:Lecture Theater K (106)\n" + 
				"\n" + 
				"COMP 3721 - Theory of Computation (3 units)\n" + 
				"	Section L1 (1940)		Instructor: ZHANG, Nevin Lianwen\n" + 
				"		Slot 1	Tu09:00-10:20:Rm 6591, Lift 31-32 (88)\n" + 
				"		Slot 2	Th09:00-10:20:Rm 6591, Lift 31-32 (88)\n" + 
				"	Section T1 (1941)		Instructor: ZHANG, Nevin Lianwen\n" + 
				"		Slot 1	Tu12:30-13:20:G009A, CYT Bldg (80)\n" + 
				"\n" + 
				"COMP 4021 - Internet Computing (3 units)\n" + 
				"	Section L1 (1942)		Instructor: LEE, Dik Lun\n" + 
				"		Slot 1	Tu13:30-14:20:Rm 2404, Lift 17-18 (81)\n" + 
				"		Slot 2	Th13:30-14:20:Rm 2404, Lift 17-18 (81)\n" + 
				"	Section LA1 (1943)		Instructor: LEE, Dik Lun\n" + 
				"		Slot 1	Mo14:00-15:50:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 4211 - Machine Learning (3 units)\n" + 
				"	Section L1 (1944)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	Mo10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"		Slot 2	We10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"	Section T1 (1945)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	Mo15:00-15:50:Rm 2464, Lift 25-26 (122)\n" + 
				"\n" + 
				"COMP 4331 - Data Mining (3 units)\n" + 
				"	Section L1 (3878)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	Mo12:00-13:20:Lecture Theater E (143)\n" + 
				"		Slot 2	We12:00-13:20:Lecture Theater E (143)\n" + 
				"	Section T1 (3879)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	Tu15:00-15:50:Rm 4221, Lift 19 (52)\n" + 
				"	Section T2 (3880)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	Th12:00-12:50:Rm 4221, Lift 19 (52)\n" + 
				"\n" + 
				"COMP 4421 - Image Processing (3 units)\n" + 
				"	Section L1 (1946)		Instructor: CHUNG, Albert Chi Shing\n" + 
				"		Slot 1	We13:30-14:50:Rm 1103, Acad Concourse (100)\n" + 
				"		Slot 2	Fr13:30-14:50:Rm 1103, Acad Concourse (100)\n" + 
				"	Section T1 (1948)		Instructor: CHUNG, Albert Chi Shing\n" + 
				"		Slot 1	Mo14:00-14:50:Rm 2463, Lift 25-26 (42)\n" + 
				"	Section T2 (1950)		Instructor: CHUNG, Albert Chi Shing\n" + 
				"		Slot 1	Th17:00-17:50:Rm 6591, Lift 31-32 (88)\n" + 
				"\n" + 
				"COMP 4461 - Human-Computer Interaction (3 units)\n" + 
				"	Section L1 (1951)		Instructor: MA, Xiaojuan\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 1410, Lift 25-26 (60)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 1410, Lift 25-26 (60)\n" + 
				"	Section LA1 (1952)		Instructor: MA, Xiaojuan\n" + 
				"		Slot 1	Tu09:00-09:50:Rm 4213, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 4621 - Computer Communication Networks I (3 units)\n" + 
				"	Section L1 (1953)		Instructor: ZHANG, Qian\n" + 
				"		Slot 1	Mo10:30-11:50:Rm 2404, Lift 17-18 (81)\n" + 
				"		Slot 2	We10:30-11:50:Rm 2404, Lift 17-18 (81)\n" + 
				"	Section LA1 (1955)		Instructor: ZHANG, Qian\n" + 
				"		Slot 1	Tu09:30-10:20:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA2 (1957)		Instructor: ZHANG, Qian\n" + 
				"		Slot 1	Tu11:00-11:50:Rm 4214, Lift 19 (52)\n" + 
				"\n" + 
				"COMP 4651 - Cloud Computing and Big Data Systems (3 units)\n" + 
				"	Section L1 (1958)		Instructor: WANG, Wei\n" + 
				"		Slot 1	We13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"		Slot 2	Fr13:30-14:50:Rm 2464, Lift 25-26 (122)\n" + 
				"	Section LA1 (1960)		Instructor: WANG, Wei\n" + 
				"		Slot 1	Fr15:00-15:50:Rm 4214, Lift 19 (52)\n" + 
				"	Section LA2 (1962)		Instructor: WANG, Wei\n" + 
				"		Slot 1	Mo09:30-10:20:Rm 4214, Lift 19 (52)\n" + 
				"\n" + 
				"COMP 4900 - Academic and Professional Development (0 units)\n" + 
				"	Section T02 (1964)		Instructor: LUO, Qiong\n" + 
				"		Slot 1	We18:00-18:50:Lecture Theater C (213)\n" + 
				"	Section T03 (1965)		Instructor: CHEUNG, Shing Chi\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T04 (1966)		Instructor: TANG, Chi Keung\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T06 (1968)		Instructor: DING, Cunsheng\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T08 (1970)		Instructor: KWOK, James Tin Yau\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T09 (1971)		Instructor: SANDER, Pedro\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T11 (1973)		Instructor: ARYA, Sunil\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T13 (1975)		Instructor: CHEN, Kai\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T14 (1976)		Instructor: CHAN, Gary Shueng Han\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T15 (1977)		Instructor: LI, Xin\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T16 (1978)		Instructor: ZHANG, Nevin Lianwen\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T19 (1981)		Instructor: HORNER, Andrew Brian\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T23 (1985)		Instructor: YI, Ke\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T24 (1986)		Instructor: LIN, Fangzhen\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T25 (1987)		Instructor: TAI, Chiew Lan\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T26 (1988)		Instructor: MAK, Brian Kan Wing\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T27 (1989)		Instructor: MUPPALA, Kumaraswamy R Jogesh\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T30 (1992)		Instructor: CHUNG, Albert Chi Shing\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T31 (1993)		Instructor: CHAN, Ki Cecia\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T32 (1994)		Instructor: GOLIN, Mordecai Jay\n" + 
				"	Section T33 (1995)		Instructor: LAM, Ngok\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T34 (1996)		Instructor: LI, Bo\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T35 (1997)		Instructor: TSOI, Yau Chat\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T37 (1999)		Instructor: SONG, Yangqiu\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T38 (2000)		Instructor: WANG, Tao\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T40 (2002)		Instructor: ROSSITER, David\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T41 (2003)		Instructor: WONG, Raymond Chi Wing\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T42 (2004)		Instructor: LAM, Gibson\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T43 (3917)		Instructor: LI, Xin\n" + 
				"		Slot 1	We18:00-18:50:TBA\n" + 
				"	Section T44 (3980)		Instructor: LI, Xin\n" + 
				"\n" + 
				"COMP 4901L - Foundations of Computer Vision (3 units)\n" + 
				"	Section L1 (2005)		Instructor: TANG, Chi Keung\n" + 
				"		Slot 1	Tu16:30-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"		Slot 2	Th16:30-17:50:Rm 1410, Lift 25-26 (60)\n" + 
				"	Section LA1 (2006)		Instructor: TANG, Chi Keung\n" + 
				"		Slot 1	We12:30-13:20:Rm 4210, Lift 19 (67)\n" + 
				"\n" + 
				"COMP 5211 - Advanced Artificial Intelligence (3 units)\n" + 
				"	Section L1 (1105)		Instructor: LIN, Fangzhen\n" + 
				"		Slot 1	Tu09:00-10:20:Rm 1103, Acad Concourse (100)\n" + 
				"		Slot 2	Th09:00-10:20:Rm 1103, Acad Concourse (100)\n" + 
				"\n" + 
				"COMP 5222 - Statistical Learning Models for Text and Graph Data (3 units)\n" + 
				"	Section L1 (1107)		Instructor: SONG, Yangqiu\n" + 
				"		Slot 1	We13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"		Slot 2	Fr13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"\n" + 
				"COMP 5331 - Knowledge Discovery in Databases (3 units)\n" + 
				"	Section L1 (1108)		Instructor: WONG, Raymond Chi Wing\n" + 
				"		Slot 1	Mo10:30-11:50:Rm 2504, Lift 25-26 (84)\n" + 
				"		Slot 2	We10:30-11:50:Rm 2504, Lift 25-26 (84)\n" + 
				"\n" + 
				"COMP 5411 - Advanced Computer Graphics (3 units)\n" + 
				"	Section L1 (1109)		Instructor: SANDER, Pedro, TAI, Chiew Lan\n" + 
				"		Slot 1	We15:00-16:20:Rm 2503, Lift 25-26 (87)\n" + 
				"		Slot 2	Fr15:00-16:20:Rm 2503, Lift 25-26 (87)\n" + 
				"\n" + 
				"COMP 5621 - Computer Networks (3 units)\n" + 
				"	Section L1 (1110)		Instructor: BENSAOU, Brahim\n" + 
				"		Slot 1	Mo12:00-13:20:Rm 5583, Lift 29-30 (80)\n" + 
				"		Slot 2	We12:00-13:20:Rm 5583, Lift 29-30 (80)\n" + 
				"\n" + 
				"COMP 5631 - Cryptography and Security (3 units)\n" + 
				"	Section L1 (1111)		Instructor: DING, Cunsheng\n" + 
				"		Slot 1	Tu13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"		Slot 2	Th13:30-14:50:Rm 2503, Lift 25-26 (87)\n" + 
				"\n" + 
				"COMP 5711 - Introduction to Advanced Algorithmic Techniques (3 units)\n" + 
				"	Section L1 (1112)		Instructor: YI, Ke\n" + 
				"		Slot 1	Tu10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"		Slot 2	Th10:30-11:50:Rm 1103, Acad Concourse (100)\n" + 
				"\n" + 
				"COMP 6211D - Deep Learning (3 units)\n" + 
				"	Section L1 (1113)		Instructor: CHEN, Qifeng\n" + 
				"		Slot 1	Tu12:00-13:20:Rm 2503, Lift 25-26 (87)\n" + 
				"		Slot 2	Th12:00-13:20:Rm 2503, Lift 25-26 (87)\n" + 
				"\n" + 
				"COMP 6911 - Computer Science and Engineering Seminar I (0 units)\n" + 
				"	Section T1 (1114)		Instructor: TBA\n" + 
				"		Slot 1	Mo16:00-16:50:Lecture Theater F (134)\n" + 
				"\n" + 
				"COMP 6912 - Computer Science and Engineering Seminar II (1 unit)\n" + 
				"	Section T1 (1115)		Instructor: TBA\n" + 
				"		Slot 1	Mo16:00-16:50:Lecture Theater F (134)\n");
	}
	
	@Test
	// This test case tests the functionality of TIME_OF_DAY filters
	public void testTimeOfDay() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("MILE");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabFilter");
		CheckBox am = (CheckBox)s.lookup("#checkboxAM");
		CheckBox pm = (CheckBox)s.lookup("#checkboxPM");
		clickOn(am);
		assertTrue(
				(console.getText().contains("(1569)"))
				&& (console.getText().contains("(1570)"))
				);
		clickOn(am);
		clickOn(pm);
		assertTrue(
				(console.getText().contains("(1568)"))
				&& (console.getText().contains("(1570)"))
				&& (console.getText().contains("(1571)"))
				&& (console.getText().contains("(1572)"))
				&& (console.getText().contains("(1573)"))
				&& (console.getText().contains("(1574)"))
				);
		clickOn(am);
		assertTrue(
				(console.getText().contains("(1570)"))
				);
		clickOn("#buttonSelectAll");
		clickOn("#buttonSelectAll");
	}
	
	@Test
	// This test case tests the functionality of DAY_OF_WEEK filters
	public void testDayOfWeek() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("ENTR");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabFilter");
		CheckBox mon = (CheckBox)s.lookup("#checkboxMon");
		CheckBox tue = (CheckBox)s.lookup("#checkboxTue");
		CheckBox wed = (CheckBox)s.lookup("#checkboxWed");
		CheckBox thu = (CheckBox)s.lookup("#checkboxThu");
		CheckBox fri = (CheckBox)s.lookup("#checkboxFri");
		CheckBox sat = (CheckBox)s.lookup("#checkboxSat");
		clickOn(mon);
		assertEquals(console.getText(), "Displaying filtered courses:\n");
		clickOn(mon);
		clickOn(wed);
		assertTrue(
				(console.getText().contains("(2266)"))
				&& (console.getText().contains("(2267)"))
				);
		clickOn(fri);
		assertTrue(
				(console.getText().contains("(2266)"))
				);
		clickOn("#buttonSelectAll");
		clickOn("#buttonSelectAll");
	}
	
	@Test
	// This test case tests the functionality of CC, NO_EXCLUSION and LAB_TUTORIAL filters
	public void testMiscFilters() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		TextField subject = (TextField)s.lookup("#textfieldSubject");
		subject.setText("OCES");
		clickOn("#buttonSearch");
		while (console.getText().isEmpty()) { }
		clickOn("#tabFilter");
		CheckBox cc = (CheckBox)s.lookup("#checkboxCC");
		CheckBox ne = (CheckBox)s.lookup("#checkboxNoExclusion");
		CheckBox lt = (CheckBox)s.lookup("#checkboxLabTutorial");
		clickOn(cc);
		assertTrue(
				(console.getText().contains("(3509)"))
				);
		clickOn(cc);
		clickOn(ne);
		assertTrue(
				(console.getText().contains("(3508)"))
				&& (console.getText().contains("(3509)"))
				&& (console.getText().contains("(3510)"))
				&& (console.getText().contains("(3511)"))
				&& (console.getText().contains("(3512)"))
				&& (console.getText().contains("(3513)"))
				&& (console.getText().contains("(3514)"))
				);
		clickOn(ne);
		clickOn(lt);
		assertTrue(
				(console.getText().contains("(3510)"))
				&& (console.getText().contains("(3513)"))
				&& (console.getText().contains("(3514)"))
				&& (console.getText().contains("(1453)"))
				);
		clickOn("#buttonSelectAll");
		clickOn("#buttonSelectAll");
	}
	
	@Test
	// This test case tests the functionality Filter tab when course list is empty
	public void testEmptyList() {
		TextArea console = (TextArea)s.lookup("#textAreaConsole");
		clickOn("#tabFilter");
		clickOn("#buttonSelectAll");
		assertEquals(console.getText(), "Displaying filtered courses:\n");
		clickOn("#buttonSelectAll");
		assertEquals(console.getText(), "Displaying filtered courses:\n");
		clickOn("#buttonSelectAll");
		clickOn("#buttonSelectAll");
	}
}
