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
public class QuickSortingSignalKeysTest {

    public QuickSortingSignalKeysTest() {
    }

    /**
     * Test of sort method, of class QuickSortingSignalKeys.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "Z", "Z", "Z", "M", "P", "L", "E"};
        QuickSortingSignalKeys.sort(a);

        String[] expected = {"A", "C", "E", "E", "I", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "X", "Z", "Z", "Z"};

        Assert.assertArrayEquals(expected, a);
    }

}
