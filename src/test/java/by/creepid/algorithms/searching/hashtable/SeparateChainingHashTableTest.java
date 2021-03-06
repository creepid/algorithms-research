/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author mirash
 */
public class SeparateChainingHashTableTest {

    public SeparateChainingHashTableTest() {
    }
    private SeparateChainingHashTable<String, Integer> instance;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void before() {
        instance = new SeparateChainingHashTable<String, Integer>(5);

        instance.put("S", 0);
        instance.put("E", 1);
        instance.put("A", 2);
        instance.put("R", 3);
        instance.put("C", 4);
        instance.put("H", 5);
        instance.put("E", 6);
        instance.put("X", 7);
        instance.put("A", 8);
        instance.put("M", 9);
        instance.put("P", 10);
        instance.put("L", 11);
        instance.put("E", 12);
    }

    @After
    public void after() {
        instance = null;
    }

    /**
     * Test of get method, of class SeparateChainingHashTable.
     */
    @Test
    public void testGet() {
        System.out.println("***** get *****");
        Integer expResult = 11;
        Integer result = instance.get("L");
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class SeparateChainingHashTable.
     */
    @Test
    public void testPut() {
        System.out.println("***** put *****");
        instance.put("A", 64);

        Integer expResult = 64;
        Integer result = instance.get("A");
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class SeparateChainingHashTable.
     */
    @Test
    public void testDelete() {
        System.out.println("***** delete ******");
        instance.delete("X");

        Integer result = instance.get("X");
        assertNull(result);
    }

    /**
     * Test of calc method, of class SeparateChainingHashTable.
     */
    @Test
    public void testCalc() {
        System.out.println("**** calc ****");
        double expResult = 3.0;
        double result = instance.calcX2();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of isRandom method, of class SeparateChainingHashTable.
     */
    @Test
    public void testIsRandom() {
        System.out.println("**** isRandom *****");
        boolean expResult = true;
        boolean result = instance.isRandom();
        assertEquals(expResult, result);
    }
}