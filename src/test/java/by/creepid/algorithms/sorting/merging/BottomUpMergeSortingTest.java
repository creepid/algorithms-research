/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class BottomUpMergeSortingTest {

    public BottomUpMergeSortingTest() {
    }

    /**
     * Test of sort method, of class BottomUpMergeSorting.
     */
    @Test
    public void testSort() {
        System.out.println("****** sort *******");

        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        BottomUpMergeSorting.sort(a);

        String[] expected = {"A", "E", "E", "E", "E", "G", "L", "M", "M", "O", "P", "R", "R", "S", "T", "X"};

        Assert.assertArrayEquals(expected, a);
    }

}
