package comp3111.coursescraper;

public class SFQ {
	private String title;
	private String instructor;
	private double sfq;
	public SFQ() {
		title = "";
		instructor = "";
		sfq = 0;
	}
	public SFQ(String t, String i, double s) {
		title = t;
		instructor = i;
		sfq = s;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	public String getTitle() {
		return title;
	}
	public void setInstructor(String i) {
		instructor = i;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setSFQ(double s) {
		sfq = s;
	}
	public double getSFQ() {
		return sfq;
	}
	
	public void clear() {
		title = "";
		instructor = "";
		sfq = 0;
	}
}
