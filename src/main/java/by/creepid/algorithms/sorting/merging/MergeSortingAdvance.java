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
public class MergeSortingAdvance extends MergeSortingWithoutSync {

    //see first statement
    private static final int CUTOFF_ARRAY_LENGTH = 4;

    MergeSortingAdvance() {
    }

    static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {

        //Merging a[lo..mid] with a[mid+1..hi]
        int i = lo, j = mid + 1;

        //If subarrays already sorted merge operation may be passed
        if (aux[mid].compareTo(aux[mid + 1]) <= 0) {
            for (int k = lo; k <= hi; k++) {
                a[k] = aux[i++];
            }
            return;
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

    private static class Callback {

        private Boolean needReverse;

        public Boolean isNeedReverse() {
            return needReverse;
        }

        public void setNeedReverse(Boolean needReverse) {
            this.needReverse = needReverse;
        }

    }

    private static void setNeedReverse(Boolean state, Callback callback) {
        if (callback != null) {
            callback.setNeedReverse(state);
        }
    }

    //Divide and rule!!!
    static void sort(Comparable[] a, int lo, int hi, Comparable[] aux, Callback callback) {
        if (hi <= lo) {
            return;
        }

        //Using insertion sorting for small subarrays 
        if (CUTOFF_ARRAY_LENGTH >= (hi - lo + 1)) {
            InsertionSorting.sort(a, lo, hi);
            setNeedReverse(false, callback);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        Callback lowCallback = new Callback();
        sort(a, lo, mid, aux, lowCallback);//sorting of right part

        Callback highCallback = new Callback();
        sort(a, (mid + 1), hi, aux, highCallback);//sorting of left part

        if ((lowCallback.isNeedReverse() != null && highCallback.isNeedReverse() != null)
                && lowCallback.isNeedReverse()
                && highCallback.isNeedReverse()) {

            Comparable[] temp = a;
            a = aux;
            aux = temp;

            setNeedReverse(false, callback);
        } else {
            setNeedReverse(true, callback);
        }

        merge(aux, lo, mid, hi, a);//results merging
    }

    public static synchronized void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, aux, null);
    }
}
