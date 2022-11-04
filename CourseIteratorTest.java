package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {
    CourseIterator CrseItr= new CourseIterator();
    ClassCourseList CrseList=new ClassCourseList();


    @Test
    void hasNext() {
        Course Cr=new Course("Ser 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr=new CourseIterator(ClassCourseList());
        assertTrue(CrseItr.hasNext());
    }


    @Test
    void next() {
        Course Cr=new Course("Ser 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr=new CourseIterator(ClassCourseList());
        assertNotNull(CrseItr.next());
    }


    @Test
    void remove() {
        int expected =0;
        Course Cr=new Course("SER 515-FSE",1);
        ClassCourseList.add(Cr);
        CourseIterator CrseItr= new CourseIterator(ClassCourseList);
        CrItr.next();
        CrItr.remove();
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