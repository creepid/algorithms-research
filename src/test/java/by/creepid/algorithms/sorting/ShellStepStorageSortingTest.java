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
public class ShellStepStorageSortingTest {

    public ShellStepStorageSortingTest() {
    }

    /**
     * Test of sort method, of class ShellSorting.
     */
    @Test
    public void testSort() {
        System.out.println("***** sort *******");

        String[] a = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ShellStepStorageSorting.sort(a);

        String[] expected = {"A", "E", "E", "E", "H", "L", "L", "L", "M", "O", "P", "R", "S", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }

}
