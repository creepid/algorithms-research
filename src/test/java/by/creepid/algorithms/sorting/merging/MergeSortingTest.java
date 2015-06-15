/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class MergeSortingTest {

    public MergeSortingTest() {
    }

    /**
     * Test of sort method, of class MergeSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeSorting.sort(a);

        String[] expected = {"A", "E", "E", "E", "E", "G", "L", "M", "M", "O", "P", "R", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }

}
