package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution Ss=new Solution();
    @Test
    void testToString() {
        Ss.setTheAuthor("Sowmya");
        assertEquals("Sowmya's Solutions= 0 ",Ss.toString());

    }

    @Test
    void getGradeString() {

    }

    @Test
    void getGradeInt() {
    }

}