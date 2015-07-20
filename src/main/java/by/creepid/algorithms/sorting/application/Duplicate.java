/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import by.creepid.algorithms.sorting.fast.QuickSorting;

/**
 *
 * @author rusakovich
 */
public class Duplicate {

    private Duplicate() {
    }

    public static int getVariousCount(Comparable[] a) {
        QuickSorting.sort(a);
        int count = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) != 0) {
                count++;
            }
        }

        return count;
    }

    public static int getDuplicateCount(Comparable[] a) {
        return a.length - getVariousCount(a);
    }

}
