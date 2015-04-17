/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class PrimeTest {

    public PrimeTest() {
    }

    @Test
    public void testIsPrime() {
        assertTrue(Prime.isPrime(3));
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(169));
    }

}
