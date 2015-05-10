/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import by.creepid.algorithms.utils.DataHelper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.util.StopWatch;

/**
 *
 * @author mirash
 */
public class TreeSumTest {

    public TreeSumTest() {
    }

    /**
     * Test of countSimple method, of class TreeSum.
     */
    @Test
    public void testCountSimple() {
        System.out.println("****** countSimple *******");
        StopWatch stopWatch = new StopWatch("countSimple");

        int[] arr = DataHelper.getIntArray("1Kints.txt");
        int expResult = 70;

        stopWatch.start("1000 numbers");
        int result = TreeSum.countSimple(arr);
        stopWatch.stop();

        assertEquals(expResult, result);

        arr = DataHelper.getIntArray("2Kints.txt");
        expResult = 528;

        stopWatch.start("2000 numbers");
        result = TreeSum.countSimple(arr);
        stopWatch.stop();

        assertEquals(expResult, result);

        arr = DataHelper.getIntArray("4Kints.txt");
        expResult = 4039;

        stopWatch.start("4000 numbers");
        result = TreeSum.countSimple(arr);
        stopWatch.stop();

        assertEquals(expResult, result);

        arr = DataHelper.getIntArray("8Kints.txt");

        stopWatch.start("8000 numbers");
        result = TreeSum.countSimple(arr);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}