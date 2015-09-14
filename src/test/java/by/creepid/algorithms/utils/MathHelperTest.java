/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class MathHelperTest {
    

    /**
     * Test of log2 method, of class MathHelper.
     */
    @Test
    public void testLog2() {
        System.out.println("log2");
        double num = 32.0;
        double expResult = 5.0;
        double result = MathHelper.log2(num);
        assertEquals(expResult, result, 0.1);
    }
}