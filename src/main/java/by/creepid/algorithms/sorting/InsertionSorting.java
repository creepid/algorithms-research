/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

/**
 *
 * @author mirash
 *
 * (!!!) Strongly depends on primary element order
 *
 * On average uses ~N^2/2 compare operations and ~N^2/2 permutations. In best
 * case: (N-1) compare operations and 0 permutations.
 *
 * Suitable for partially ordered data.
 *
 */
public class InsertionSorting extends BaseSorting {

    InsertionSorting() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {

            //Insert a[i] among a[i-1], a[i-2], a[i-3], ...
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }
    }

    public static void sort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {

            //Insert a[i] among a[i-1], a[i-2], a[i-3], ...
            for (int j = i; j>0 && a[j] != null && a[j - 1] != null && j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }
    }
}
