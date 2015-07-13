/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

/**
 *
 * @author rusakovich
 *
 * Gives access to elements, that already exists in queue. Useful when client is
 * processing some set with defined length, and, perhaps, using arrays for
 * storing infos about this elements.
 * @param <Key> - Storing element type
 */
public class IndexedPriorityQueue<Key extends Comparable<Key>> extends BinaryHeap<Key> implements Indexed<Key> {

    //storing indexes
    private int[] pq;//binary heap with 1 indexation 
    private int[] qp;//qp[pq[i]] == pq[qp[i]] == i

    public IndexedPriorityQueue(int maxN) {
        super(maxN);
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];

        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;//qp[i] == -1 => i not in queue
        }
    }

    @Override
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    @Override
    public void insert(int k, Key key) {
        n++;

        qp[k] = n;
        pq[n] = k;

        keys[k] = key;

        swim(n);
    }

    @Override
    public Key min() {
        return keys[pq[1]];
    }

    @Override
    public int deleteMin() {
        int indexOfMin = pq[1];

        exch(1, n--);
        sink(1);

        keys[pq[n + 1]] = null;
        qp[pq[n + 1]] = -1;
        pq[n + 1] = -1;

        return indexOfMin;
    }

    @Override
    protected void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    @Override
    protected void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    protected boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    @Override
    protected void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

}
