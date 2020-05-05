package comp3111.coursescraper;

import java.util.List;
import java.util.Vector;

enum filterType {AM, PM, MON, TUE, WED, THU, FRI, SAT, CC, NO_EXCLUSION, LAB_TUTORIAL};

/**
 * Filter class handles filter-toggling and information-filtering. A Filter handler provides methods for the invoker to apply/unapply filters, and to retrieve a List of filtered Courses generated from applying activated filters onto a given List of Courses.
 * <br><br>	
 * A set of more readable enumeration <em>filterType</em> has been defined for toggling specific filters. These include:
 * <ul>
 * 	<li><em>AM</em>, which represents "show only Sections with at least one Slot in AM"</li>
 * 	<li><em>PM</em>, which represents "show only Sections with at least one Slot in PM"</li>
 * 	<li><em>MON</em>, which represents "show only Sections with at least one Slot on Monday"</li>
 * 	<li><em>TUE</em>, which represents "show only Sections with at least one Slot on Tuesday"</li>
 * 	<li><em>WED</em>, which represents "show only Sections with at least one Slot on Wednesday"</li>
 * 	<li><em>THU</em>, which represents "show only Sections with at least one Slot on Thursday"</li>
 * 	<li><em>FRI</em>, which represents "show only Sections with at least one Slot on Friday"</li>
 * 	<li><em>SAT</em>, which represents "show only Sections with at least one Slot on Saturday"</li>
 * 	<li><em>CC</em>, which represents "show only Sections of Courses which are 4Y CC"</li>
 * 	<li><em>NO_EXCLUSION</em>, which represents "show only Sections of Courses which do not define exclusions"</li>
 * 	<li><em>LAB_TUTORIAL</em>, which represents "show only Sections of Courses which have labs or tutorials"</li>
 * </ul>
 * <br>
 * The filters are combined with AND logic. For example, if both MON and WED filters are applied, the filtered list of Courses should contain Sections with Slots on both Monday and Wednesday.
 * 
 * @author lky-bulbasaur
 */

public class Filter {
	private static boolean [] filter = {false, false, false, false, false, false, false, false, false, false, false};
	
	/**
	 * Default constructor of Filter class.
	 */
	public Filter() {
		
	}
	
	/**
	 * Constructs and returns a List of Courses which contains only Courses and their Sections that satisfies the criteria specified by the active filters. These matching Courses and Sections are deep-copied from the Course elements of the input <em>courseList</em> and the Sections they own. Each Course element in the returned List contains only Sections that match the activated filters. Courses with no matching Sections will not appear in the returned List. 
	 * @param courseList a List of Courses to be filtered
	 * @return a List of filtered Courses
	 */
	public List<Course> getFilteredCourseList(List<Course> courseList) {
		if (courseList == null) return null;
		
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
				Course t = c.cloneWithoutSections();
				for (int j = 0; j < matches.size(); ++j) {
					t.addSection(matches.get(j));
				}
				result.add(t);
			}
		}
		return result;
	}
	
	/**
	 * Toggles on/off the selected filter given a boolean <em>input</em>.
	 * @param selection the filter to be activated/deactivated
	 * @param input true for filter-activation; false for filter-deactivation
	 */
	public void setFilter(filterType selection, boolean input) {
		filter[selection.ordinal()] = input;
	}
}
