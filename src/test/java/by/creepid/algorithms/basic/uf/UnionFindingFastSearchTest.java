/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class UnionFindingFastSearchTest {

    private UnionFinding uf;

    public UnionFindingFastSearchTest() {
    }

    @Before
    public void setUp() {
        uf = new UnionFindingFastSearch(10);
    }

    /**
     * Test of count method, of class UnionFindingFastSearch.
     */
    @Test
    public void testCount() {
        System.out.println("**** count ****");
        int expResult = 2;

        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);

        assertEquals(expResult, uf.count());
    }

    /**
     * Test of union method, of class UnionFindingFastSearch.
     */
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