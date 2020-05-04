package comp3111.coursescraper;

import java.util.List;
import java.util.Vector;

enum filterType {AM, PM, MON, TUE, WED, THU, FRI, SAT, CC, NO_EXCLUSION, LAB_TUTORIAL};

public class Filter {
	private static final int MAX_FILTER_NUM = 11;
	
	private static boolean [] filter = {false, false, false, false, false, false, false, false, false, false, false};
	
	public Filter() {
		
	}
	
	public int getFilterNum() {
		return MAX_FILTER_NUM;
	}
	
	public boolean[] getAllFilter() {
		return filter;
	}
	
	public List<Course> getFilteredCourseList(List<Course> courseList) {
		Vector<Course> result = new Vector<Course>();
		for (Course c : courseList) {
			if (
				((filter[filterType.AM.ordinal()]) && (c.hasTime(timeType.AM)))				// AM Filter
				&& ((filter[filterType.PM.ordinal()]) && (c.hasTime(timeType.PM)))			// PM Filter
				&& ((filter[filterType.MON.ordinal()]) && (c.hasDay(dayType.MON)))			// MON Filter
				&& ((filter[filterType.TUE.ordinal()]) && (c.hasDay(dayType.TUE)))			// TUE Filter
				&& ((filter[filterType.WED.ordinal()]) && (c.hasDay(dayType.WED)))			// WED Filter
				&& ((filter[filterType.THU.ordinal()]) && (c.hasDay(dayType.THU)))			// THU Filter
				&& ((filter[filterType.FRI.ordinal()]) && (c.hasDay(dayType.FRI)))			// FRI Filter
				&& ((filter[filterType.SAT.ordinal()]) && (c.hasDay(dayType.SAT)))			// SAT Filter
				&& ((filter[filterType.CC.ordinal()]) && (c.isCC()))						// CC Filter
				&& ((filter[filterType.NO_EXCLUSION.ordinal()]) && (!c.hasExclusion()))		// NO_EXCLUSION Filter
				&& ((filter[filterType.MON.ordinal()]) && (c.hasLabTutorial()))				// LAB_TUTORIAL Filter
			) {
				result.add(c);
			}
		}
		return result;
	}
	
	public void setFilter(filterType selection, boolean input) {
		filter[selection.ordinal()] = input;
	}
}
