/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

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
public class BreadthPathsTest {

    private UndirectedGraph g;

    public BreadthPathsTest() {
    }

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/41graph/tinyCG.txt";
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

        BreadthPaths instance = new BreadthPaths(g, 5);
        boolean expResult = true;
        boolean result = instance.hasPathTo(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of pathTo method, of class DepthPaths.
     */
    @Test
    public void testPathTo() {
        System.out.println("**** pathTo ****");
       BreadthPaths instance = new BreadthPaths(g, 5);

        Iterator<Integer> iterator = instance.pathTo(1).iterator();
        int[] actual = new int[3];
        int i = 0;
        while (iterator.hasNext()) {
            actual[i++] = iterator.next();
        }

        int[] expected = {5, 0, 1};
        assertArrayEquals(expected, actual);
    }

}
