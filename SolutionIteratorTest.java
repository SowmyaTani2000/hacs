package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {
    SolutionList Sl= new SolutionList();
    Solution Ss=new Solution();

    @Test
    void moveToHead() {
       int expected=-1;
       Sl.add(Ss);
       SolutionIterator Si=new SolutionIterator(Sl);
       Si.moveToHead();
       assertEquals(expected, Si.getCurrentSolutionNumber());
    }

    @Test
    void hasNext() {
        Sl.add(Ss);
        SolutionIterator Si=new SolutionIterator(Sl);
        assertNotNull(Si.hasNext());
    }

    @Test
    void next() {
        Ss.setTheAuthor("sowmya");
        Sl.add(Ss);
        SolutionIterator Si=new SolutionIterator(Sl);
        assertNotNull(Si.next("sowmya"));
    }

    @Test
    void testNext() {
        Sl.add(Ss);
        SolutionIterator Si=new SolutionIterator(Ss);
        assertNotNull(Si.next());
    }


    @Test
    void remove() {
        int expected=0;
        Sl.add(Ss);
        SolutionIterator Si=new SolutionIterator(Sl);
        Si.next();
        Si.remove();
        assertEquals(expected, Si.Sl.size());
    }
}