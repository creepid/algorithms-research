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
public class QuickSortingEqualsKeysPassTest {

    public QuickSortingEqualsKeysPassTest() {
    }

    /**
     * Test of sort method, of class QuickSortingEqualsKeysPass.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"S", "Q", "U", "S", "I", "C", "K", "S", "O", "R", "T", "T", "T", "T", "T", "E", "X", "A", "Z", "Z", "Z", "S", "M", "P", "L", "E"};
        QuickSortingEqualsKeysPass.sort(a);

        String[] expected = {"A", "C", "E", "E", "I", "K", "L", "M", "O", "P", "Q", "R", "S", "S", "S", "S", "T", "T", "T", "T", "T", "U", "X", "Z", "Z", "Z"};

        Assert.assertArrayEquals(expected, a);

    }

}
