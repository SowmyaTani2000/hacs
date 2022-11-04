package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    Instructor Ins=new Instructor();

    @Test
    void createCourseMenu() {
        CourseMenu Cm= Ins.createCourseMenu(new Course("SER 515",0),0);
        assertTrue(Cm instanceof HighLevelCourseMenu);
    }
}