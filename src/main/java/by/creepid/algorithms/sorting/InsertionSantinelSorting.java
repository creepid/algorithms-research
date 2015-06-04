/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

/**
 *
 * @author rusakovich
 *
 * Insertion sorting with marker (first min element)
 */
public class InsertionSantinelSorting extends InsertionSorting {

    InsertionSantinelSorting() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (less(a[i], a[minIndex])) {
                minIndex = i;
            }
        }
        exch(a, 0, minIndex);

        for (int i = 1; i < n; i++) {

            //Insert a[i] among a[i-1], a[i-2], a[i-3], ...
            //remove  (j > 0) condition
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }
    }

}
