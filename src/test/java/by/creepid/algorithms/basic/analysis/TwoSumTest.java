/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import by.creepid.algorithms.utils.DataHelper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.util.StopWatch;

/**
 *
 * @author rusakovich
 */
public class TwoSumTest {

    public TwoSumTest() {
    }

    /**
     * Test of countFast method, of class TwoSum.
     */
    @Test
    public void testCountFast() {
        System.out.println("****** countFast *******");
        StopWatch stopWatch = new StopWatch("countSimple");

        int[] arr = DataHelper.getIntArray("8Kints.txt");

        int expResult = 19;

        stopWatch.start("4000 numbers");
        int result = TwoSum.countFast(arr);
        stopWatch.stop();

        assertEquals(expResult, result);

        System.out.println(stopWatch.prettyPrint());
    }

}
