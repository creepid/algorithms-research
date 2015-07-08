/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.sorting.priority;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class TernaryHeapTest {
    
    public TernaryHeapTest() {
    }
    
    @Test
    public void test() {
        System.out.println("**** test ****");
        String actual = null;

        TernaryHeap<String> heap = new TernaryHeap<String>(11);

        heap.insert("P");
        heap.insert("Q");
        heap.insert("E");

        actual = heap.deleteMax();
        assertEquals("Q", actual);

        heap.insert("X");
        heap.insert("A");
        heap.insert("M");

        actual = heap.deleteMax();
        assertEquals("X", actual);

        heap.insert("P");
        heap.insert("L");
        heap.insert("E");

        actual = heap.deleteMax();
        assertEquals("P", actual);

        String[] expected = {null, "P", "M", "E", "A", "E", "L", null, null, null, null, null};
        assertArrayEquals(expected, heap.keys);
    }

    /**
     * Test of getSorted method, of class TernaryHeap.
     */
     @Test
    public void testSort() {
        System.out.println("**** test sort ****");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        TernaryHeap<String> heap = new TernaryHeap<>(a);
        Comparable[] sorted = heap.getSorted();

        Comparable[] expected = {"A", "E", "E", "L", "M", "O", "P", "R", "S", "T", "X"};
        assertArrayEquals(expected, sorted);

    }
    
}
