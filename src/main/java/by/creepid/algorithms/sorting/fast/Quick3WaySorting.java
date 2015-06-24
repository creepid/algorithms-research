/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.fast;

import by.creepid.algorithms.utils.StdRandom;

/**
 *
 * @author rusakovich
 * 
 * Effective in array with essential part of equal elements  
 */
public class Quick3WaySorting extends QuickSorting {

    protected Quick3WaySorting() {
    }

    public static void sort(Comparable[] a) {
        // for performance garantee
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);

            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }

            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);
        }
    }

}
