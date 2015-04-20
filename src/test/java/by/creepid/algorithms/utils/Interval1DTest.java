 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.utils;

import org.junit.Test;

/**
 *
 * @author mirash
 */
public class Interval1DTest {

    /**
     * Test of intersects method, of class Interval1D.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects");
        Interval1D[] intervals = new Interval1D[6];

        intervals[0] = new Interval1D(4.0, 13.0);
        intervals[1] = new Interval1D(-42.3, 2.7);
        intervals[2] = new Interval1D(13.1, 27.0);
        intervals[3] = new Interval1D(-3.0, 1.0);
        intervals[4] = new Interval1D(-15.0, -12.0);
        intervals[5] = new Interval1D(14.2, 14.5);

        for (int i = 0; i < intervals.length; i++) {
            Interval1D curr = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                Interval1D next = intervals[j];

                if (curr.intersects(next)) {
                    System.out.println(curr.toString() + " intersects " + next.toString());
                }

            }
        }
    }
}