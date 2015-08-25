/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.binarytree;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class BinaryTreeBaseTest {

    private BinaryTreeBase<String, Integer> bt;

    public BinaryTreeBaseTest() {
    }

    @Before
    public void beforeMethod() {
        bt = new BinaryTreeBase<String, Integer>();
        bt.put("A", 2);
        bt.put("C", 1);
        bt.put("E", 6);
        bt.put("H", 2);
        bt.put("M", 1);
        bt.put("R", 3);
        bt.put("S", 8);
        bt.put("X", 1);
    }

    @After
    public void afterMethod() {
        bt = null;
    }

    /**
     * Test of size method, of class BinaryTreeBase.
     */
    @Test
    public void testSize() {
        System.out.println("***** testSize ******");
        assertEquals(8, bt.size());
    }

    /**
     * Test of get method, of class BinaryTreeBase.
     */
    @Test
    public void testGet() {
        System.out.println("***** testGet ******");
        assertEquals((long) 6, (long) bt.get("E"));
    }

    /**
     * Test of put method, of class BinaryTreeBase.
     */
    @Test
    public void testPut() {
        System.out.println("***** testPut ******");
        bt.put("L", 4);
        assertEquals((long) 4, (long) bt.get("L"));
    }

    /**
     * Test of min method, of class BinaryTreeBase.
     */
    @Test
    public void testMin() {
        System.out.println("**** testMin *****");
        assertEquals("A", bt.min());
    }

    /**
     * Test of max method, of class BinaryTreeBase.
     */
    @Test
    public void testMax() {
        System.out.println("****  testMax *****");
        assertEquals("X", bt.max());
    }

    /**
     * Test of floor method, of class BinaryTreeBase.
     */
    @Test
    public void testFloor() {
        System.out.println("****  testFloor *****");
        assertEquals("E", bt.floor("G"));
    }

    /**
     * Test of ceiling method, of class BinaryTreeBase.
     */
    @Test
    public void testCeiling() {
        System.out.println("****  testCeiling *****");
         assertEquals("E", bt.floor("G"));
    }

    /**
     * Test of rank method, of class BinaryTreeBase.
     */
    @Test
    public void testRank() {
        System.out.println("****  testRank *****");
        assertEquals((long)3, (long)bt.rank("H"));
    }

    /**
     * Test of select method, of class BinaryTreeBase.
     */
    @Test
    public void testSelect() {
        System.out.println("****  testSelect *****");
        assertEquals("H", bt.select(3));
    }

    /**
     * Test of deleteMin method, of class BinaryTreeBase.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("****  testDeleteMin *****");
        bt.deleteMin();
        assertNull(bt.get("A"));
    }

    /**
     * Test of delete method, of class BinaryTreeBase.
     */
    @Test
    public void testDelete() {
        System.out.println("****  testDelete *****");
        bt.delete("E");
        assertNull(bt.get("E"));
    }

}
