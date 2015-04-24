/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class LinkedListQueueTest {

    private Queue<String> queue = new LinkedListQueue<>();

    public LinkedListQueueTest() {
        queue.enqueue("1111");
        queue.enqueue("455");
        queue.enqueue("zzzzzzzz");
    }

    /**
     * Test of isEmpty method, of class LinkedListQueue.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(queue.isEmpty());
    }

    /**
     * Test of size method, of class LinkedListQueue.
     */
    @Test
    public void testSize() {
        assertTrue(queue.size() >= 3);
    }

    /**
     * Test of enqueue method, of class LinkedListQueue.
     */
    @Test
    public void testEnqueue() {
        queue.enqueue("555");
    }

    /**
     * Test of dequeue method, of class LinkedListQueue.
     */
    @Test
    public void testDequeue() {
        String first = queue.dequeue();
        assertEquals("1111", first);
    }

}
