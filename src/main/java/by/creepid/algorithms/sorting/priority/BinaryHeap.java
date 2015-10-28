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
 *
 * Priority queue with n keys. 1. Not more (1 + lgN) compares for insert
 * operation 2. Not more 2lgN for extract operation
 *
 * NB: Breakthrough: guarantee insertion and extract for lgN time
 */
public class BinaryHeap<Key extends Comparable<Key>> implements PriorityQueue<Key> {

    protected final Key[] keys;
    protected int n = 0;

    public BinaryHeap(int maxN) {
        this.keys = (Key[]) new Comparable[maxN + 1];
    }

    public BinaryHeap(Key[] pq) {
        this.keys = (Key[]) new Comparable[pq.length + 1];
        for (int i = 0; i < pq.length; i++) {
            this.keys[i + 1] = pq[i];
        }
        n = pq.length;
    }

    /**
     * Compare i and j element
     *
     * @param i - first element
     * @param j - second element
     * @return result of compare
     */
    protected boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    /**
     * Elements exchanging
     *
     * @param i - element to shift
     * @param j - exchanging element
     */
    protected void exch(int i, int j) {
        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    /**
     * Exchanging child with most suitable parent
     *
     * @param k - element to swim
     */
    protected void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * Exchanging parent with most suitable child
     *
     * @param k - element to sink
     */
    protected void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if ((j + 1) < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    @Override
    public void insert(Key key) {
        keys[++n] = key;
        swim(n);
    }

    @Override
    public Key max() {
        return keys[1];
    }

    @Override
    public Key deleteMax() {
        Key max = keys[1];
        //last exchanging with root
        exch(1, n--);
        //free memory
        keys[n + 1] = null;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    /**
     * Sorting method
     *
     * ~ 2N compares for pyramid creation ~ N appeals
     */
    @Override
    public Key[] getSorted() {
        for (int k = n / 2; k >= 1; --k) {
            sink(k);
        }

        while (n > 1) {
            exch(1, n--);
            sink(1);
        }

        return Arrays.copyOfRange(keys, 1, keys.length);
    }
}
