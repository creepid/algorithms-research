/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class JosephusFlaviusSolutionTest {

    /**
     * Test of getExitQueue method, of class JosephusFlaviusSolution.
     */
    @Test
    public void testGetExitQueue() {
        JosephusFlaviusSolution jf = null;
        List<Integer> result = null;
        int[] resultArr = null;

        jf = new JosephusFlaviusSolution(7, 2);
        result = jf.getExitOrder();
        resultArr = this.convertIntegers(result);
        Assert.assertArrayEquals(new int[]{1, 3, 5, 0, 4, 2, 6}, resultArr);

        jf = new JosephusFlaviusSolution(7, 1);
        result = jf.getExitOrder();
        resultArr = this.convertIntegers(result);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6}, resultArr);

        jf = new JosephusFlaviusSolution(7, 3);
        result = jf.getExitOrder();
        resultArr = this.convertIntegers(result);
        Assert.assertArrayEquals(new int[]{2, 5, 1, 6, 4, 0, 3}, resultArr);

        jf = new JosephusFlaviusSolution(8, 3);
        result = jf.getExitOrder();
        resultArr = this.convertIntegers(result);
        Assert.assertArrayEquals(new int[]{2, 5, 0, 4, 1, 7, 3, 6}, resultArr);

    }

    private int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}
