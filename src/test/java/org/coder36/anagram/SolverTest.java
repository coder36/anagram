package org.coder36.anagram;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class for anagram solver
 * @author Mark Middleton
 */
public class SolverTest {

    @Test
    public void testReorder() {
        Solver solver = new Solver( new String[] {} );
        assertEquals( "iknst", solver.toAlphaOrder("knits") );
        assertEquals( "orrst", solver.toAlphaOrder("rrots") );
    }

    @Test
    public void testFind() throws Exception {
        String [] dict = new String [] { "knits", "stink", "rots", "sort", "kinship" };
        Solver solver = new Solver( dict );
        List<String[]> l = solver.find();
        assertArrayEquals(new String[]{"rots", "sort"}, Find.findRowWith("rots", l) );
        assertArrayEquals(new String[]{"knits", "stink"}, Find.findRowWith("stink", l) );
        assertArrayEquals(new String[]{"kinship"}, Find.findRowWith("kinship", l) );
    }

}
