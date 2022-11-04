package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    String strCrs = "SER 515-FSE";
    int theLevel=0;
    Assignment Aa=new Assignment();
    Course Cr=new Course(strCrs,theLevel);


    @Test
    void addAssignment() {
        int expected=1;
        Cr.addAssignment(Aa);
        assertEquals(expected, Cr.assignmentList.size());

    }

    @Test
    void testToString() {
        assertEquals(strCrs,Cr.toString());
    }

    @Test
    void accept() {
        Cr.accept(new ReminderVisitor());
        assertTrue(Cr.isAccepted());
    }
}