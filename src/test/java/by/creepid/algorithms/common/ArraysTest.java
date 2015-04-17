/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.common;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class ArraysTest {

    public ArraysTest() {
    }

    @Test
    public void testBinarySearchSimple() {
        double[] arr = {-23.0, -11.4, -5, 3, 5, 12, 56};
        int index = Arrays.binarySearchRank(5, arr);
        assertEquals(4, index);
    }

}
