/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mirash
 */
public class MergeHalfReverseSortingTest {
    
    public MergeHalfReverseSortingTest() {
    }
    
    /**
     * Test of merge method, of class MergeHalfReverseSorting.
     */
    @Test
    public void testMerge() {
        System.out.println("****** sort *******");

        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeHalfReverseSorting.sort(a);

        String[] expected = {"A", "E", "E", "E", "E", "G", "L", "M", "M", "O", "P", "R", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }
}