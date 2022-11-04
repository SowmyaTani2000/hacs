package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class CourseSelectDlg extends JDialog {
	public static int HIGH_LEVEL_COURSE=0;
	public static int LOW_LEVEL_COURSE=1;

	ClassCourseList theCourseList;
	Course selectedCourse;
	int nCourseLevel = 0;
	boolean m_bLogout = false;
	JComboBox<Course> CourseNameCom = new JComboBox<Course>();
	JRadioButton HighLevelRadio = new JRadioButton();
	JRadioButton LowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();

	JButton oKButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public CourseSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		CourseNameCom.setBounds(new Rectangle(155, 41, 203, 22));
		HighLevelRadio.setText("HighLevel");
		HighLevelRadio.setBounds(new Rectangle(50, 87, 103, 26));
		LowLevelRadio.setToolTipText("");
		LowLevelRadio.setSelected(true);
		LowLevelRadio.setText("LowLevel");
		LowLevelRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("CourseName");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		oKButton.setText("OK");
		oKButton.setBounds(new Rectangle(78, 139, 79, 29));
		oKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oKButtonActionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogoutActionPerformed(e);
			}
		});
		this.getContentPane().add(CourseNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(HighLevelRadio, null);
		this.getContentPane().add(LowLevelRadio, null);
		this.getContentPane().add(oKButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(HighLevelRadio);
		buttonGroup1.add(LowLevelRadio);
	}
	public Course showDlg(ClassCourseList courseList) {
		theCourseList = courseList;
		CourseIterator theIterator = new CourseIterator(theCourseList);
		Course theCourse;
		while ((theCourse = (Course) theIterator.next()) != null)
		{
			CourseNameCom.addItem(theCourse);
		}
		setVisible(true);
		return selectedCourse;
	}

	void oKButtonActionPerformed(ActionEvent e) {
		selectedCourse = (Course) CourseNameCom.getSelectedItem();
		if (HighLevelRadio.isSelected())
			nCourseLevel = HIGH_LEVEL_COURSE=0;
		else
			nCourseLevel = LOW_LEVEL_COURSE=1;
		setVisible(false);
	}

	public boolean isLogout() {
		return m_bLogout;
	}

	void buttonLogoutActionPerformed(ActionEvent e) {
		m_bLogout = true;
		setVisible(false);
	}
}