/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import by.creepid.algorithms.sorting.BaseSorting;

/**
 *
 * @author rusakovich
 *
 * Main idea: kendall tau of arrangement and identity arrangement (where element
 * = order number) is reverse count;
 */
public class KendallTau {

    private final Comparable[] oneArr;
    private final Comparable[] anotherArr;
    private final int n;
    private int tau = 0;

    public KendallTau(Comparable[] oneArr, Comparable[] anotherArr) {
        this.oneArr = oneArr;
        this.anotherArr = anotherArr;

        n = oneArr.length;
        calc();
    }

    private boolean notSameOrder(Comparable v, Comparable w) {
        int vIndex = 0;
        int wIndex = 0;

        for (int i = 0; i < anotherArr.length; i++) {
            Comparable curr = anotherArr[i];

            if (v.compareTo(curr) == 0) {
                vIndex = i;
                continue;
            }

            if (w.compareTo(curr) == 0) {
                wIndex = i;
            }

        }

        return vIndex < wIndex;
    }

    private void calc() {
        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0 && notSameOrder(oneArr[j], oneArr[j - 1]); j--) {
                tau++;
                BaseSorting.exch(oneArr, j, j - 1);
            }

        }
    }

    public int getTau() {
        return tau;
    }

}
