/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class UnionFindingWeightedWrappedPathTest {

    private UnionFindingWeightedWrappedPath uf;

    public UnionFindingWeightedWrappedPathTest() {
    }

    @Before
    public void setUp() {
        uf = new UnionFindingWeightedWrappedPath(10);
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

        uf.union(9, 7);
        assertEquals(1, uf.count());

        int expected[] = new int[10];
        expected[0] = 6;
        expected[1] = 2;
        expected[2] = 6;
        expected[3] = 4;
        expected[4] = 6;
        expected[5] = 6;
        expected[6] = 6;
        expected[7] = 6;
        expected[8] = 4;
        expected[9] = 4;
        assertArrayEquals(expected, uf.id);

        uf = new UnionFindingWeightedWrappedPath(8);

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