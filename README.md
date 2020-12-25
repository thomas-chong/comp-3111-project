# COMP3111: Software Engineering Project - Course Scraper

# Introduction
The project is about web scraping - retrieving and analysing data from some websites automatically. A team of three was formed to work on a project.

# My Score
* Activity 1 - System Requirement Specification: 6/6 (Full marks)
    * A data model diagram: 1/1
    * A use-case diagram: 1/1
    * The workload distribution among your team: 1/1
    * A GitHub link properly setup: 1/1
    * A use-case specification of each of your tasks: 2/2
* Activity 2 - Software Implementation and Testing: 24/24 (Full marks)
    * At least 3 meeting minutes by the end of the project: 1/1
    * A Gantt chart and a burn down chart: 1/1
    * A README file stating the name of team members and their tasks assigned
    * A running program and the source code: 8/8 + 8/8 = 16/16
    * Unit testing of your implemented tasks: 2/2
    * Coverage test (>65% branch coverage): 2/2
    * Git commit log at GitHub: 1/1
    * Documenting your implemented features using JavaDoc: 1/1

# Team Members [T-24]

## 1. CHONG, Cheuk Hei
> email: chchongaa | github: thomas-chong | dev-branch: thomas-test
> Task 1 & Task 5

## 2. LAW, Kai Yuet
> email: kylawah | github: lky-bulbasaur | dev_branch: ian-test
> Task 2 & Task 3

## 3. LI, Lok Yin
> email: lyliaf | github: justinlyli | dev_branch: justin-test
> Task 4 & Task 6

# System Requirements
There are 6 tasks for each group to complete. Each student should complete TWO of the tasks. Each task carries 20 points for full marks which will be converted to 8 points of your course total.

Noted that the some tasks are in a hierarchy structure. No point will be awarded if the parent task is not completed. Points are given in all-or-nothing fashion.

# Task Details

![](doc-img/summary.png)

1. `Backend`  
	1. Properly handle the 404 page not found - display an appropriate message on the screen to notify the users and not throwing error on the system console. [4]
	1. Introduce the class `section` that model the concept of sections. [2]
		1. Modify the skeleton code so that when the `search` button is clicked, the section information is also displayed on each row. [4]
	1. When the `search` button is clicked, 
		1. Display `Total Number of difference sections in this search: NUMBER_OF_SECTIONS` in console. NUMBER_OF_SECTIONS shall include all sections even if those sections contains only invalid slot. [3]
		1. Display `Total Number of Course in this search: NUMBER_OF_COURSES` in console. NUMBER_OF_COURSES shall include all courses that has at least one lecture section, or a lab section, or a tutorial section. (Thus, COMP7990 is excluded) . [3]
		1. Display `Instructors who has teaching assignment this term but does not need to teach at Tu 3:10pm: INSTRUCTOR_NAME1, INSTRUCTOR_NAME2, INSTRUCTOR_NAME3,...` where the list INSTRUCTOR_NAME are the subset of the union of the instructors' name obtained in the current search. It should contains all and only those has no teaching assignment at Tu 3:10pm. [3]
			1. Sort the order of the instructor's name ascendingly according to the alphabetical order of their display name. Display name refers to `LAST_NAME, First_name`.[1]
1. `Filter`
	1. When `Select All` is clicked. 
		1. All boxes on this tab are checked. [2]
		1. The text of that button will be changed to `De-select All`. [1]
			1. When `De-select All` is clicked. 
				1. The text of that button will be change back to `Select All`. [2]
				1. All boxes on this tab are unchecked. [1]
	1. When the status of any box on this tab is changed (checked or unchecked), the console will be cleared and filtered informations are displayed. [2]
		1. If the boxes `AM` (or `PM`) is checked, display only all sections of the courses which has a slot in `AM` (or in `PM`). [2]
			1. If both `AM` and `PM` are checked, display only all sections of the courses that has a slot that starts at `AM` and ends at `PM`, or a section has a slot in `AM` and another slot in `PM`.[2]  
		1. If any boxes of days of the week (Monday, Tuesday, ...) is clicked, display only all sections of the courses that has slots on the selected boxes. Thus, if only Monday and Tuesday are clicks, only sections that has slot on both Monday and Tuesday will be displayed. [2]
		1. If `Common Core` is clicked, display only all sections of the courses that are 4Y CC.[2]
		1. If `No Exclusion` is clicked, display only all sections of the courses that does not define exclusion.[2] 				       
	 	1. If `With Labs or Tutorial` is clicked, display only all sections of the courses that has labs or tutorials.[2]
	1. *Note: filters are combined with AND logic. Therefore, if multiple filters are applied, display all sections of the courses which simultaneously fulfills the requirements.*
