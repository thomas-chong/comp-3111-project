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
	/**
	 * @param courseList the list of all scraped courses
	 * @return result the list of filtered courses
	 */
	public List<Course> getFilteredCourseList(List<Course> courseList) {
		Vector<Course> result = new Vector<Course>();
		for (Course c : courseList) {
			Vector<Section> matches = new Vector<Section>();
			for (int i = 0; i < c.getNumSections(); ++i) {
				Section s = c.getSection(i);
				if (
					((!filter[filterType.NO_EXCLUSION.ordinal()]) || (filter[filterType.NO_EXCLUSION.ordinal()]) && (!c.hasExclusion()))		// NO_EXCLUSION Filter	
					&& ((!filter[filterType.LAB_TUTORIAL.ordinal()]) || (filter[filterType.LAB_TUTORIAL.ordinal()]) && (c.hasLabTutorial()))	// LAB_TUTORIAL Filter
					&& ((!filter[filterType.CC.ordinal()]) || (filter[filterType.CC.ordinal()]) && (c.isCC()))									// CC Filter
					&& ((!filter[filterType.AM.ordinal()]) || (filter[filterType.AM.ordinal()]) && (s.hasTime(timeType.AM)))					// AM Filter
					&& ((!filter[filterType.PM.ordinal()]) || (filter[filterType.PM.ordinal()]) && (s.hasTime(timeType.PM)))					// PM Filter
					&& ((!filter[filterType.MON.ordinal()]) || (filter[filterType.MON.ordinal()]) && (s.hasDay(dayType.MON)))					// MON Filter
					&& ((!filter[filterType.TUE.ordinal()]) || (filter[filterType.TUE.ordinal()]) && (s.hasDay(dayType.TUE)))					// TUE Filter
					&& ((!filter[filterType.WED.ordinal()]) || (filter[filterType.WED.ordinal()]) && (s.hasDay(dayType.WED)))					// WED Filter
					&& ((!filter[filterType.THU.ordinal()]) || (filter[filterType.THU.ordinal()]) && (s.hasDay(dayType.THU)))					// THU Filter
					&& ((!filter[filterType.FRI.ordinal()]) || (filter[filterType.FRI.ordinal()]) && (s.hasDay(dayType.FRI)))					// FRI Filter
					&& ((!filter[filterType.SAT.ordinal()]) || (filter[filterType.SAT.ordinal()]) && (s.hasDay(dayType.SAT)))					// SAT Filter
				) {
					matches.add(s);
				}
			}
			if (!matches.isEmpty()) {
				Course t = new Course();
				t.setTitle(c.getTitle());
				t.setExclusion(c.getExclusion());
				t.setIsCC(c.isCC());
				for (int j = 0; j < matches.size(); ++j) {
					t.addSection(matches.get(j));
				}
				result.add(t);
			}
		}
		return result;
	}
	
	public void setFilter(filterType selection, boolean input) {
		filter[selection.ordinal()] = input;
	}
}
