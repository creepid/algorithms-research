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
public class ConnectedComponentsDepthSearchTest {

    private UndirectedGraph g;

    public ConnectedComponentsDepthSearchTest() {
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
     * Test of connected method, of class ConnectedComponentsDepthSearch.
     */
    @Test
    public void testConnected() {
        System.out.println("**** connected *****");
        int v = 9;
        int w = 12;
        ConnectedComponentsDepthSearch instance = new ConnectedComponentsDepthSearch(g);
        boolean expResult = true;
        boolean result = instance.connected(v, w);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method, of class ConnectedComponentsDepthSearch.
     */
    @Test
    public void testCount() {
        System.out.println("**** count *****");
        ConnectedComponentsDepthSearch instance = new ConnectedComponentsDepthSearch(g);
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of component method, of class ConnectedComponentsDepthSearch.
     */
    @Test
    public void testComponent() {
        System.out.println("**** component ****");
        int v = 7;
        ConnectedComponentsDepthSearch instance = new ConnectedComponentsDepthSearch(g);
        int expResult = 1;
        int result = instance.component(v);
        assertEquals(expResult, result);
    }

}
