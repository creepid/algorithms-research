/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.fast;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class QuickWithInsertionSortingTest {

    public QuickWithInsertionSortingTest() {
    }

    /**
     * Test of sort method, of class QuickWithInsertionSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickWithInsertionSorting.sort(a);

        String[] expected = {"A", "C", "E", "E", "I", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "X"};

        Assert.assertArrayEquals(expected, a);
    }

}
