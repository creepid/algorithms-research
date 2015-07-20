/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class KendallTauTest {

    public KendallTauTest() {
    }

    /**
     * Test of getTau method, of class KendallTau.
     */
    @Test
    public void testGetTau() {
        Integer[] one = {0, 3, 1, 6, 2, 5, 4};
        Integer[] another = {1, 0, 3, 6, 4, 2, 5};

        int tau = new KendallTau(one, another).getTau();
        assertEquals(4, tau);
    }

}
