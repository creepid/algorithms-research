/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.utils.DataInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class CycleDepthSearchTest {

    private UndirectedGraph g;

    public CycleDepthSearchTest() {
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
     * Test of hasCycle method, of class CycleDepthSearch.
     */
    @Test
    public void testHasCycle() {
        System.out.println("**** hasCycle ****");
        CycleDepthSearch instance = new CycleDepthSearch(g);
        boolean expResult = true;
        boolean result = instance.hasCycle();
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
