package linkedList;

import  org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyListTest {
    MyList ml;
    Link[] testList = new Link[]{new Link("two",2),new Link("akarmi",4)};

    @Before
    public void setUp() throws Exception {
        ml = new MyList();
    }

    @After
    public void tearDown() throws Exception {
        ml = null;
    }

    @Test
    public void testAddAll() throws Exception {
        ml.addAll(testList);
        assertEquals(2, ml.size());
    }

    @Test
    public void testPrint(){
        ml.print();
    }
}