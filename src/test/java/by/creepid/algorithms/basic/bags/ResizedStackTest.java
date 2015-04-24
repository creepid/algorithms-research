/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class ResizedStackTest {

    private ResizedStack<Integer> stack = new ResizedStack<>();

    public ResizedStackTest() {
    }

    /**
     * Test of push method, of class ResizedStack.
     */
    @Test
    public void test() {
        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 1000; ++idx) {
            int randomInt = randomGenerator.nextInt(100);
            stack.push(randomInt);
        }
        assertEquals(1000, stack.size());
        
        for (int idx = 1; idx <= 100; ++idx) {
            assertNotNull(stack.pop());
        }
        assertEquals(900, stack.size());
        
        
    }

}
