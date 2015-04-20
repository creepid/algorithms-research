/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class EuclidTest {

    @Test
    public void testGcd() {
        int p = 10;
        int q = 5;

        long result = Euclid.gcd(p, q);
        assertEquals(5, result);

        p = 17;
        q = 13;
        result = Euclid.gcd(p, q);
        assertEquals(1, result);

        p = 5;
        q = 7;
        result = Euclid.gcd(p, q);
        assertEquals(1, result);

        p = 0;
        q = 3;
        result = Euclid.gcd(p, q);
        assertEquals(3, result);
    }

}
