/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class SparseVectorTest {

    public SparseVectorTest() {
    }

    /**
     * Test of dot method, of class SparseVector.
     */
    @Test
    public void testDot() {
        System.out.println("***** dot ******");
        int n = 5;

        SparseVector[] a = new SparseVector[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new SparseVector();
        }

        double[] b = new double[n];
        double[] x = {0.05, 0.04, 0.36, 0.37, 0.19};

        a[0].put(1, 0.90);

        a[1].put(2, 0.36);
        a[1].put(3, 0.36);
        a[1].put(4, 0.18);

        a[2].put(3, 0.90);

        a[3].put(0, 0.90);

        a[4].put(0, 0.45);
        a[4].put(2, 0.45);

        for (int i = 0; i < n; i++) {
            b[i] = a[i].dot(x);
        }

        double[] expected = {0.036, 0.297, 0.333, 0.045, 0.1845};
        assertArrayEquals(expected, b, 0.001);
    }

    /**
     * Test of sum method, of class SparseVector.
     */
    @Test
    public void testSum() {
        System.out.println("**** sum *****");
        SparseVector another = new SparseVector();
        another.put(0, 1.0d);
        another.put(1, 2.0d);
        another.put(2, 3.0d);
        another.put(3, 4.0d);
        another.put(4, 5.0d);
        another.put(5, 0.0d);
        another.put(6, 0.0d);
        another.put(7, 0.0d);

        SparseVector instance = new SparseVector();
        instance.put(0, 1.0d);
        instance.put(1, 2.0d);
        instance.put(2, 3.0d);
        instance.put(3, 4.0d);
        instance.put(4, 5.0d);
        instance.put(5, 0.0d);
        instance.put(6, 0.0d);
        instance.put(7, 0.0d);

        SparseVector result = instance.sum(another);
        
        assertEquals(result.get(0), 2.0d, 0.001);
        assertEquals(result.get(3), 8.0d, 0.001);
        assertEquals(result.get(7), 0.0d, 0.001);
    }

}
