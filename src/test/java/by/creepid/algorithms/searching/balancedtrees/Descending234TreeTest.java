/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.balancedtrees;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class Descending234TreeTest {

    private Descending234Tree<String, Integer> bt;

    @Before
    public void beforeMethod() {
        bt = new Descending234Tree<String, Integer>();
        bt.put("S", 4);
        bt.put("E", 5);
        bt.put("A", 66);
        bt.put("R", 0);
        bt.put("C", 2);
        bt.put("H", 7);
        bt.put("X", 3);
        bt.put("M", 78);
        bt.put("P", 12);
        bt.put("L", 9);
    }

    @After
    public void afterMethod() {
        bt = null;
    }

    /**
     * Test of put method, of class RedBlackTree.
     */
    @Test
    public void testPut() {
        System.out.println("****** testPut *******");
        bt.put("G", 12);
        bt.put("L", 9);
    }

    @Test
    public void testGet() {
        System.out.println("****** testGet *******");
        int res = bt.get("M");
        assertEquals(78, res);
    }

    @Test
    public void testDeleteMin() {
        System.out.println("***** testDeleteMin ******");
        Descending234Tree<String, Integer> bt23 = new Descending234Tree<String, Integer>();
        bt23.put("B", 12);
        bt23.put("E", 2);
        bt23.put("A", 15);
        bt23.put("D", 1);
        bt23.put("C", 0);
        
        
        assertEquals((long)15, (long)bt23.get("A"));
        bt23.deleteMin();
        
        assertNull(bt23.get("A"));
    }

}
