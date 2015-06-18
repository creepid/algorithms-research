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
public class MergeSortingWithoutSyncTest {

    public MergeSortingWithoutSyncTest() {
    }

    /**
     * Test of sort method, of class MergeSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeSortingWithoutSync.sort(a);

        String[] expected = {"A", "E", "E", "E", "E", "G", "L", "M", "M", "O", "P", "R", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }
}