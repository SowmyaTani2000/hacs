package hacs;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    Assignment Aa=new Assignment();
    Solution Ss=new Solution();


    @Test
    void setDueDate() {
        Date Da=new Date();
        Aa.setDueDate(Da);
        assertEquals(Da,Aa.getDueDateString());

    }

    @Test
    void setAssSpec() {
        String input="The assignment should be original";
        Aa.setAssSpec(input);
        assertEquals(input,Aa.getAssSpec());
    }

    @Test
    void isOverDue() {
        assertEquals(true,Aa.IsOverDue());
    }

    @Test
    void addSolution() {
        int expected = 1;
        Aa.addSolution(Ss);

        assertEquals(expected,Aa.getSolutionList().size());
    }

    @Test
    void submitSolution() {
        Aa.submitSolution();
    }

    @Test
    void getSolutionList() {
        Aa.addSolution(Ss);
    }

    @Test
    void getSolution() {
        Ss.setTheAuthor("Sowmya");
        Aa.addSolution(Ss);
        assertEquals("Sowmya",Aa.getSolution("Sowmya").getTheAuthor());
    }

    @Test
    void getSugSolution() {
        assertTrue(Aa.getSuggestSolution() instanceof Solution);
    }

    @Test
    void getSolutionIterator() {
        int expected=0;
        SolutionIterator solutionIterator=Aa.getSolutionIterator();
        assertEquals(expected,Aa.toString());
    }

    @Test
    void testToString() {
        String input =" Hacs Assignment";
        Aa.setAssSpec(input);
        assertEquals(input,Aa.toString());
    }

    @Test
    void getDueDateString() {
        Date Du=new Date();
        Aa.setDueDate(Du);
        DateFormat Df=DateFormat.getDateInstance(DateFormat.SHORT);
        assertEquals(Df.format(Df),Aa.getDueDateString());
    }

}