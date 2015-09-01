/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.balancedtrees;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author rusakovich
 */
public class RedBlackTreeTest {

    private RedBlackTree<String, Integer> bt;

    @Before
    public void beforeMethod() {
        bt = new RedBlackTree<String, Integer>();
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

}
