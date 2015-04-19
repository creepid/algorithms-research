/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

import by.creepid.algorithms.basic.Ln.Factorial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class LnTest {
    
    @Test
    public void testLn() {
        Ln.Factorial factorial = new Factorial(6);
        double result = Ln.ln(factorial);
        assertEquals(6.579, result, 0.01);
        
        factorial = new Factorial(0);
        result = Ln.ln(factorial);
        assertEquals(0, result, 0.0);
    }
}