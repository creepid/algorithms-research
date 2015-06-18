/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import by.creepid.algorithms.sorting.BaseSorting;

/**
 *
 * @author mirash
 *
 * Merge sorting without helper array synchronization
 */
public class MergeSortingWithoutSync extends BaseSorting {

    MergeSortingWithoutSync() {
    }

    static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
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
    static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid, aux);//sorting of right part
        sort(a, mid + 1, hi, aux);//sorting of left part

        merge(a, lo, mid, hi, aux);//results merging
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, aux);
    }
}
