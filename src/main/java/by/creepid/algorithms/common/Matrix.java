/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.common;

/**
 *
 * @author rusakovich
 */
public class Matrix {
    
    private Matrix(){
    }

    private static void checkMatrix(double[][] a) {
        if (a == null) {
            throw new IllegalStateException("Array must note be empty!");
        }
    }

    //@see http://pcfu.ru/peremnozhenie-kvadratnyx-matric/
    public static double[][] squareMatrixMultiplex(double[][] a, double[][] b) {
        checkMatrix(a);
        checkMatrix(b);

        int aLen = a.length;
        if (aLen != a[0].length) {
            throw new IllegalStateException("First matrix is not square");
        }

        int bLen = b.length;
        if (bLen != b[0].length) {
            throw new IllegalStateException("Second matrix is not square");
        }

        if (aLen != bLen) {
            throw new IllegalStateException("Not fittable matrix to muliplex");
        }

        double[][] c = new double[aLen][aLen];

        for (int i = 0; i < aLen; i++) {

            for (int j = 0; j < aLen; j++) {

                for (int k = 0; k < aLen; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }

            }
        }

        return c;
    }

}
