package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student Stu=new Student();

    @Test
    void createCourseMenu() {
        CourseMenu Cm=Stu.CreateCourseMenu(new Course("SER-515-FSE",0),0);
        assertTrue(Cm instanceof HighLevelCourseMenu);
    }

}