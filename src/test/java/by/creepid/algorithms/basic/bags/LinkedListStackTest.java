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
public class LinkedListStackTest {

    private LinkedListStack<String> stack = new LinkedListStack<>();

    public LinkedListStackTest() {
        stack.push("3333");
        stack.push("dfgdf dfg");
        stack.push("bbbb");
    }

    /**
     * Test of pop method, of class LinkedListStack.
     */
    @Test
    public void testPop() {
        assertEquals("bbbb", stack.pop());
    }

    /**
     * Test of isEmpty method, of class LinkedListStack.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of size method, of class LinkedListStack.
     */
    @Test
    public void testSize() {
        assertEquals(3, stack.size());
    }

    @Test
    public void testMax() {
        LinkedListStack<Integer> nums = new LinkedListStack<>();

        nums.push(34);
        nums.push(13);
        nums.push(-234);
        nums.push(45);
        nums.push(2);

        assertEquals(45, (int) nums.max());
    }

}
