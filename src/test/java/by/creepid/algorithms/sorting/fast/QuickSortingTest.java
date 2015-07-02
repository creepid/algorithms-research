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
public class QuickSortingTest {

    public QuickSortingTest() {
    }

    /**
     * Test of sort method, of class QuickSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickSorting.sort(a);

        String[] expected = {"A", "C", "E", "E", "I", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "X"};

        Assert.assertArrayEquals(expected, a);

        String[] a2 = {"S", "Q", "U", "S", "I", "C", "K", "S", "O", "R", "T", "T", "T", "T", "T", "E", "X", "A", "Z", "Z", "Z", "S", "M", "P", "L", "E"};
        QuickSorting.sort(a2);

        String[] expected2 = {"A", "C", "E", "E", "I", "K", "L", "M", "O", "P", "Q", "R", "S", "S", "S", "S", "T", "T", "T", "T", "T", "U", "X", "Z", "Z", "Z"};

        Assert.assertArrayEquals(expected2, a2);
    }

}
