/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import by.creepid.algorithms.sorting.BaseSorting;
import by.creepid.algorithms.sorting.fast.QuickSorting;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class MedianTest {

    public MedianTest() {
    }

    /**
     * Test of select method, of class Median.
     */
    @Test
    public void testSelect() {
        System.out.println("******* test select *******");
        String[] a = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        
        QuickSorting.sort(a);
        BaseSorting.show(a);
        
        String median = (String)Median.select(a, 5);
        assertEquals("K", median);
    }

}
