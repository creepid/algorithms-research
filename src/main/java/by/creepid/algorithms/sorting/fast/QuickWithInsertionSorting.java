/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.fast;

import by.creepid.algorithms.sorting.InsertionSorting;
import by.creepid.algorithms.utils.StdRandom;

/**
 *
 * @author rusakovich
 */
public class QuickWithInsertionSorting extends QuickSorting {

    private static final int CUTOFF_ARRAY_LENGTH = 4;
    
    protected QuickWithInsertionSorting(){
    }

    public static void sort(Comparable[] a) {
        // for performance garantee
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    static void sort(Comparable[] a, int lo, int hi) {
        ////ssing insertion sorting for small subarrays
        if (hi <= lo + CUTOFF_ARRAY_LENGTH) {
            InsertionSorting.sort(a, lo, hi);
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
