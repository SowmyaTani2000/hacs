package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    Facade fa=new Facade();
    ClassCourseList clr=new ClassCourseList();

    @Test
    void submitSolution() {
        int expected=1;
        Assignment Aa= new Assignment();
        fa.submitSolution(Aa, fa);
        assertEquals(expected, Aa.addSolution().size());
    }

    @Test
    void createUser() {
        UserInfoItem usr=new UserInfoItem();
        usr.UserType=UserInfoItem.USER_TYPE.Student;
        fa.createUser(UserInfoItem);
        assertTrue(fa.thePerson instanceof Student);

    }

    @Test
    void createCourseList() {
        int expected=6;
        fa.createCourseList();
        assertEquals(expected, fa.theCourseList.size());
    }

    @Test
    void attachCourseToUser() {
        int expected=2;
        UserInfoItem Usr=new UserInfoItem();
        Usr.UserType=UserInfoItem.USER_TYPE.Student;
        Usr.strUserName="SOW";
        fa.createUser(Usr);
        fa.createCourseList();
        fa.attachCourseToUser();
        assertEquals(expected, fa.thePerson.getCourseList().size());
    }
}