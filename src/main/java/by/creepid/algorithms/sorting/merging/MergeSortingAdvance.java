/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import by.creepid.algorithms.sorting.InsertionSorting;

/**
 *
 * @author mirash
 *
 * Improvements:
 *
 * 1. Using insertion sorting for small subarrays 2. If subarrays already sorted
 * merge operation may be passed (linear execution time) 3. Helper array (aux)
 * copy deny
 */
public class MergeSortingAdvance extends MergeSorting {

    //see first statement
    private static final int CUTOFF_ARRAY_LENGTH = 15;

    MergeSortingAdvance() {
    }

    static void merge(Comparable[] a, int lo, int mid, int hi) {
        //Merging a[lo..mid] with a[mid+1..hi]
        int i = lo, j = mid + 1;

        //copy a[lo..hi] to aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];

            } else if (j > hi) {
                a[k] = aux[i++];

            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];

            } else {
                a[k] = aux[i++];
            }
        }
    }

    //Divide and rule!!!
    static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        //Using insertion sorting for small subarrays
        if (a.length <= CUTOFF_ARRAY_LENGTH) {
            InsertionSorting.sort(a);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);//sorting of right part
        sort(a, mid + 1, hi);//sorting of left part

        //If subarrays already sorted merge operation may be passed (linear execution time)
        if (a[mid].compareTo(a[mid + 1]) <= 0) {
            return;
        }

        merge(a, lo, mid, hi);//results merging
    }

    public static synchronized void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
}
