/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class UnionFindingFastUnionTest {

    private UnionFinding uf;

    public UnionFindingFastUnionTest() {
    }

    @Before
    public void setUp() {
        uf = new UnionFindingFastUnion(10);
    }

    @Test
    public void testUnion() {
        System.out.println("**** union *****");
        int p = 4;
        int q = 3;
        uf.union(p, q);
        assertTrue(uf.connected(p, q));
    }

    /**
     * Test of find method, of class UnionFindingFastSearch.
     */
    @Test
    public void testFind() {
        System.out.println("**** find ****");
        int p = 3;
        int expResult = 3;
        int result = uf.find(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of connected method, of class UnionFindingFastSearch.
     */
    @Test
    public void testConnected() {
        System.out.println("**** connected ****");
        int p = 4;
        int q = 3;
        uf.union(p, q);
        assertTrue(uf.connected(p, q));

        p = 8;
        q = 5;
        assertFalse(uf.connected(p, q));
    }
}