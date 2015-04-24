/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.basic.bags;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;


/**
 *
 * @author rusakovich
 */
public class FixedCapacitySimpleStackTest {
    
    private FixedCapacitySimpleStack<Integer> instance;
    
    public FixedCapacitySimpleStackTest() {
        this.instance = new FixedCapacitySimpleStack<>(10);
        
        this.instance.push(23);
        this.instance.push(15);
        this.instance.push(-2);
    }

    /**
     * Test of isEmpty method, of class FixedCapacitySimpleStack.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of size method, of class FixedCapacitySimpleStack.
     */
    @Test
    public void testSize() {
        assertEquals(3, instance.size());
    }

    /**
     * Test of pop method, of class FixedCapacitySimpleStack.
     */
    @Test
    public void testPop() {
        assertEquals(-2, (int)instance.pop());
    }

    /**
     * Test of push method, of class FixedCapacitySimpleStack.
     */
    @Test
    public void testPush() {
    }
    
}
