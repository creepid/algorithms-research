/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class SparseMartrixTest {

    public SparseMartrixTest() {
    }

    /**
     * Test of sum method, of class SparseMartrix.
     */
    @Test
    public void testSum() {
        System.out.println("**** sum ****");
        SparseMatrix instance = new SparseMatrix();

        SparseVector sv0 = new SparseVector();
        instance.put(0, sv0);
        SparseVector sv1 = new SparseVector();
        sv1.put(1, 1.0d);
        instance.put(1, sv1);

        SparseMatrix another = new SparseMatrix();

        SparseVector asv0 = new SparseVector();
        another.put(0, asv0);
        SparseVector asv1 = new SparseVector();
        asv1.put(1, 2.0d);
        another.put(1, asv1);

        SparseMatrix result = instance.sum(another);
        assertEquals(3.0, result.get(1).get(1), 0.001);
        assertEquals(0.0, result.get(0).get(0), 0.001);
        assertEquals(0.0, result.get(0).get(1), 0.001);
        assertEquals(0.0, result.get(1).get(0), 0.001);
    }

    /**
     * Test of mult method, of class SparseMartrix.
     */
    @Test
    public void testMult() {
        System.out.println("**** mult ****");
        SparseMatrix instance = new SparseMatrix();

        SparseVector sv0 = new SparseVector();
        sv0.put(1, 1.0d);
        instance.put(0, sv0);

        SparseVector sv1 = new SparseVector();
        sv1.put(0, 3.0d);
        instance.put(1, sv1);

        SparseVector sv2 = new SparseVector();
        sv2.put(2, 4.0d);
        instance.put(2, sv2);

        //another matrix        
        SparseMatrix another = new SparseMatrix();

        SparseVector asv0 = new SparseVector();
        asv0.put(0, 2.0d);
        asv0.put(1, 2.0d);
        another.put(0, asv0);

        SparseVector asv1 = new SparseVector();
        asv1.put(0, 5.0d);
        asv1.put(2, 3.0d);
        another.put(1, asv1);

        SparseVector asv2 = new SparseVector();
        another.put(2, sv2);

        //mult
        SparseMatrix result = instance.mult(another);
        
        assertEquals(5.0, result.get(0).get(0), 0.001);
        assertEquals(6.0, result.get(1).get(1), 0.001);
        assertEquals(6.0, result.get(1).get(0), 0.001);
        assertEquals(3.0, result.get(0).get(2), 0.001);

    }

}
