/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

/**
 *
 * @author mirash
 * 
 * Merge sorting without subarrays boundaries checking
 */
public class MergeHalfReverseSorting extends MergeSorting {

    MergeHalfReverseSorting() {
    }

    static void merge(Comparable[] a, int lo, int mid, int hi) {
        //Merging a[lo..mid] with a[mid+1..hi]
        int i = lo, j = hi;

        //copy a[lo..mid] to aux[lo..mid]
        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }

        //copy a[mid+1..hi] to aux[hi..mid+1] (reverse order)
        for (int k = mid + 1; k <= hi; k++) {
            aux[k] = a[(mid + hi + 1) - k];
        }

        for (int k = lo; k <= hi; k++) {

            if (less(aux[i], aux[j])) {
                a[k] = aux[i++];

            } else {
                a[k] = aux[j--];

            }
        }

    }

    //Divide and rule!!!
    static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);//sorting of right part
        sort(a, mid + 1, hi);//sorting of left part

        merge(a, lo, mid, hi);//results merging
    }

    public static synchronized void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
}
