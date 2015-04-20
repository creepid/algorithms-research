/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class RationalTest {

    private Rational x, y, z;

    public RationalTest() {
    }

    /**
     * Test of plus method, of class Rational.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);

        assertEquals(5, z.getNumerator());
        assertEquals(6, z.getDenominator());

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        assertEquals(1, z.getNumerator());
        assertEquals(1, z.getDenominator());

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        assertEquals(1, z.getNumerator());
        assertEquals(120000000, z.getDenominator());

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        assertEquals(1073741789, z.getNumerator());
        assertEquals(12, z.getDenominator());
    }

    /**
     * Test of minus method, of class Rational.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        assertEquals(1, z.getNumerator());
        assertEquals(-3, z.getDenominator());
    }

    /**
     * Test of times method, of class Rational.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        //  4/17 * 17/4 = 1
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        assertEquals(1, z.getNumerator());
        assertEquals(1, z.getDenominator());

        // 3037141/3247033 * 3037547/3246599 = 841/961 
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        assertEquals(841, z.getNumerator());
        assertEquals(961, z.getDenominator());
    }

}