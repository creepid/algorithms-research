/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author mirash
 */
public class LeastRecentlyUsedCacheTest {

    private LeastRecentlyUsedCache<Integer, String> instance;

    public LeastRecentlyUsedCacheTest() {
    }

    @Before
    public void setUp() {
        instance = new LeastRecentlyUsedCache<>(3);
        instance.set(34, "34");
        instance.set(3, "3");
        instance.set(-99, "99");
    }

    @After
    public void setDown() {
        instance = null;

    }

    /**
     * Test of set method, of class LeastRecentlyUsedCache.
     */
    @Test
    public void testSet() {
        System.out.println("**** test LRU *****");

        instance.set(3, "000");
        assertEquals("000", instance.head.value);
        assertEquals("000", instance.get(3));

        assertNotNull(instance.get(34));

        instance.set(15, "15");
        assertEquals("15", instance.head.value);
        assertEquals("15", instance.get(15));
        
        assertNull(instance.get(99));
    }

}