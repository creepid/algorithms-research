/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.searching.symboltable;

/**
 *
 * @author rusakovich
 */
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    Key min();

    Key max();

    //the largest key less than or equal to key 
    Key floor(Key key);

    //the smallest key greater than or equal to key
    Key ceiling(Key key);

    //number of key less than key
    int rank(Key key);

    //get k-rang key
    Key select(int k);

    void deleteMin();

    void deleteMax();

    /**
     * Number of keys in interval [lo..hi]
     *
     * @param lo - low edge
     * @param hi - hi edge
     * @return interval size
     */
    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);

}
