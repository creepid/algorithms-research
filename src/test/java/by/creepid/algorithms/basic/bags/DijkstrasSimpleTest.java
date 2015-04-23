/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class DijkstrasSimpleTest {

    /**
     * Test of getResult method, of class DijkstrasSimple.
     */
    @Test
    public void testGetResult() {
        String eval = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        double expected = 101.0;
        double actual = new DijkstrasSimple(eval).getResult();
        assertEquals(expected, actual, 0.0);

        eval = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        expected = 1.618;
        actual = new DijkstrasSimple(eval).getResult();
        System.out.println(actual);
        assertEquals(expected, actual, 0.001);
    }

}
