/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.common;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class MatrixTest {

    @Test
    public void testSquareMatrixMultiplex() {
        double[][] a = new double[][]{
            {1, -1},
            {2, 0},};

        double[][] b = new double[][]{
            {1, 1},
            {2, 0},};

        double[][] c = Matrix.squareMatrixMultiplex(a, b);

        double delta = 0.01;

        double[] expected0 = {-1.0d, 1.0d};
        Assert.assertArrayEquals(expected0, c[0], delta);
        double[] expected1 = {2.0d, 2.0d};
        Assert.assertArrayEquals(expected1, c[1], delta);

    }

}
