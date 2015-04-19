/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

/**
 *
 * @author mirash
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int countLessThen(double key, double[] a) {
        if (a == null) {
            throw new IllegalStateException("Array must not be null!");
        }

        int lo = 0;
        int hi = a.length;

        int start = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key == a[mid]) {
                start = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (start == -1) {
            throw new IllegalStateException("No key found");
        }

        return start;
    }

    public static int count(double key, double[] a) {
        if (a == null) {
            throw new IllegalStateException("Array must not be null!");
        }

        int lo = 0;
        int hi = a.length;

        int start = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key == a[mid]) {
                start = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (start == -1) {
            throw new IllegalStateException("No key found");
        }

        lo = 0;
        hi = a.length;

        int end = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key == a[mid]) {
                end = mid;
                lo = mid + 1;
            } else {
                lo = mid + 1;
            }
        }

        return end - start + 1;
    }
}
