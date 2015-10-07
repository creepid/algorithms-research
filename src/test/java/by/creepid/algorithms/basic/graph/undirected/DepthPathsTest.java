/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.graph.undirected;

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
public class DepthPathsTest {

    private UndirectedGraph g;

    public DepthPathsTest() {
    }

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/41graph/tinyG.txt";
        DataInput input = new DataInput(urlName);

        this.g = new UndirectedGraph(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test of hasPathTo method, of class DepthPaths.
     */
    @Test
    public void testHasPathTo() {
        System.out.println("**** hasPathTo ****");

        DepthPaths instance = new DepthPaths(g, 5);
        boolean expResult = true;
        boolean result = instance.hasPathTo(6);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.hasPathTo(12);
        assertEquals(expResult, result);

    }

    /**
     * Test of pathTo method, of class DepthPaths.
     */
    @Test
    public void testPathTo() {
        System.out.println("**** pathTo ****");
        DepthPaths instance = new DepthPaths(g, 3);

        Iterator<Integer> iterator = instance.pathTo(2).iterator();
        int[] actual = new int[6];
        int i = 0;
        while (iterator.hasNext()) {
            actual[i++] = iterator.next();
        }

        int[] expected = {3, 5, 4, 6, 0, 2};
        assertArrayEquals(expected, actual);
    }

}
