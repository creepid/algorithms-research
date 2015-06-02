/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mirash
 */
public class ShellSortingTest {

    /**
     * Test of sort method, of class ShellSorting.
     */
    @Test
    public void testSort() {
        System.out.println("***** sort *******");

        String[] a = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ShellSorting.sort(a);

        String[] expected = {"A", "E", "E", "E", "H", "L", "L", "L", "M", "O", "P", "R", "S", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }
}