/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.symboltable;

/**
 *
 * @author rusakovich
 */
public class CachedBinarySearchSymbolTable<Key extends Comparable<Key>, Value> extends BinarySearchSymbolTable<Key, Value> {

    private Key keyLastUsed;
    private int rankLastUsed;

    public CachedBinarySearchSymbolTable(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized void put(Key key, Value val) {
        if (keyLastUsed != null && keyLastUsed.compareTo(key) == 0) {
            vals[rankLastUsed] = val;
            return;
        }

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

        keyLastUsed = key;
        rankLastUsed = i;

        n++;

    }

    @Override
    public synchronized Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        if (keyLastUsed != null && keyLastUsed.compareTo(key) == 0) {
            return vals[rankLastUsed];
        }

        int i = rank(key);

        if (i < n && keys[i].compareTo(key) == 0) {
            keyLastUsed = key;
            rankLastUsed = i;
            return vals[i];
        } else {
            return null;
        }
    }

}