1. `List`
	1. Fill the table correctly with the result of the `Filter`. If the `Filter` cannot be correctly implemented, show all result scrapped. [9]
		1. Make all cell uneditable except for the column `Enroll`.  [2]
		1. Each row in the column `Enroll` should contains a checkbox. [2]
			1. When the status of the checkbox on this tab is changed, the console will be cleared and filtered informations are displayed. [1]
				1. In addition, it displays `The following sections are enrolled:` on the console, followed the list of the enrolled sections (order is not important). [2]
				 	1. The enrollment status will be persistent even when another search is performed, another filter is applied, or selecting other tabs. [2]
				 	1. The enrollment status will be erased only when the checkbox is unchecked. [2] 		 	
1. `Timetable`
	1. Update the table when enrollment status is changed. [2]	
	1. Create a block on the `timetable` tab for each slot of the enrolled section. [10]
		1. Each block should contains both course code and section code in two lines. [2]
		1. Same background color should be applied to the block of the same section while different color should be applied to block with different sections. [2]
		1. If there are time clash happens, the boxes of the time clashed slot will be overlapped. [2]
			1. The overlapped area will be displayed in different color. Similar to. [2]
			
			![](doc-img/overlapped.png)
	1. *Note: If `Enrollment` cannot be correctly implemented in `List`, enroll the first 5 sections of the scrapped data. Enroll to all sections if there are less than 5 sections from the scrapped data. In this case the table shall be changed when a search/all subject search is performed.*

1. `All Subject Search`
	1. When `Search` or `All Subject Search` is clicked, obtains the list of all subjects from the `base_url + TERM`. 
		1. Print `Total Number of Categories/Code Prefix: ALL_SUBJECT_COUNT` in console where `ALL_SUBJECT_COUNT` is the size of the list. [5] 
		1. Search all subjects when the button `All Subject Search` is clicked again. [4]
			1. After one subject is scraped. Print the `SUBJECT is done` on the system console (System.out.println). [3].
				1. Update the progress bar by the fraction 1 / ALL_SUBJECT_COUNT. [4]
			1. Print `Total Number of Courses fetched: TOTAL_NUMBER_OF_COURSES` when all subjects scraped. The TOTAL_NUMBER_OF_COURSES includes all courses with course code (i.e., SCIE2500 is included). [4]
	1. *Note: after all subject search is clicked, tab `Filter`, `List`, `Backend` shall show different result.*
1. 	`SFQ`
	1. Make `Find SFQ with my enrolled courses` disabled before `search` or `All Subject Search` is clicked. [1]
		1. Make `Find SFQ with my enrolled courses` enabled after `search` or `All Subject Search` is clicked. [1]
	1. When `Find SFQ with my enrolled courses` is clicked, scrape data from SFQ URL.
		1. Print unadjusted SFQ data (not the data inside[]) of the enrolled courses on console. [5]
			1. If multiple section are available for a course, take the average unadjusted SFQ data and print it. (simple average is needed, no need to consider the number of students). [4]
	1. When `List instructors' average SFQ`, print all instructors' name and their unadjusted SFQ score on console. [5].
			1. If an instructor has taught more than one sections/courses, all unadjusted SFQ score of the sections taught by him/her will be added and divided by number of sections. [4]  			
	1. *Note: If `Enrollment` cannot be correctly implemented in `List`, enroll the first 5 sections of the scrapped data. Enroll to all sections if there are less than 5 sections from the scrapped data. In this case the table shall be changed when a search/all subject search is performed.*
	1. *Note: You can assume that no login is required when you scrape the SFQ page. You might want to download the page and stored in your harddisk for testing. During our grading we will host it at somewhere does not require login.*

# Technical Requirement

1. The program must use Java 8 or Java 10. 
1. The project must use Gradle to manage.
1. The program must use JavaFX as its only GUI framework. No Swing or AWT should be allowed.
1. You may choose your own IDE. We recommend Eclipse IDE.
1. JUnit 4.12 as your testing suite
1. Jacoco as your test coverage measurement