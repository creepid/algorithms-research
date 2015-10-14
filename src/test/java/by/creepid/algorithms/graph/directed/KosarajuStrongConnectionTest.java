/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.utils.DataInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class KosarajuStrongConnectionTest {

    private Digraph g;

    public KosarajuStrongConnectionTest() {
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
     * Test of stronglyConnected method, of class KosarajuStrongConnection.
     */
    @Test
    public void testStronglyConnected() {
        System.out.println("**** stronglyConnected ****");
        int v = 5;
        int w = 4;
        KosarajuStrongConnection instance = new KosarajuStrongConnection(g);
        boolean expResult = true;
        boolean result = instance.stronglyConnected(v, w);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method, of class KosarajuStrongConnection.
     */
    @Test
    public void testCount() {
        System.out.println("**** count ****");
        KosarajuStrongConnection instance = new KosarajuStrongConnection(g);
        int expResult = 5;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of id method, of class KosarajuStrongConnection.
     */
    @Test
    public void testId() {
        System.out.println("**** id ****");
        int v = 6;
        KosarajuStrongConnection instance = new KosarajuStrongConnection(g);
        int expResult = 3;
        int result = instance.id(v);
        assertEquals(expResult, result);
    }

}
