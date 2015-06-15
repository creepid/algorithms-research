/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.merging;

/**
 *
 * @author rusakovich
 *
 * Main leak of standard merge sorting: too many little subarrays to merge.
 * Better solution: 1. Merge arrays 1 length 2. Merge arrays 2 length 3.Merge
 * arrays 4 length 4. and more...
 *
 * T1: While sorting every n-length array lowdown merge sorting uses from
 * 1/2NlgN to NlgN comparations
 *
 * T2:Uses not more 6NlgN array appeals
 * 
 * Helpful with linked list-based data
 */
public class BottomUpMergeSorting extends MergeSorting {

    public static synchronized void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];

        //size - subarray length
        for (int size = 1; size < n; size = size + size) {
            //lo -  index in subarray
            for (int lo = 0; lo < (n - size); lo += (size + size)) {
                merge(a, lo, lo + size - 1, Math.min(lo + (size + size) - 1, n - 1));
            }
        }
    }

}
