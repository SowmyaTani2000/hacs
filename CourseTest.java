package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    String strCrse= "SER 515-FSE";
    int theLevel=0;
    Course Cr=new Course(strCrse,theLevel);

    @Test
    void addAssignment() {
    }

    @Test
    void testToString() {
        assertEquals(strCrse,Cr.toString());
    }

    @Test
    void accept() {
        Cr.accept(new ReminderVisitor());
        assertTrue(Cr.isAccepted());
    }
}