/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class StdDrawTest {

    public StdDrawTest() {
    }

    public static void main(String[] args) {
        int n = 500;

        double[] a = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }

        for (int i = 0; i < n; i++) {
            double x = 1.0 * i / n;
            double y = a[i] / 2;
            
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;

            StdDraw.filledRectangle(x, y, rw, rh);
        }

    }

}
