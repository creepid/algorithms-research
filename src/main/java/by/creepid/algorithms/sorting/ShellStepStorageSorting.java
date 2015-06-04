/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting;

import by.creepid.algorithms.basic.bags.LinkedListStack;
import by.creepid.algorithms.basic.bags.Stack;

/**
 *
 * @author rusakovich
 */
public class ShellStepStorageSorting extends ShellSorting {

    private ShellStepStorageSorting() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;

        Stack<Integer> steps = new LinkedListStack();
        steps.push(h);

        while (h < n / 3) {
            h = 3 * h + 1;//1, 4, 13, 40, 121, 364, 1093, ...
            steps.push(h);
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                //insert a[i] between a[i-h], a[i-2*h], a[i-3*h], ...
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            try {
                h = steps.pop();
            } catch (Throwable thr) {
                h = 0;
            }

        }
    }

}
