/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class BinaryHeapTest {

    public BinaryHeapTest() {
    }

    /**
     * Test of insert method, of class BinaryHeap.
     */
    @Test
    public void test() {
        System.out.println("**** test ****");
        String actual = null;

        BinaryHeap<String> binaryHeap = new BinaryHeap<String>(11);

        binaryHeap.insert("P");
        binaryHeap.insert("Q");
        binaryHeap.insert("E");

        actual = binaryHeap.deleteMax();
        assertEquals("Q", actual);

        binaryHeap.insert("X");
        binaryHeap.insert("A");
        binaryHeap.insert("M");

        actual = binaryHeap.deleteMax();
        assertEquals("X", actual);

        binaryHeap.insert("P");
        binaryHeap.insert("L");
        binaryHeap.insert("E");

        actual = binaryHeap.deleteMax();
        assertEquals("P", actual);

        String[] expected = {null, "P", "M", "L", "A", "E", "E", null, null, null, null, null};
        assertArrayEquals(expected, binaryHeap.pq);
    }

    @Test
    public void testSort() {
        System.out.println("**** test sort ****");

        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        BinaryHeap<String> heap = new BinaryHeap<>(a);
        Comparable[] sorted = heap.getSorted();

        Comparable[] expected = {"A", "E", "E", "L", "M", "O", "P", "R", "S", "T", "X"};
        assertArrayEquals(expected, sorted);

    }

}
