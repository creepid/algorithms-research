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
public class DegreesImplTest {

    private Digraph g;

    public DegreesImplTest() {
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
     * Test of indegree method, of class DegreesImpl.
     */
    @Test
    public void testIndegree() {
        System.out.println("**** indegree *****");
        int v = 9;
        DegreesImpl instance = new DegreesImpl(g);
        int expResult = 3;
        int result = instance.indegree(v);
        assertEquals(expResult, result);

        v = 8;
        expResult = 1;
        result = instance.indegree(v);
        assertEquals(expResult, result);
    }

    /**
     * Test of outdegree method, of class DegreesImpl.
     */
    @Test
    public void testOutdegree() {
        System.out.println("**** outdegree ****");
        int v = 4;
        DegreesImpl instance = new DegreesImpl(g);
        int expResult = 2;
        int result = instance.outdegree(v);
        assertEquals(expResult, result);

        v = 1;
        expResult = 0;
        result = instance.outdegree(v);
        assertEquals(expResult, result);
    }

    /**
     * Test of sources method, of class DegreesImpl.
     */
    @Test
    public void testSources() {
        System.out.println("**** sources ****");
        DegreesImpl instance = new DegreesImpl(g);
        Iterator<Integer> sources = instance.sources().iterator();
        while (sources.hasNext()) {
            assertEquals(7l, (long) sources.next());
        }

    }

    /**
     * Test of sinks method, of class DegreesImpl.
     */
    @Test
    public void testSinks() {
        System.out.println("**** sinks ****");
        DegreesImpl instance = new DegreesImpl(g);
        Iterator<Integer> sinks = instance.sinks().iterator();
        while (sinks.hasNext()) {
            assertEquals(1l, (long) sinks.next());
        }

    }

    /**
     * Test of isMap method, of class DegreesImpl.
     */
    @Test
    public void testIsMap() {
        System.out.println("**** isMap ****");
        DegreesImpl instance = new DegreesImpl(g);
        assertFalse(instance.isMap());
    }

}
