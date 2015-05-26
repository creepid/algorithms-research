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
public class UnionFindingWeightedTest {

    private UnionFinding uf;

    public UnionFindingWeightedTest() {
    }

    @Before
    public void setUp() {
        uf = new UnionFindingWeighted(10);
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

        uf = new UnionFindingWeighted(8);

        expResult = 1;

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(0, 2);
        uf.union(4, 6);
        uf.union(0, 4);

        assertEquals(expResult, uf.count());

    }
}