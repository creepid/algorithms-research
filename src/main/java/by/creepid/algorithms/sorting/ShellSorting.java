/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

/**
 *
 * @author mirash
 *
 * Suitable for big data procession
 * Performance - unknown
 */
public class ShellSorting extends InsertionSorting {

    private ShellSorting() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;//1, 4, 13, 40, 121, 364, 1093, ...
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                //insert a[i] between a[i-h], a[i-2*h], a[i-3*h], ...
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }
}
