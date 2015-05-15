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
public class Arrays {

    private Arrays() {
    }

    private static void checkArray(double[] a) {
        if (a == null) {
            throw new IllegalStateException("Array must not be null!");
        }
    }

    public static double max(double[] a) {
        checkArray(a);

        double max = a[0];
        for (int i = 0; i < a.length; i++) {
            double current = a[i];
            if (current > max) {
                max = a[i];
            }
        }

        return max;
    }

    public static double average(double[] a) {
        checkArray(a);

        int n = a.length;

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        return sum / n;
    }

    public static double[] copy(double[] source) {
        checkArray(source);

        int n = source.length;
        double[] target = new double[n];

        for (int i = 0; i < target.length; i++) {
            target[i] = source[i];
        }

        return target;
    }

    public static double[] reverse(double[] a) {
        checkArray(a);

        int n = a.length;

        for (int i = 0; i < (n / 2); i++) {
            double temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }

        return a;
    }

    public static int binarySearchRank(int key, int[] a) {
        double[] ad = Primitive.copyFromIntArray(a);
        return binarySearchRank(key, ad);
    }

    public static int binarySearchRank(double key, double[] a) {
        checkArray(a);

        int lo = 0;
        int hi = a.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == a.length) {
                break;
            }

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
