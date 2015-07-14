/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import by.creepid.algorithms.sorting.fast.QuickSorting;
import by.creepid.algorithms.utils.StdRandom;

/**
 *
 * @author rusakovich
 */
public class Median {
    
    protected Median(){
    }

    /**
     * Selects j min elements
     *
     * @param a - array to search
     * @param k - min numbers count
     * @return median element
     */
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = QuickSorting.partition(a, lo, hi);
            if (j == k) {
                return a[k];
            } else if (j > k) {
                hi = j - 1;
            } else if (j < k) {
                lo = j + 1;
            }
        }

        return a[k];
    }

}
