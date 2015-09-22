/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

import by.creepid.algorithms.searching.symboltable.LinkedListSymbolTable;
import by.creepid.algorithms.searching.symboltable.SymbolTable;

/**
 *
 * @author mirash
 *
 * Hash table with separate chaining collision solution
 */
public class SeparateChainingHashTable<Key, Value> extends AbstractHashTable<Key, Value> implements PearsonCriteria {

    private static final int DEFAULT_SIZE = 997;
    //array of linked elements table
    SymbolTable<Key, Value>[] chains;

    public SeparateChainingHashTable(int m) {
        this.m = m;
        //cause Java don't allow generic arrays
        this.chains = (LinkedListSymbolTable<Key, Value>[]) new LinkedListSymbolTable[m];
        for (int i = 0; i < m; i++) {
            chains[i] = new LinkedListSymbolTable();
        }
    }

    public SeparateChainingHashTable() {
        this(DEFAULT_SIZE);
    }

    @Override
    public Value get(Key key) {
        return (Value) chains[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value value) {
        SymbolTable<Key, Value> st = chains[hash(key)];

        int originSize = st.size();
        st.put(key, value);
        int afterSize = st.size();

        if (afterSize > originSize) {
            n++;
        }
    }

    @Override
    public void delete(Key key) {
        SymbolTable<Key, Value> st = chains[hash(key)];

        int originSize = st.size();
        st.delete(key);
        int afterSize = st.size();

        if (originSize > afterSize) {
            n--;
        }
    }

    @Override
    public double calcX2() {
        double nm = (double) n / (double) m;
        double summ = 0;

        LinkedListSymbolTable<Key, Value>[] st = (LinkedListSymbolTable<Key, Value>[]) chains;

        for (int i = 0; i < st.length; i++) {
            LinkedListSymbolTable<Key, Value> linkedListSymbolTable = st[i];

            int fi = linkedListSymbolTable.size();
            summ += (fi - nm) * (fi - nm);
        }

        summ *= ((double) m / (double) n);
        return summ;
    }

    @Override
    public boolean isRandom() {
        double x2 = calcX2();
        return ((m - Math.sqrt(m)) <= x2 && x2 >= (m - Math.sqrt(m)));
    }
}
