/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class BinarySearchTest {


    /**
     * Test of countLessThen method, of class BinarySearch.
     */
    @Test
    public void testCountLessThen() {
        System.out.println("countLessThen");
        double key = 15;
        double[] a = {5, 6, 6, 12, 15, 15, 15, 18, 18};
        int expResult = 4;
        int result = BinarySearch.countLessThen(key, a);
        assertEquals(expResult, result);

        double[] b = {5, 6, 6, 6, 12, 12, 15, 16, 17, 18, 18, 18};
        expResult = 6;
        result = BinarySearch.countLessThen(key, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method, of class BinarySearch.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        double key = 15;
        double[] a = {5, 6, 6, 12, 15, 15, 15, 18, 18};
        int expResult = 3;
        int result = BinarySearch.count(key, a);
        assertEquals(expResult, result);
    }
}