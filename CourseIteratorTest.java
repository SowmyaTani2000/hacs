package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {

    @Test
    void hasNext() {
        Course Cr=new Course("Ser 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr=new CourseIterator(new ClassCourseList());
        assertTrue(CrseItr.hasNext());
    }


    @Test
    void next() {
        Course Cr=new Course("Ser 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr=new CourseIterator(new ClassCourseList());
        assertNotNull(CrseItr.next());
    }

    @Test
    void remove() {
        int expected =0;
        Course Cr=new Course("SER 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr= new CourseIterator(ClassCourseList);
        CrseItr.next();
        CrseItr.remove();
        assertEquals(expected, CrseItr.getTheCourseList().size());
    }
    @Test
    void testNext() {
        Course Cr=new Course("Ser 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr= new CourseIterator(ClassCourseList);
        assertNotNull(CrseItr.next("SER 515-FSE"));

    }
}