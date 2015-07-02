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
 */
public class QuickSortingSignalKeys extends QuickSorting {

    protected QuickSortingSignalKeys() {
    }

    public static void sort(Comparable[] a) {
        // for performance garantee
        StdRandom.shuffle(a);

        //searching for max element
        int i = 0;
        int max = 0;
        while (i < a.length - 1) {
            if (less(a[max], a[++i])) {
                max = i;
            }
        }
        //place max on right bound of array 
        exch(a, max, a.length - 1);

        sort(a, 0, a.length - 1);
    }

    //division method
    static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            //browse right side
            while (less(a[++i], v));
            //browse left side
            while (less(v, a[--j]));
            //checking if the end
            if (i >= j) {
                break;
            }
            //exchanging
            exch(a, i, j);
        }
        //Put v = a[j] on his own place
        exch(a, lo, j);

        return j;
    }

    static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //dividing
        int j = partition(a, lo, hi);
        //left side sorting
        sort(a, lo, j - 1);
        //rignt side sorting
        sort(a, j + 1, hi);
    }

}
