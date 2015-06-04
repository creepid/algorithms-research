/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class InsertionSantinelSortingTest {

    public InsertionSantinelSortingTest() {
    }

    /**
     * Test of sort method, of class InsertionSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSantinelSorting.sort(a);

        String[] expected = {"A", "E", "E", "L", "M", "O", "P", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);

    }

}
