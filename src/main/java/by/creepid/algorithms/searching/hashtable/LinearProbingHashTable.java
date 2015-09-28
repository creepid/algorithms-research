/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

import by.creepid.algorithms.basic.bags.LinkedListQueue;

/**
 *
 * @author mirash
 */
public class LinearProbingHashTable<Key, Value> extends AbstractHashTable<Key, Value> {

    private static final int START_SIZE = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashTable() {
        this(START_SIZE);
    }

    public LinearProbingHashTable(int size) {
        this.m = size;
        this.keys = (Key[]) new Object[m];
        this.vals = (Value[]) new Object[m];
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    private void resize(int newCapacity) {
        Key[] keysTemp = (Key[]) new Object[newCapacity];
        Value[] valsTemp = (Value[]) new Object[newCapacity];

        for (int i = 0; i < m; i++) {
            keysTemp[i] = this.keys[i];
            valsTemp[i] = this.vals[i];
        }

        this.keys = keysTemp;
        this.vals = valsTemp;
    }

    @Override
    public void put(Key key, Value value) {
        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }

        keys[i] = key;
        vals[i] = value;
        n++;

    }

    public boolean contains(Key key) {
        int i = hash(key);
        int iterations = m;
        for (i = hash(key); keys[i] != null && iterations > 0; i = (i + 1) % m) {
            iterations--;
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    //best case - when clusters is small
    @Override
    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToMove = keys[i];
            Value valToMove = vals[i];

            keys[i] = null;
            vals[i] = null;

            n--;

            put(keyToMove, valToMove);
            i = (i + 1) % m;
        }

        n--;

        if (n > 0 && n == m / 8) {
            resize(m / 2);
        }
    }

    public int size() {
        return this.n;
    }

    public Iterable<Key> keys() {
        LinkedListQueue<Key> queue = new LinkedListQueue<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }
}
