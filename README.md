# COMP3111: Software Engineering Project - Course Scraper

## Introduction
The project is about web scraping - retrieving and analysing data from some websites automatically. A team of three was formed to work on a project.

## Team Members [T-24]

### 1. CHONG, Cheuk Hei
> email: chchongaa | github: thomas-chong | dev-branch: thomas-test
> Task 1 & Task 5

### 2. LAW, Kai Yuet
> email: kylawah | github: lky-bulbasaur | dev_branch: ian-test
> Task 2 & Task 3

### 3. LI, Lok Yin
> email: lyliaf | github: justinlyli | dev_branch: justin-test
> Task 4 & Task 6

## My Task Details

### Task 1:
1. Properly handle the 404 page not found - display an appropriate message on the screen to notify the users and not throwing error on the system console.
2. Introduce the class section that model the concept of sections.
3. Modify the skeleton code so that when the search button is clicked, the section information is also displayed on each row.
4. Display Total Number of difference sections in this search: NUMBER_OF_SECTIONS in console. NUMBER_OF_SECTIONS shall include all sections even if those sections contains only invalid slot.
5. Display Total Number of Course in this search: NUMBER_OF_COURSES in console. NUMBER_OF_COURSES shall include all courses that has at least one lecture section, or a lab section, or a tutorial section. (Thus, COMP7990 is excluded).
6. Display Instructors who has teaching assignment this term but does not need to teach at Tu 3:10pm: INSTRUCTOR_NAME1, INSTRUCTOR_NAME2, INSTRUCTOR_NAME3,... where the list INSTRUCTOR_NAME are the subset of the union of the instructors' name obtained in the current search. It should contain all and only those has no teaching assignment at Tu 3:10pm.
7. Sort the order of the instructor's name ascendingly according to the alphabetical order of their display name. Display name refers to LAST_NAME, First_name.

### Task 5:
1. When Search or All Subject Search is clicked, obtains the list of all subjects from the base_url + TERM.
2. Print Total Number of Categories/Code Prefix: ALL_SUBJECT_COUNT in console where ALL_SUBJECT_COUNT is the size of the list.
3. Search all subjects when the button All Subject Search is clicked again.
4. After one subject is scraped. Print the SUBJECT is done on the system console (System.out.println).
5. Update the progress bar by the fraction 1 / ALL_SUBJECT_COUNT.
6. Print Total Number of Courses fetched: TOTAL_NUMBER_OF_COURSES when all subjects scraped. The TOTAL_NUMBER_OF_COURSES includes all courses with course code (i.e., SCIE2500 is included).
