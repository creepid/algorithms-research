/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

import by.creepid.algorithms.sorting.BaseSorting;

/**
 *
 * @author rusakovich
 *
 * Execution time: ~ Nlog(N) Memory consumption: ~N
 *
 * T1: While sorting every n-length array lowdown merge sorting uses from
 * 1/2NlgN to NlgN comparations
 *
 * T2:Uses not more 6NlgN array appeals
 */
public class MergeSorting extends BaseSorting {

    //array-helper for merging
    protected static Comparable[] aux;

    MergeSorting() {
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
    private static void sort(Comparable[] a, int lo, int hi) {
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
