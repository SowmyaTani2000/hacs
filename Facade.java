package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Facade {
	public int UserType;
	private Course theSelecteCourse = null;
	private int nCourseLevel = 0;
	public ClassCourseList theCourseList;
	public Person thePerson;
	public static final int STUDENT_USER_TYPE=0;
	public static final int INSTRUCTOR_USER_TYPE=0;

	public Facade() {
		System.out.println("Facade is Implemented");
	}

	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
		return login.isExit();
	}
	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == STUDENT_USER_TYPE)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}
	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	void submitSolution(Assignment theAssignment, Solution theSolution) {

		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new Student();
		} else
		{
			thePerson = new Instructor();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and initialize it with the file CourseInfo.txt
	 */
	public void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}
	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCoureList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelecteCourse = findCourseByCourseName(strCourseName);
					if (theSelecteCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.addCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelecteCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.CurrentCourse = theSelecteCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		thePerson.CreateCourseMenu(theSelecteCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}

}