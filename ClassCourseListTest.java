package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    @Test
    void initializeFromFile() {
        int expected =6;
        ClassCourseList.initializeFromFile("UserCourse.txt");
        assertEquals(expected, ClassCourseList.size());
    }

    @Test
    void findCourseByCourseName() {
        String crseName="SER 515";
        ClassCourseList.initializeFromFile("UserCourse.txt");
        assertEquals(crseName, ClassCourseList.findCourseByCourseName(crseName).toString());
    }
}