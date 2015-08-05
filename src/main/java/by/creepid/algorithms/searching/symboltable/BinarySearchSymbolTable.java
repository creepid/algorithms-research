/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.symboltable;

import by.creepid.algorithms.basic.bags.LinkedListQueue;

/**
 *
 * @author rusakovich
 */
public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> extends BaseOrderedSymbolTable<Key, Value> {

    protected Key[] keys;
    protected Value[] vals;
    protected int n;

    public BinarySearchSymbolTable(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.vals = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value val) {
        int i = rank(key);

        //if found - update the value
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        //else shift the elements more than key
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        //insert key
        keys[i] = key;
        vals[i] = val;

        n++;

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);

        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        LinkedListQueue<Key> q = new LinkedListQueue();
        for (int i = 0; i < n; i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[n - 1];
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < n) {

            for (int j = i; j <= n; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
        }
    }

    @Override
    public Key floor(Key key) {
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return keys[mid];
            }
        }

        if (hi == -1) {
            return null;
        }

        return keys[hi];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedListQueue<Key> q = new LinkedListQueue();

        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }

        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }

        return q;
    }

}
