/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

import java.util.Arrays;

/**
 *
 * @author rusakovich
 */
public class TernaryHeap<Key extends Comparable<Key>> extends BinaryHeap<Key> {

    public TernaryHeap(int maxN) {
        super(maxN);
    }

    public TernaryHeap(Key[] pq) {
        super(pq);
    }

    /**
     * Exchanging child with most suitable parent
     *
     * @param k - element to swim
     */
    @Override
    protected void swim(int k) {
        while (k > 1 && less((k + 1) / 3, k)) {
            exch((k + 1) / 3, k);
            k = (k + 1) / 3;
        }
    }

    /**
     * Exchanging parent with most suitable child
     *
     * @param k - element to sink
     */
    @Override
    protected void sink(int k) {
        while ((3 * k - 1) <= n) {
            int j = 3 * k - 1;

            if ((j + 1) <= n && less(j, j + 1)) {
                j++;
                if ((j + 1) <= n && less(j, j + 1)) {
                    j++;
                }
            } else if ((j + 2) <= n && less(j, j + 2)) {
                j += 2;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    /**
     * Sorting method
     *
     * ~ 2N compares for pyramid creation ~ N appeals
     */
    @Override
    public Key[] getSorted() {
        for (int k = (n + 1) / 3; k >= 1; --k) {
            sink(k);
        }

        while (n > 1) {
            exch(1, n--);
            sink(1);
        }

        return Arrays.copyOfRange(keys, 1, keys.length);
    }

}
