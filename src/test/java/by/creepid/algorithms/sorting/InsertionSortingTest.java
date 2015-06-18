/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class InsertionSortingTest {

    public InsertionSortingTest() {
    }

    /**
     * Test of sort method, of class InsertionSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSorting.sort(a);

        String[] expected = {"A", "E", "E", "L", "M", "O", "P", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);

    }

    @Test
    public void testSortInterval() {
        System.out.println("****** sort interval*******");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        InsertionSorting.sort(a, 3, 6);

        String[] expected = {"S", "O", "R", "A", "E", "T", "X", "M", "P", "L", "E"};

        Assert.assertArrayEquals(expected, a);
    }

}
