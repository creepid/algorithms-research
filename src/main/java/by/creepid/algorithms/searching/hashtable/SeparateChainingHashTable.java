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
public class SeparateChainingHashTable<Key, Value> extends AbstractHashTable<Key, Value>{

    private static final int DEFAULT_SIZE = 997;
    //array of linked elements table
    private SymbolTable<Key, Value>[] chains;

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
    public void put(Key key, Value value){
        chains[hash(key)].put(key, value);
    }

    @Override
    public void delete(Key key) {
         chains[hash(key)].delete(key);
    }
    
    
}
