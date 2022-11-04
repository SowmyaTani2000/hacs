package hacs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {


    @Test
    void getTheList() {
        int expected = 1;
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(1);
        ListIterator Ls = new ListIterator(testList);
        {
            assertArrayEquals(expected, Ls.getTheList().size());
        }
    }

    @Test
    void hasNext() {
        ArrayList<Object>testList=new ArrayList<>();
        testList.add(1);
        ListIterator Lr= new ListIterator(testList);
        assertTrue( Lr.hasNext());
        }
    }

    @Test
    Object next() {
        ArrayList<Object>testList=new ArrayList<>();
        testList.add(1);
        ListIteratorTest Lr= new ListIteratorTest();
        assertNotNull(Lr.next());

    }

    @Test
    void remove() {
        int expected =0;
        ArrayList<Object> testList=new ArrayList<>();
        testList.add(1);
        ListIterator Lr=new ListIterator(testList);
        Lr.next();
        Lr.remove();
        assertEquals(expected, Lr.getTheList().size());

    }
}