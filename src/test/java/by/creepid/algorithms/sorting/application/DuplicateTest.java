/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class DuplicateTest {

    public DuplicateTest() {
    }

    /**
     * Test of getVariousCount method, of class Duplicate.
     */
    @Test
    public void testGetVariousCount() {
        String[] a = {"E", "M", "T", "G", "V", "E", "S", "G", "E", "T"};
        int count = Duplicate.getVariousCount(a);
        assertEquals(6, count);

        String[] b = {"E", "T", "E", "E", "T", "E", "T"};
        count = Duplicate.getVariousCount(b);
        assertEquals(2, count);
    }

    /**
     * Test of getDuplicateCount method, of class Duplicate.
     */
    @Test
    public void testGetDuplicateCount() {
        String[] a = {"E", "M", "T", "G", "V", "E", "S", "G", "E", "T"};
        int count = Duplicate.getDuplicateCount(a);
        assertEquals(4, count);

        String[] b = {"E", "T", "E", "E", "T", "E", "T"};
        count = Duplicate.getDuplicateCount(b);
        assertEquals(5, count);
    }

}
