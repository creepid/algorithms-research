/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.utils.DataInput;
import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class DirectedCycleImplTest {

    private Digraph g;

    public DirectedCycleImplTest() {
    }

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        DataInput input = new DataInput(urlName);

        this.g = new DigraphImpl(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test of cycle method, of class DirectedCycleImpl.
     */
    @Test
    public void testCycle() {
        System.out.println("**** cycle ****");
        DirectedCycleImpl instance = new DirectedCycleImpl(g);

        Iterator<Integer> result = instance.cycle().iterator();
        int[] actual = new int[4];
        int i = 0;
        while (result.hasNext()) {
            actual[i++] = result.next();
        }

        int[] expected = {3, 5, 4, 3};
        assertArrayEquals(expected, actual);

    }

    /**
     * Test of hasCycle method, of class DirectedCycleImpl.
     */
    @Test
    public void testHasCycle() {
        System.out.println("**** hasCycle ****");
        DirectedCycleImpl instance = new DirectedCycleImpl(g);
        boolean expResult = true;
        boolean result = instance.hasCycle();
        assertEquals(expResult, result);
    }

}
