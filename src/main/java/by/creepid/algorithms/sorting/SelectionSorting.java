/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

/**
 *
 * @author mirash
 *
 * Uses ~(N^2/2) compare operations and N permutations
 */
public class SelectionSorting extends BaseSorting {

    SelectionSorting() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);

        }
    }
}
